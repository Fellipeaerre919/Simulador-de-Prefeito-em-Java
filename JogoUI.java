package PrefeitoSimulator;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class JogoUI {

    // ─── Constantes ───────────────────────────────────────────────
    private static final Color COR_BLOCO       = new Color(0, 68, 148, 210);
    private static final Color COR_BORDA       = new Color(255, 255, 255);
    private static final Color COR_EVENTO      = new Color(82, 131, 178);
    private static final Color COR_BOTAO       = new Color(42, 65, 84);
    private static final int   LIMITE_VERDE    = 70;
    private static final int   LIMITE_AMARELO  = 30;
    private static final int   LARGURA_LATERAL = 370;
    private static final int   RAIO_PAINEL     = 40;
    private static final int   RAIO_CONTEUDO   = 30;
    private static final int   RAIO_BARRA      = 20;
    private static final int   RAIO_BOTAO      = 30;

    // ─── Dependências ─────────────────────────────────────────────
    private Jogo jogo;

    // ─── Variáveis ────────────────────────────────────────────────
    private JFrame       janela;
    private JLabel       labelStatus;
    private JTextArea    textoEvento;
    private JLabel       imagemEvento;
    private JProgressBar barAmbiente, barEconomia, barPopulacao, barAprovacao;
    private JLabel       labelAmbiente, labelEconomia, labelPopulacao, labelAprovacao;
    private JButton[]    botoes;
    private JButton      botaoProximo;
    private Evento       eventoAtual;
    private JButton botaoFechar;

    // CardLayout principal — alterna entre INICIO, JOGO e FIM
    private CardLayout cardPrincipal;
    private JPanel     painelPrincipal;

    // CardLayout dos botões — alterna entre escolhas e próximo
    private CardLayout cardBotoes;
    private JPanel     painelBotoes;

    // Labels de fim de jogo — atualizados em verificarFimDeJogo()
    private JLabel textoFim;
    private JLabel labelFimResultado;
    private JLabel labelFimAmbiente, labelFimEconomia, labelFimPopulacao, labelFimAprovacao;

    // Fade — glass pane escurece e clareia na troca de tela
    private JPanel glassPane;
    private float  alphaFade = 0f;

    // Construtor
    public JogoUI(Jogo jogo) {
        this.jogo = jogo;
    }

    // Inicialização
    public void iniciar() {
        janela = new JFrame("Prefeito Simulator");
        UIManager.put("ProgressBar.selectionForeground", Color.BLACK);
        UIManager.put("ProgressBar.selectionBackground", Color.BLACK);
        janela.setMinimumSize(new Dimension(800, 600));
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // FUNDO — imagem cobre a janela inteira
        JPanel fundoPainel = new JPanel(new BorderLayout()) {
            Image img = new ImageIcon("PrefeitoSimulator/imagens/cidade2.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // CardLayout principal — empilha as três telas
        cardPrincipal   = new CardLayout();
        painelPrincipal = new JPanel(cardPrincipal);
        painelPrincipal.setOpaque(false);

        painelPrincipal.add(criarPainelInicio(), "INICIO");
        painelPrincipal.add(criarPainelJogo(),   "JOGO");
        painelPrincipal.add(criarPainelFim(),    "FIM");

        // Espaçadores laterais — transparentes, deixam a imagem aparecer
        fundoPainel.add(espacador(LARGURA_LATERAL), BorderLayout.WEST);
        fundoPainel.add(painelPrincipal,            BorderLayout.CENTER);
        fundoPainel.add(espacador(LARGURA_LATERAL), BorderLayout.EAST);

        // Glass pane — painel preto invisível que escurece na troca de tela
        glassPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alphaFade));
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());
                g2.dispose();
            }
        };
        glassPane.setOpaque(false);
        janela.setGlassPane(glassPane);
        glassPane.setVisible(true);

        janela.setContentPane(fundoPainel);
        cardPrincipal.show(painelPrincipal, "INICIO");
        janela.setVisible(true);
        GraphicsEnvironment.getLocalGraphicsEnvironment()
            .getDefaultScreenDevice()
            .setFullScreenWindow(janela); // abre em tela cheia
    }

    // Fade de saída → troca tela → fade de entrada
    private void trocarTela(String nomeTela) {
        Timer sair = new Timer(16, null);
        sair.addActionListener(e -> {
            alphaFade += 0.05f; // escurece gradualmente
            if (alphaFade >= 1f) {
                alphaFade = 1f;
                sair.stop();
                cardPrincipal.show(painelPrincipal, nomeTela); // troca a tela
                entrarTela(); // começa a clarear
            }
            glassPane.repaint();
        });
        sair.start();
    }

    private void entrarTela() {
        Timer entrar = new Timer(16, null);
        entrar.addActionListener(e -> {
            alphaFade -= 0.05f; // clareia gradualmente
            if (alphaFade <= 0f) {
                alphaFade = 0f;
                entrar.stop();
            }
            glassPane.repaint();
        });
        entrar.start();
    }

    // Tela de início
    private JPanel criarPainelInicio() {
        JPanel painel = painelArredondado(COR_BLOCO, RAIO_PAINEL, true);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // texto de boas-vindas com html
        JLabel titulo = new JLabel("<html><center>Bem-vindo ao<br>Prefeito Simulator!</center></html>", SwingConstants.CENTER);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 32));

        // imagem de início
        JLabel imagemInicio = new JLabel();
        imagemInicio.setHorizontalAlignment(SwingConstants.CENTER);
        Image logoOriginal = new ImageIcon("PrefeitoSimulator/imagens/logo.png").getImage();
        Image logoEscalada = logoOriginal.getScaledInstance(520, 430, Image.SCALE_SMOOTH);
        imagemInicio.setIcon(new ImageIcon(logoEscalada));

        // botão iniciar — troca para a tela do jogo com fade
        JButton botaoIniciar = new JButton("Iniciar");
        estilizarBotao(botaoIniciar);
        botaoIniciar.addActionListener(e -> {
            carregarEvento();
            trocarTela("JOGO");
        });

        JPanel painelBotao = new JPanel(new GridLayout(3, 1, 10, 10));
        painelBotao.setOpaque(false);
        painelBotao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelBotao.add(espacador(0));
        painelBotao.add(botaoIniciar);
        painelBotao.add(espacador(0)); // painéis vazios centralizam o botão

        painel.add(titulo,       BorderLayout.NORTH);
        painel.add(imagemInicio, BorderLayout.CENTER);
        painel.add(painelBotao,  BorderLayout.SOUTH);
        return painel;
    }

    // Tela do jogo
    private JPanel criarPainelJogo() {
        // Bloco central — arredondado com borda colorida
        JPanel blocoJogo = painelArredondado(COR_BLOCO, RAIO_PAINEL, true);
        blocoJogo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        blocoJogo.add(criarPainelTopo(),     BorderLayout.NORTH);
        blocoJogo.add(criarPainelConteudo(), BorderLayout.CENTER);
        return blocoJogo;
    }

    // Tela de fim
    private JPanel criarPainelFim() {
        JPanel painel = painelArredondado(COR_BLOCO, RAIO_PAINEL, true);
        painel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        // texto resultado (SUCESSO / FRACASSO) — atualizado em verificarFimDeJogo()
        labelFimResultado = new JLabel("", SwingConstants.CENTER);
        labelFimResultado.setForeground(Color.WHITE);
        labelFimResultado.setFont(new Font("Arial", Font.BOLD, 26));

        // label rodada — atualizado em verificarFimDeJogo()
        textoFim = new JLabel("", SwingConstants.CENTER);
        textoFim.setForeground(Color.WHITE);
        textoFim.setFont(new Font("Arial", Font.BOLD, 30)); // fonte da rodada x/20

        // painel de stats com ícones reais no lugar dos emojis
        JPanel statsPanel = new JPanel(new GridLayout(4, 1, 5, 8));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));

        labelFimAmbiente  = criarLabelFimStat("icone_ambiente.png");
        labelFimEconomia  = criarLabelFimStat("icone_economia.png");
        labelFimPopulacao = criarLabelFimStat("icone_populacao.png");
        labelFimAprovacao = criarLabelFimStat("icone_aprovacao.png");

        statsPanel.add(labelFimAmbiente);
        statsPanel.add(labelFimEconomia);
        statsPanel.add(labelFimPopulacao);
        statsPanel.add(labelFimAprovacao);

        // agrupa resultado + rodada + stats no centro
        JPanel centro = new JPanel(new BorderLayout(0, 10));
        centro.setOpaque(false);
        centro.add(labelFimResultado, BorderLayout.NORTH);
        centro.add(textoFim,          BorderLayout.CENTER);
        centro.add(statsPanel,        BorderLayout.SOUTH);

        // botão para fechar
        botaoFechar = new JButton("Fechar");
        estilizarBotao(botaoFechar);
        botaoFechar.addActionListener(e -> janela.dispose()); 

        JPanel painelBotao = new JPanel(new GridLayout(3, 1, 10, 10));
        painelBotao.setOpaque(false);
        painelBotao.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        painelBotao.add(espacador(0));
        painelBotao.add(botaoFechar);
        painelBotao.add(espacador(0));

        painel.add(centro,      BorderLayout.CENTER);
        painel.add(painelBotao, BorderLayout.SOUTH);
        return painel;
    }

    // Cria JLabel com ícone à esquerda — usado na tela de fim
    private JLabel criarLabelFimStat(String imagemPath) {
        JLabel label = new JLabel();
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 26));
        label.setIcon(carregarIcone("PrefeitoSimulator/imagens/" + imagemPath, 50, 50));
        label.setHorizontalAlignment(SwingConstants.LEFT);
        label.setIconTextGap(10); // espaço entre ícone e texto
        return label;
    }

    // Painel topo (barras + status + tutorial)
    private JPanel criarPainelTopo() {
        JPanel statsPanel = new JPanel(new GridLayout(4, 1, 5, 5));
        statsPanel.setOpaque(false);
        statsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        // inicializa barras e labels de valor
        barAmbiente  = criarBarra();
        barEconomia  = criarBarra();
        barPopulacao = criarBarra();
        barAprovacao = criarBarra();

        labelAmbiente  = new JLabel();
        labelEconomia  = new JLabel();
        labelPopulacao = new JLabel();
        labelAprovacao = new JLabel();

        // cada linha tem: imagem+valor | barra | ícone de info
        statsPanel.add(criarLinhaBarra(barAmbiente,  labelAmbiente,  "icone_ambiente.png",  "<html><b>Meio Ambiente</b><br>Saúde ambiental da cidade.<br>Se chegar a 0, o jogo acaba.</html>"));
        statsPanel.add(criarLinhaBarra(barEconomia,  labelEconomia,  "icone_economia.png",  "<html><b>Fundos Disponíveis</b><br>Dinheiro público disponível.<br>Se chegar a 0, o jogo acaba.</html>"));
        statsPanel.add(criarLinhaBarra(barPopulacao, labelPopulacao, "icone_populacao.png", "<html><b>Satisfação da População</b><br>Felicidade da população.<br>Se chegar a 0, o jogo acaba.</html>"));
        statsPanel.add(criarLinhaBarra(barAprovacao, labelAprovacao, "icone_aprovacao.png", "<html><b>Aprovação Pública</b><br>Sua popularidade como prefeito.<br>Se chegar a 0, o jogo acaba.</html>"));

        labelStatus = new JLabel("", SwingConstants.CENTER);
        labelStatus.setForeground(Color.WHITE);
        labelStatus.setFont(new Font("Arial", Font.BOLD, 20));
        labelStatus.setBorder(BorderFactory.createEmptyBorder(5, 0, 10, 0));

        // painel tutorial — aparece uma vez e some ao clicar em Entendido
        JPanel painelTutorial = new JPanel(new BorderLayout(8, 0));
        painelTutorial.setOpaque(false);
        painelTutorial.setBorder(BorderFactory.createEmptyBorder(2, 10, 2, 10));

        JLabel dicaTutorial = new JLabel("Passe o mouse no ícone de info para saber mais sobre cada barra");
        dicaTutorial.setForeground(Color.WHITE);
        dicaTutorial.setFont(new Font("Arial", Font.ITALIC, 16));

        JButton btnEntendido = new JButton("Entendido");
        btnEntendido.setFont(new Font("Arial", Font.BOLD, 14));
        btnEntendido.setForeground(Color.WHITE);
        btnEntendido.setFocusPainted(false);
        btnEntendido.setContentAreaFilled(false);
        btnEntendido.setBorderPainted(false);
        btnEntendido.setOpaque(false);
        btnEntendido.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(COR_BOTAO);
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), RAIO_BOTAO, RAIO_BOTAO);
                g2.dispose();
                super.paint(g, c);
            }
        });
        btnEntendido.addActionListener(e -> {
            painelTutorial.setVisible(false); // esconde para sempre enquanto o jogo estiver aberto
        });

        painelTutorial.add(dicaTutorial, BorderLayout.CENTER);
        painelTutorial.add(btnEntendido, BorderLayout.EAST);

        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.setOpaque(false);
        topContainer.add(statsPanel,      BorderLayout.NORTH);
        topContainer.add(labelStatus,     BorderLayout.CENTER);
        topContainer.add(painelTutorial,  BorderLayout.SOUTH);
        return topContainer;
    }

    // Linha de barra: imagem+valor | barra | ícone de info
    private JPanel criarLinhaBarra(JProgressBar bar, JLabel labelValor, String imagemPath, String tooltip) {
        JPanel linha = new JPanel(new BorderLayout(8, 0));
        linha.setOpaque(false);

        // ícone pequeno à esquerda
        Image imgOriginal = new ImageIcon("PrefeitoSimulator/imagens/" + imagemPath).getImage();
        Image imgEscalada = imgOriginal.getScaledInstance(26, 26, Image.SCALE_SMOOTH); // tamanho máximo dos ícones
        JLabel icone = new JLabel(new ImageIcon(imgEscalada));
        icone.setPreferredSize(new Dimension(30, 0)); // espaço reservado para os ícones

        // valor numérico
        labelValor.setText("0/100");
        labelValor.setForeground(Color.WHITE);
        labelValor.setFont(new Font("Arial", Font.BOLD, 16));
        labelValor.setPreferredSize(new Dimension(60, 0));

        // ícone + valor lado a lado no painel esquerdo
        JPanel painelEsquerdo = new JPanel(new BorderLayout(4, 0));
        painelEsquerdo.setOpaque(false);
        painelEsquerdo.setPreferredSize(new Dimension(100, 30));
        painelEsquerdo.add(icone,      BorderLayout.WEST);
        painelEsquerdo.add(labelValor, BorderLayout.CENTER);

        // ícone de info à direita — tooltip explica a barra ao passar o mouse
        JLabel info = new JLabel(carregarIcone("PrefeitoSimulator/imagens/icone_info.png", 22, 22));
        info.setToolTipText(tooltip);
        info.setPreferredSize(new Dimension(30, 0));
        info.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        linha.add(painelEsquerdo, BorderLayout.WEST);
        linha.add(bar,            BorderLayout.CENTER);
        linha.add(info,           BorderLayout.EAST);
        return linha;
    }

    // Painel conteúdo (texto + imagem + botões)
    private JPanel criarPainelConteudo() {
        // painel arredondado que agrupa texto, imagem e botões
        JPanel painel = painelArredondado(COR_EVENTO, RAIO_CONTEUDO, false);
        painel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        // texto do evento
        textoEvento = new JTextArea();
        textoEvento.setEditable(false);
        textoEvento.setFocusable(false);
        textoEvento.setLineWrap(true);
        textoEvento.setWrapStyleWord(true);
        textoEvento.setFont(new Font("Arial", Font.BOLD, 19));
        textoEvento.setBackground(COR_EVENTO);
        textoEvento.setForeground(Color.WHITE);
        textoEvento.setOpaque(true);
        textoEvento.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // imagem do evento — centralizada no meio
        imagemEvento = new JLabel();
        imagemEvento.setPreferredSize(new Dimension(400, 200)); // limita o espaço da imagem
        imagemEvento.setHorizontalAlignment(SwingConstants.CENTER);

        painel.add(textoEvento,         BorderLayout.NORTH);
        painel.add(imagemEvento,        BorderLayout.CENTER);
        painel.add(criarPainelBotoes(), BorderLayout.SOUTH);
        return painel;
    }

    // Painel dos botões
    private JPanel criarPainelBotoes() {
        cardBotoes   = new CardLayout();
        painelBotoes = new JPanel(cardBotoes);
        painelBotoes.setOpaque(false);

        // CARD 1: três botões de escolha com BoxLayout
        JPanel cardEscolha = new JPanel();
        cardEscolha.setLayout(new BoxLayout(cardEscolha, BoxLayout.Y_AXIS)); // cresce verticalmente com o texto
        cardEscolha.setOpaque(false);
        cardEscolha.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botoes = new JButton[3];
        for (int i = 0; i < botoes.length; i++) {
            int index = i;
            botoes[i] = new JButton();
            estilizarBotao(botoes[i]);
            botoes[i].setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE)); // ocupa largura total
            botoes[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            botoes[i].addActionListener(e -> escolher(index));
            cardEscolha.add(botoes[i]);
            if (i < botoes.length - 1) cardEscolha.add(Box.createVerticalStrut(10)); // espaço entre botões
        }

        // CARD 2: botão próximo centralizado no meio
        JPanel cardProximo = new JPanel(new GridLayout(3, 1, 10, 10));
        cardProximo.setOpaque(false);
        cardProximo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        botaoProximo = new JButton("Próxima Rodada");
        estilizarBotao(botaoProximo);
        botaoProximo.setPreferredSize(new Dimension(0, 22)); // altura dos botões
        botaoProximo.addActionListener(e -> carregarEvento());

        // painéis vazios acima e abaixo deixam o botão no meio
        cardProximo.add(espacador(0));
        cardProximo.add(botaoProximo);
        cardProximo.add(espacador(0));

        painelBotoes.add(cardEscolha, "ESCOLHA");
        painelBotoes.add(cardProximo, "PROXIMO");
        return painelBotoes;
    }

    // Lógica de tela
    private void carregarEvento() {
        eventoAtual = jogo.proximoEvento();
        textoEvento.setText(eventoAtual.getDescricao());

        // exibe imagem do evento se existir, ou limpa se não houver
        if (eventoAtual.getImagem() != null) {
            Image original = new ImageIcon("PrefeitoSimulator/imagens/" + eventoAtual.getImagem()).getImage();
            Image escalada = original.getScaledInstance(400, 200, Image.SCALE_SMOOTH);
            imagemEvento.setIcon(new ImageIcon(escalada));
        } else {
            imagemEvento.setIcon(null);
        }

        Escolha[] escolhas = eventoAtual.getEscolhas();
        for (int i = 0; i < botoes.length; i++) {
            if (i < escolhas.length) {
                // HTML permite quebra de linha automática no texto do botão
                botoes[i].setText("<html><center>" + escolhas[i].getTexto() + "</center></html>");
                botoes[i].setVisible(true);
            } else {
                botoes[i].setVisible(false); // esconde botões extras se houver menos de 3 escolhas
            }
        }

        labelStatus.setText(jogo.statusRodada());
        atualizarBarras();
        cardBotoes.show(painelBotoes, "ESCOLHA");
        janela.repaint(); // atualiza a tela para apagar o que estava antes
    }

    private void escolher(int index) {
        Escolha escolha = eventoAtual.getEscolhas()[index];
        jogo.aplicarEscolha(escolha);
        textoEvento.setText(escolha.getConsequencia());
        imagemEvento.setIcon(null); // esconde a imagem na consequência
        atualizarBarras();
        cardBotoes.show(painelBotoes, "PROXIMO");
        janela.repaint();
        verificarFimDeJogo();
    }

    private void verificarFimDeJogo() {
        if (!jogo.isFimDeJogo()) return;

        // verifica se algum atributo zerou — determina fracasso ou sucesso
        boolean fracasso = jogo.getAmbiente()  <= 0
                        || jogo.getEconomia()  <= 0
                        || jogo.getPopulacao() <= 0
                        || jogo.getAprovacao() <= 0;

        String[] textosSucesso = {
            "Sua cidade floresceu e seu nome entrou para a história!",
            "Os cidadãos ergueram uma estátua em sua homenagem na praça central!",
            "Você foi reeleito com 98% dos votos e virou lenda na cidade!",
            "A imprensa te chamou de o melhor prefeito de todos os tempos!"
        };

        String[] textosFracasso = {
            "Sua administração foi horrível e os cidadãos fizeram um impeachment contra você!",
            "A cidade entrou em colapso e você fugiu antes do amanhecer!",
            "Seu nome virou sinônimo de incompetência na história local!"
        };

        Random random = new Random();
        String frase = fracasso
            ? textosFracasso[random.nextInt(textosFracasso.length)]
            : textosSucesso[random.nextInt(textosSucesso.length)];

        // atualiza labels separados — ícones reais nos stats
        labelFimResultado.setText("<html><center>" + (fracasso ? "💀 FRACASSO" : "🏆 SUCESSO") + "<br><i>" + frase + "</i></center></html>");
        textoFim.setText(jogo.statusRodada());
        labelFimAmbiente.setText("Meio Ambiente: "  + jogo.getAmbiente()  + "/100");
        labelFimEconomia.setText("Economia: "       + jogo.getEconomia()  + "/100");
        labelFimPopulacao.setText("População: "     + jogo.getPopulacao() + "/100");
        labelFimAprovacao.setText("Aprovação: "     + jogo.getAprovacao() + "/100");

        botaoFechar.setVisible(false);
        trocarTela("FIM");
        Timer delay = new Timer(2000, e -> botaoFechar.setVisible(true));
        delay.setRepeats(false);
        delay.start();
    }

    // Barras arredondadas
    private JProgressBar criarBarra() {
        JProgressBar bar = new JProgressBar(0, 100) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                // fundo da barra
                g2.setColor(new Color(60, 60, 60));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), RAIO_BARRA, RAIO_BARRA);
                // preenchimento proporcional ao valor com cantos sempre redondos
                int largura = (int) (getWidth() * (getValue() / 100.0));
                Shape clip = g2.getClip();
                g2.setClip(0, 0, largura, getHeight());
                g2.setColor(getForeground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), RAIO_BARRA, RAIO_BARRA);
                g2.setClip(clip);
                g2.dispose();
            }
        };
        bar.setStringPainted(false);
        bar.setBorder(BorderFactory.createEmptyBorder());
        bar.setPreferredSize(new Dimension(0, 20)); // altura da barra
        return bar;
    }

    private void atualizarBarras() {
        atualizarBarra(barAmbiente,  labelAmbiente,  jogo.getAmbiente());
        atualizarBarra(barEconomia,  labelEconomia,  jogo.getEconomia());
        atualizarBarra(barPopulacao, labelPopulacao, jogo.getPopulacao());
        atualizarBarra(barAprovacao, labelAprovacao, jogo.getAprovacao());
    }

    private void atualizarBarra(JProgressBar bar, JLabel label, int valor) {
        bar.setForeground(corPorValor(valor));

        Timer timer = new Timer(28, null); // maior número = animação mais lenta
        timer.addActionListener(e -> {
            int atual = bar.getValue();
            if (atual < valor) bar.setValue(atual + 1);
            else if (atual > valor) bar.setValue(atual - 1);
            else { timer.stop(); return; }
            label.setText(bar.getValue() + "/100"); // número atualiza junto com a barra
        });
        timer.start();
    }

    // Cores das barras
    private Color corPorValor(int valor) {
        if (valor > LIMITE_VERDE)   return new Color(0, 224, 76); // verde
        if (valor > LIMITE_AMARELO) return Color.ORANGE;           // amarelo
        return Color.RED;                                           // vermelho
    }

    // Botões arredondados
    private void estilizarBotao(JButton botao) {
        botao.setFocusPainted(false);
        botao.setFont(new Font("Arial", Font.BOLD, 17));
        botao.setForeground(Color.WHITE);
        botao.setContentAreaFilled(false);
        botao.setBorderPainted(false);
        botao.setOpaque(false);
        botao.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
            @Override
            public void paint(Graphics g, JComponent c) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(COR_BOTAO);
                g2.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), RAIO_BOTAO, RAIO_BOTAO);
                g2.dispose();
                super.paint(g, c);
            }
        });
    }

    // Cria painel arredondado — com borda colorida se borda=true
    private JPanel painelArredondado(Color cor, int raio, boolean borda) {
        JPanel painel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(cor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), raio, raio);
                if (borda) {
                    g2.setColor(COR_BORDA);
                    g2.setStroke(new BasicStroke(4));
                    g2.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, raio, raio);
                }
                g2.dispose();
                super.paintComponent(g);
            }
        };
        painel.setOpaque(false);
        return painel;
    }

    // Carrega e redimensiona imagem — evita repetir as 3 linhas em vários lugares
    private ImageIcon carregarIcone(String caminho, int largura, int altura) {
        Image original = new ImageIcon(caminho).getImage();
        Image escalada = original.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(escalada);
    }

    // Cria painel vazio e transparente — usado como espaçador
    private JPanel espacador(int largura) {
        JPanel p = new JPanel();
        p.setOpaque(false);
        if (largura > 0) p.setPreferredSize(new Dimension(largura, 0));
        return p;
    }
}