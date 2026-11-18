package PrefeitoSimulator;
import java.util.*;

// Classe responsável por armazenar todos os Eventos presentes no Jogo
public class BancoDeEscolhas {
    // Eventos Normais
    public static List<Evento> eventosNormais() {
        List<Evento> eventos = new ArrayList<>();
        
        eventos.add(new Evento("Uma grande indústria de montagem de carros elétricos quer se instalar às margens do principal rio da cidade, a montadora estima que vai ter que contratar até 3% da população, só com essa notícia pessoas das cidades vizinhas já começam a vir para sua cidade em busca dos futuros empregos existe uma parte da população que teme que essa montadora polua de alguma forma o rio, um grupo de analistas ambientais contratados pela montadora diz que o impacto ambiental vai ser baixo e ativistas ambientais são contra a instalação da montadora alegando que a montadora vai despejar químicos nos rios.",
            new Escolha("Negar instalação", +5, -15, -15, -20,
            "Você nega a montadora, perde investimentos. Parte da população critica a decisão.\n\n +5 de Meio Ambiente\n -15 de Fundos Econômicos\n -15 de População \n -20 de Aprovação Pública"),

            new Escolha("Aprovar com o regimento padrão", -15, +25, +10, +10,
            "A economia cresce rapidamente, 3% da população foi contratada, ao contrário do que os críticos diziam a montadora sequer mexe com químicos, uma montadora apenas monta e seus resíduos são poucos e pontuais .\n\n -15 de Meio Ambiente \n +25 de Fundos Econômicos \n +10 de População \n +10 de Aprovação Pública"),

            new Escolha("Aprovar com regras ambientais especiais", 0, +15, +10, +10,
            "A montadora é instalada com sucesso e a regulação garante que o rio fique intacto. A cidade se torna um polo de empregos verdes e a economia gira de forma limpa!\n\n 0 de Meio Ambiente \n +15 de Fundos Econômicos \n +10 de População \n +10 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("O sistema de saneamento básico atingiu seu limite operacional e os vazamentos estruturais ameaçam causar um desastre ambiental severo caso cheguem aos rios locais.", "Sistema Saneamento.png",
            new Escolha("Melhorias pontuais focando nas áreas com defeitos não estruturais", +10, -10, +5, +5,
            "A prefeitura contém os vazamentos superficiais aliviando o transtorno, mas a falha estrutural permanece como uma bomba-relógio para o futuro.\n\n +10 de Meio Ambiente \n -10 de Fundos Econômicos \n +5 de População \n +5 de Aprovação Pública"),

            new Escolha("Adiar investimentos", -25, +5, -15, -20,
            "Sem investimentos a infraestrutura cede, contaminando os rios com esgoto e espalhando surtos de doenças que revoltam a população.\n\n -25 de Meio Ambiente\n +5 de Fundos Econômicos\n -15 de População \n -20 de Aprovação Pública"),

            new Escolha("Reforma completa do sistema, com foco sustentável", +20, -20, +10, +20,
            "Apesar do custo inicial altíssimo, a nova rede ecológica despolui os rios, reduz doenças e a população exalta sua visão de futuro.\n\n +20 de Meio Ambiente \n -20 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("O crescimento descontrolado da frota de veículos transformou as vias em um caos logístico, disparando a emissão de gases de efeito estufa e a poluição sonora.", "Transito.jpg",
            new Escolha("Ignorar", -10, -5, -20, -25,
            "A poluição piora consideravelmente com os congestionamentos, prejudicando a logística dos negócios e derrubando sua aprovação popular.\n\n -10 de Meio Ambiente \n -5 de Fundos Econômicos \n -20 de População \n -25 de Aprovação Pública"),

            new Escolha("Expandir transporte sustentável", +15, -10, +10, +15,
            "Corredores de ônibus elétricos e ciclovias reduzem a poluição e melhoram o fluxo urbano, embora exijam grandes recursos do tesouro municipal.\n\n +15 de Meio Ambiente \n -10 de Fundos Econômicos \n +10 de População \n +15 de Aprovação Pública"),

            new Escolha("Construir mais avenidas", -20, -20, +15, +10,
            "O desmatamento para novas vias melhora o trânsito inicialmente, mas as obras custam fortunas e a falta de árvores afeta o microclima da cidade.\n\n -20 de Meio Ambiente \n -20 de Fundos Econômicos \n +15 de População \n +10 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Um complexo industrial foi flagrado despejando toxinas em uma reserva e, para evitar multas, oferece um suborno milionário por uma licença ambiental fraudulenta.", "Acordo ilegal.png",
            new Escolha("Recusar e chantagear a empresa ameaçando fazer uma denúncia", +10, +25, 0, 0,
            "Você paralisa a degradação e converte o acordo em doações sigilosas à prefeitura, lucrando sem receber reconhecimento público pela manobra.\n\n +10 de Meio Ambiente \n +25 de Fundos Econômicos"),

            new Escolha("Recusar e denunciar", +15, +10, +5, +20,
            "Expondo o esquema, a empresa é severamente multada; a degradação para e sua popularidade dispara pelo orgulho cívico gerado.\n\n +15 de Meio Ambiente\n +10 de Fundos Econômicos \n +5 de População \n +20 de Aprovação Pública"),

            new Escolha("Aceitar", -25, +35, 0, -25,
            "O dinheiro sujo enche os cofres, mas o despejo tóxico contínua e a descoberta do suborno pela justiça afunda totalmente sua reputação.\n\n -25 de Meio Ambiente \n +35 de Fundos Econômicos \n -25 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Um choque na oferta global de petróleo inflacionou os combustíveis, exigindo respostas imediatas para evitar o fechamento de empresas e um colapso no abastecimento.", "Crise economica global.jpg",
            new Escolha("Criar refinarias de petróleo", -25, +30, +15, +15,
            "Afrouxando leis ambientais a cidade gera milhares de empregos, mas as chaminés transformam o céu local em uma grossa nuvem tóxica adoecedora.\n\n -25 de Meio Ambiente\n +30 de Fundos Econômicos \n +15 de População \n +15 de Aprovação Pública"),

            new Escolha("Cortar gastos ambientais", -20, +15, -15, -20,
            "Os cortes equilibram as contas no momento, mas o abandono de áreas verdes cria focos de lixo e sujeira, estimulando o êxodo populacional.\n\n -20 de Meio Ambiente \n +15 de Fundos Econômicos \n -15 de População \n -20 de Aprovação Pública"),

            new Escolha("Investir agressivamente em economia verde", +20, +15, +10, +20,
            "Apostando em energia limpa e mobilidade alternativa, a cidade atrai inovações e blinda sua estrutura contra a crise fóssil.\n\n +20 de Meio Ambiente \n +15 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Milhares de ativistas bloquearam as vias exigindo que sua gestão declare emergência climática e adote um plano radical de transição energética imediata.", "Protestos ambientais.jpg",
            new Escolha("Ignorar, uma hora os protestos vão dispersar", 0, 0, -20, -25,
            "A aposta no cansaço falha, a paralisação prolongada explode o ressentimento popular e força a saída de jovens talentos da cidade.\n\n -20 de População \n -25 de Aprovação Pública"),

            new Escolha("Dialogar e seguir suas exigências", +10, -15, +15, +25,
            "O pacote de transição exige um rombo nos cofres públicos, mas o diálogo e a ação ecológica fortalecem a democracia e garantem forte apoio.\n\n +10 de Meio Ambiente \n -15 de Fundos Econômicos \n +15 de População \n +25 de Aprovação Pública"),

            new Escolha("Reprimir para que não aumente", -5, 0, -15, -35,
            "A truculência policial sufoca os manifestos, mas sua aprovação despenca para o abismo, marcando você como um inimigo autoritário do futuro.\n\n -5 de Meio Ambiente \n -15 de População \n -35 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("A demanda de energia ultrapassou o limite das velhas usinas termoelétricas poluentes; uma nova megafonte deve ser escolhida urgentemente para evitar um apagão total.", "Crise Energética.png",
            new Escolha("Energia nuclear dividida com outras cidades", +25, -40, +30, +30, 
            "A usina atômica garante energia limpa e farta para atrair indústrias, mas o investimento inicial drena agressivamente as reservas financeiras.\n\n +25 de Meio Ambiente \n -40 de Fundos Econômicos \n +30 de População \n +30 de Aprovação Pública"),

            new Escolha("Energia solar integrada (telhados públicos e indústrias)", +20, -15, +10, +20,
            "A instalação de placas solares nos telhados garante autossuficiência moderada com custos aceitáveis, sem desmatar nada do município.\n\n +20 de Meio Ambiente \n -15 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública"),

            new Escolha("Energia hidrelétrica (pequena represa)", -10, -15, +10, +20,
            "A construção da represa gasta verba significativa e inunda uma área de flora vital, mas garante estabilidade elétrica aos novos moradores.\n\n -10 de Meio Ambiente \n -15 de Fundos Econômicos \n +10 de População \n +20 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Chuvas severas em áreas de encostas desmatadas causaram enchentes e deslizamentos trágicos; você precisa decidir o foco imediato dos esforços de resgate nesta noite.", "Desastre ambiental.jpg",
            new Escolha("Resposta econômica, focando no pós-desastre", -25, +10, -35, -40,
            "Focar em segurar gastos causa uma catástrofe humana irreparável nas áreas afetadas, atraindo o ódio eterno da população por sua frieza.\n\n -25 de Meio Ambiente\n +10 de Fundos Econômicos\n -35 de População \n -40 de Aprovação Pública"),

            new Escolha("Resposta rápida, priorizar vidas a todo o custo ", -10, -35, 0, +40,
            "Usando todo o caixa disponível em resgates aéreos e botes, o tesouro quebra e áreas ecológicas são perdidas, mas as vidas salvas consagram você.\n\n -10 de Meio Ambiente \n -35 de Fundos Econômicos \n +40 de Aprovação Pública"),

            new Escolha("Resposta eficiente, salvar o máximo possível de tudo", +10, -20, -15, +15,
            "Dividir os esforços entre moradores e barreiras ambientais estabiliza os danos, mas gera perdas residenciais parciais e alguma frustração civil.\n\n +10 de Meio Ambiente \n -20 de Fundos Econômicos \n -15 de População \n +15 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("O aterro sanitário está quase no limite operacional exalando gases tóxicos, e um projeto para um moderno sistema municipal de reciclagem aguarda sua aprovação.", "coleta seletiva.png",
            new Escolha("Projeto piloto", +10, -5, +5, +10,
            "Um teste com pequenos caminhões híbridos custa pouco e ganha simpatia popular, retardando levemente a morte do aterro principal.\n\n +10 de Meio Ambiente \n -5 de Fundos Econômicos \n +5 de População \n +10 de Aprovação Pública"),

            new Escolha("Ignorar", -20, 0, -10, -15,
            "Sem reciclagem, o aterro transborda chorume tóxico para os riachos e as montanhas de lixo causam surtos de doenças nos bairros vizinhos.\n\n -20 de Meio Ambiente\n -10 de População\n -15 de Aprovação Pública"),

            new Escolha("Implementar totalmente e criar usinas de reciclagem", +30, +10, +15, +20,
            "A revolução da reciclagem separa resíduos em larga escala, enterrando o passivo ambiental e gerando lucros formidáveis aos cofres a médio prazo.\n\n +30 de Meio Ambiente \n +10 de Fundos Econômicos \n +15 de População \n +20 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Uma legislação propõe subsidiar pesadamente a implantação de painéis solares residenciais para descarbonizar a cidade, mas a equipe econômica teme a falência estatal.", "solar residencial.png",
            new Escolha("Não incentivar", -15, +5, -5, -10,
            "O veto protege a arrecadação da cidade, mas as famílias continuam asfixiadas pelo uso das termoelétricas poluentes e a modernização estanca.\n\n -15 de Meio Ambiente\n +5 de Fundos Econômicos\n -5 de População\n -10 de Aprovação Pública"),

            new Escolha("Bancar instalação parcial através de financiamento público", +25, -10, +15, +20,
            "Subsidiar parte das placas custa caro ao governo, mas descarboniza fortemente o ar e barateia o custo de vida, atraindo multidões felizes.\n\n +25 de Meio Ambiente\n -10 de Fundos Econômicos\n +15 de População\n +20 de Aprovação Pública"),

            new Escolha("Incentivo apenas em redução de burocracia", +10, 0, +5, +10,
            "Zerar taxas burocráticas motiva as classes altas a instalarem energia solar sozinhas, ajudando o meio ambiente sem drenar verbas dos cofres.\n\n +10 de Meio Ambiente\n 0 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Ondas de calor e expansão industrial aumentaram perigosamente o consumo hídrico; mananciais estão baixando e medidas mitigadoras são essenciais contra a seca iminente.", "Consumo de agua elevado.jpg",
            new Escolha("Aumentar os reservatórios", -15, -25, +20, +20,
            "Obras faraônicas e caras alagam vales e afundam florestas para criar novos reservatórios, garantindo o abastecimento popular a alto custo ambiental.\n\n -15 de Meio Ambiente \n -25 de Fundos Econômicos \n +20 de População \n +20 de Aprovação Pública"),

            new Escolha("Campanhas educativas", +10, -5, +5, +10,
            "Campanhas baratas convencem a população a poupar água em tarefas domésticas, proporcionando um alívio moderado aceito pela sociedade.\n\n +10 de Meio Ambiente\n -5 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública"),

            new Escolha("Políticas de controle e reúso industrial", +25, +5, +5, +15,
            "Ao obrigar grandes indústrias a comprarem água de reúso tratada, você poupa as nascentes potáveis e ainda gera lucro com taxas de abastecimento.\n\n +25 de Meio Ambiente\n +5 de Fundos Econômicos\n +5 de População\n +15 de Aprovação Pública")
        ));

        
        eventos.add(new Evento("Uma bomba-relógio política explodiu em suas mãos. Uma investigação independente descobriu um elaborado esquema de superfaturamento e fraudes licitatórias justamente na Secretaria do Meio Ambiente, envolvendo aliados do seu círculo de confiança que lideravam a reforma das reservas da cidade. Documentos manchados foram divulgados à imprensa e a oposição exige um processo formal de cassação do seu governo na câmara enquanto a praça enche de manifestantes.",
            new Escolha("Negar envolvimento", 0, +5, -15, -25,
            "Você mantém o tom agressivo, acusa a mídia de fake news e blinda os envolvidos. O pacto de silêncio mantém acordos políticos lucrativos ativos, mas o cinismo evidente repulsa os trabalhadores locais. As ruas ficam enojadas e a revolta popular amarga completamente sua capacidade de liderança moral.\n\n +5 de Fundos Econômicos\n -15 de População\n -25 de Aprovação Pública"),

            new Escolha("Investigar e punir os responsáveis", 0, -10, +10, +25,
            "Dando um passo radical para preservar a transparência, você abre todos os sigilos e entrega seus aliados às autoridades de frente para as câmeras. A turbulência afugenta contratos vitais e arranha a economia estatal, mas o eleitor perdoa e festeja a postura irredutível do governante honesto da cidade.\n\n -10 de Fundos Econômicos\n +10 de População\n +25 de Aprovação Pública"),

            new Escolha("Abafar o caso com suborno", 0, -25, -10, -30,
            "Dinheiro público é drenado na calada da noite para silenciar vereadores e promotores da base aliada num desespero absurdo. Infelizmente, uma testemunha não aceita o suborno, vazando um segundo áudio onde você próprio aparece ordenando as propinas. O desastre joga tudo pelos ares, esvaziando a cidade e seu cargo.\n\n -25 de Fundos Econômicos \n -10 de População \n -30 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("Um grande conglomerado promete erradicar o desemprego construindo um novo polo industrial, mas exige desmatar um amplo bosque local e cortes profundos em impostos.", "investidor.jpg",
            new Escolha("Negociar condições equilibradas", -5, +15, +10, +15,
            "Com isenções leves, as empresas se instalam gerando emprego, enquanto acordos de preservação mitigam parte dos danos ao meio ambiente.\n\n -5 de Meio Ambiente\n +15 de Fundos Econômicos\n +10 de População\n +15 de Aprovação Pública"),

            new Escolha("Recusar proposta", +10, -20, -10, -15,
            "A natureza intocada é salva, mas o fechamento de portas para o investimento espanta o emprego, empurrando as famílias locais para a pobreza.\n\n +10 de Meio Ambiente\n -20 de Fundos Econômicos\n -10 de População\n -15 de Aprovação Pública"),

            new Escolha("Aceitar com incentivos fiscais", -20, +25, +15, +10,
            "A isenção agressiva lota o mercado de empregos e fortunas, mas as motosserras engolem a floresta inteira para cimentar as fábricas bilionárias.\n\n -20 de Meio Ambiente\n +25 de Fundos Econômicos\n +15 de População\n +10 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("A proposta de sediar um mega festival de música dentro da maior reserva ambiental da cidade atrai milhões em turismo, mas biólogos temem degradação pesada e plásticos na fauna.", "festival cultural.jpg",
            new Escolha("Evento moderado", -5, -10, +10, +15,
            "Limitando a lotação e financiando limpezas rigorosas, a população curte o evento e a reserva sofre apenas danos leves com lixos esporádicos.\n\n -5 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +15 de Aprovação Pública"),

            new Escolha("Investir pesado no evento", -15, -30, +20, +30,
            "A prefeitura gasta fortunas na infraestrutura do evento épico; a alegria é imensa e atrai moradores, mas a mata é completamente destroçada pelo fluxo.\n\n -15 de Meio Ambiente\n -30 de Fundos Econômicos\n +20 de População\n +30 de Aprovação Pública"),

            new Escolha("Cancelar", +5, +15, -15, -20,
            "Protegendo as aves e árvores a festa é barrada, gerando multas ricas contra os produtores, mas despertando o ódio das classes mais jovens.\n\n +5 de Meio Ambiente\n +15 de Fundos Econômicos\n -15 de População\n -20 de Aprovação Pública")
        ));
        
        eventos.add(new Evento("O ar empoeirado urbano explodiu os casos de doenças respiratórias crônicas, superlotando os hospitais e forçando o colapso estrutural da saúde sob filas emergenciais.", "sistema de saude sobrecarregado.jpg",
            new Escolha("Incentivar fiscalmente a saúde privada", -5, +25, -15, -10,
            "A isenção ergue centros médicos de luxo movimentando a economia, mas os desfavorecidos morrem nas filas públicas, gerando indignação amarga.\n\n -5 de Meio Ambiente \n +25 de Fundos Econômicos \n -15 de População \n -10 de Aprovação Pública"),

            new Escolha("Investir fortemente na saúde", +5, -35, +25, +25,
            "A prefeitura suga violentamente o tesouro municipal para comprar insumos e salvar as vítimas da poluição, virando um herói com os cofres falidos.\n\n +5 de Meio Ambiente\n -35 de Fundos Econômicos\n +25 de População\n +25 de Aprovação Pública"),

            new Escolha("Melhorias básicas", +5, -15, +10, +10,
            "Pequenas compras de insumos e contratações estancam a dor temporariamente com leve custo estatal, pacificando as filas até a fumaça assentar.\n\n +5 de Meio Ambiente\n -15 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública")
        ));

        eventos.add(new Evento("Um repasse robusto e emergencial de verbas federais caiu no cofre do município sem laços burocráticos, oferecendo uma rara oportunidade de investimento livre à sua gestão.", "Repasse econômico.jpg",
            new Escolha("Manter a verba", 0, +25, 0, 0,
            "Você aprisiona as cifras volumosas rendendo nos bancos do governo, garantindo uma solidez contábil imensa mas invisível para os eleitores.\n\n +25 de Fundos Econômicos"),

            new Escolha("Pagar um show de música gratuito", 0, -5, 0, +30,
            "A prefeitura gasta a bolada organizando festas épicas gratuitas, convertendo o saldo do governo num salto imediato e cego de reeleição.\n\n -5 de Fundos Econômicos\n +30 de Aprovação Pública"),

            new Escolha("Investir em modernização e corte de poluentes", +25, +10, +5, +15,
            "Os fundos trocam motores velhos por tecnologia verde nas estatais, garantindo um futuro respirável e dividendos brilhantes ao município.\n\n +25 de Meio Ambiente\n +10 de Fundos Econômicos\n +5 de População\n +15 de Aprovação Pública")
        ));

        return eventos;
    }

    // Eventos de Meio Ambiente Alto 
    public static List<Evento> eventoAmbienteAlto() {
        List<Evento> eventoAmbienteAlto = new ArrayList<>();

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nA ONU acabou de ratificar a perfeição ecológica da sua política urbana; o ar limpo e a água purificada da cidade renderam aplausos e prêmios internacionais globais.", "Ambiente Alto.jpg",
            new Escolha("Aproveitar o reconhecimento para atrair investimentos", +10, +25, +15, +15,
            "Usando o selo verde, corporações ecologicamente responsáveis inundam a cidade com fortunas enquanto mantêm as folhas e rios intactos.\n\n +10 de Meio Ambiente\n +25 de Fundos Econômicos\n +15 de População\n +15 de Aprovação Pública"),

            new Escolha("Investir para se tornar referência global", +25, -35, +20, +20,
            "O orçamento público é inteiramente torrado em prédios sustentáveis e orgânicos altamente avançados, atraindo multidões para sua utopia falida.\n\n +25 de Meio Ambiente\n -35 de Fundos Econômicos\n +20 de População\n +20 de Aprovação Pública"),

            new Escolha("Não investir mais e manter como está", -15, +10, -20, -20,
            "Sem investimento de manutenção, a natureza da cidade logo enfraquece; ervas daninhas cobrem os parques e a população percebe a mesquinhez fiscal.\n\n -15 de Meio Ambiente\n +10 de Fundos Econômicos\n -20 de População\n -20 de Aprovação Pública")
        ));

        eventoAmbienteAlto.add(new Evento("URGENTE!!\n\nNossa impecável vitrine esmeralda atraiu a COP anual da terra; os líderes mundiais querem realizar o evento aqui, exigindo uma logística caríssima.", "Ambiente Alto 2.jpg",
            new Escolha("Recusar e manter estabilidade", -5, +5, -10, -15,
            "Trancando as portas você blinda os cofres de gastos faraônicos diplomáticos, mas perde a chance da liderança mundial e deprime os ânimos do povo.\n\n -5 de Meio Ambiente\n +5 de Fundos Econômicos\n -10 de População\n -15 de Aprovação Pública"),

            new Escolha("Firmar parcerias e dividir os custos", +10, -10, +10, +10,
            "Vendendo cotas para corporações, marcas globais bancam pavimentos bonitos e sustentáveis sem destruir a tesouraria principal da cidade.\n\n +10 de Meio Ambiente\n -10 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Investir pesado para sediar o evento", +15, -25, +15, +15,
            "Um palácio central sustentável é construído pelo governo; o evento eleva a cidade ao estrelato global, mas quebra o orçamento de secretarias locais.\n\n +15 de Meio Ambiente\n -25 de Fundos Econômicos\n +15 de População\n +15 de Aprovação Pública")
        ));

        return eventoAmbienteAlto;
    }

    // Evento de Meio Ambiente Baixo 
    public static List<Evento> eventoAmbienteBaixo() {
        List<Evento> eventoAmbienteBaixo = new ArrayList<>();

        eventoAmbienteBaixo.add(new Evento("URGENTE!!\n\nUma nuvem corrosiva preta imensa afogou as luzes dos postes antes mesmo das tardes de sol desabrocharem e poças de óleo invadem os quintais dos trabalhadores enquanto a mortalidade e alergia varrem brutalmente as calçadas da amarga capital das tragédias poluídas sufocadas pela péssima logística deixada nas suas mãos. A humanidade morre junto das fábricas cuspindo alcatrão.",
            new Escolha("Implementar um plano emergencial de arborização e filtros urbanos", +20, -15, +5, +10,
            "Comprando e pendurando esponjas limpadoras artificiais enormes, cortando o mato morto urgente e espalhando regadores químicos amigáveis pelas praças destruídas num esforço frenético para tapar as crateras ácidas do céu usando ouro valioso público que deságua da riqueza governamental. Os bebês respiram leve de novo enquanto corações amargos engolem críticas para celebrar esse humilde alívio oxigenado dos prados artificiais montados.\n\n +20 de Meio Ambiente\n -15 de Fundos Econômicos\n +5 de População\n +10 de Aprovação Pública"),

            new Escolha("Maquiar os dados e focar em remédios para a população", -25, +10, -25, -35,
            "Escondendo perfeitamente os contadores negros falsificados das neves tóxicas das avenidas mentindo cinicamente que o asfalto é limpo enquanto lotam caminhões de pílulas calmas pagas às farmacêuticas sorridentes das moedas públicas roubadas secretamente e enchendo os fundos malditos imorais escondidos de sua maleta no horror da destruição cruel fúnebre do mato assassinado enforcando as almas raivosas caídas.\n\n -25 de Meio Ambiente\n +10 de Fundos Econômicos\n -25 de População\n -35 de Aprovação Pública"),

            new Escolha("Decretar lockdown industrial e multar severamente os poluidores", +35, -35, -15, +15,
            "Um chicote imperdoável amarrando todas as comportas metálicas poluidoras, você encerra as fábricas monstruosas e joga pesados cadeados da justiça aplicando severas multas falhas em quem ousa esfumaçar o ar doentio do município sufocando economias assalariadas completas caindo nos esgotos falidos forçando a dor do desemprego e êxodo massivo para trazer luz ao céu purificado limpíssimo salvador em forma doentia financeira dura na capital quebrada.\n\n +35 de Meio Ambiente\n -35 de Fundos Econômicos\n -15 de População\n +15 de Aprovação Pública")
        ));

        return eventoAmbienteBaixo;
    }

    //Evento de Economia Alta
    public static List<Evento> eventoEconomiaAlta() {
        List<Evento> eventoEconommiaAlta = new ArrayList<>();

        eventoEconommiaAlta.add(new Evento("URGENTE!!\n\nO mercado local atingiu níveis de produtividade vertiginosos, com os cofres estourando de arrecadações prontas para investimentos transformadores.", "Economia Alta.jpg",
            new Escolha("Manter a situação atual", 0, +10, +5, -5,
            "Você acumula as moedas em reservas frias enquanto o povo prospera com o comércio, mas o conservadorismo excessivo incomoda os progressistas.\n\n +10 de Fundos Econômicos\n +5 de População\n -5 de Aprovação Pública"),

            new Escolha("Expandir investimentos públicos", -10, -30, +25, +20,
            "Despejando os cofres em obras gigantes e escolas brancas, o asfalto afugenta o verde, mas atrai oceanos de migrantes e a aprovação explode.\n\n -10 de Meio Ambiente\n -30 de Fundos Econômicos\n +25 de População\n +20 de Aprovação Pública"),

            new Escolha("Atrair mais empresas e ampliar a economia", -25, +35, +15, +10,
            "Corporações engolem matas nativas para instalar plantas milionárias; a poluição destrói as praças florais enquanto fundos chovem sob o cinza império.\n\n -25 de Meio Ambiente\n +35 de Fundos Econômicos\n +15 de População\n +10 de Aprovação Pública")
        ));

        return eventoEconommiaAlta;
    }
    
    //Evento de Economia Baixa
    public static List<Evento> eventoEconomiaBaixa() {
        List<Evento> eventoEconimiaBaixa = new ArrayList<>();

        eventoEconimiaBaixa.add(new Evento("URGENTE!!\n\nO mercado sucumbiu fechando indústrias e zerando a arrecadação; o tesouro implora por socorro antes do calote total e colapso urbano completo.", "Economia Baixa.jpg",
            new Escolha("Aumentar impostos para recuperar os cofres", 0, +30, -20, -30,
            "Uma caçada fiscal implacável salva as planilhas estatais da falência, mas esfola o bolso do cidadão, que responde com êxodo e ódio ferrenho.\n\n +30 de Fundos Econômicos\n -20 de População\n -30 de Aprovação Pública"),

            new Escolha("Não intervir e esperar recuperação natural", 0, -25, -20, -25,
            "Sem socorro as arcas desabam totalmente, espantando moradores em um êxodo covarde pelas calçadas enquanto a cidade afunda abandonada.\n\n -25 de Fundos Econômicos\n -20 de População\n -25 de Aprovação Pública"),

            new Escolha("Plano agressivo de recuperação econômica", -25, +40, +10, +15,
            "Incendiando legislações protetoras, você atrai indústrias extremamente sujas; a fumaça asfixia o bioma, mas o emprego salva os cofres em chamas.\n\n -25 de Meio Ambiente\n +40 de Fundos Econômicos\n +10 de População\n +15 de Aprovação Pública")
        ));

        return eventoEconimiaBaixa;
    }

    // Evento de População Alta
    public static List<Evento> eventoPopulacaoAlta() {
        List<Evento> eventoPopulacaoAlta = new ArrayList<>();

        eventoPopulacaoAlta.add(new Evento("URGENTE!!\n\nA superpopulação estourou as costuras da metrópole, causando longos congestionamentos, esgotos entupidos e favelas apertadas nas encostas.", "Popularidade alta.jpg",
            new Escolha("Cobrar uma taxa de imigração e novos moradores", 0, +25, -25, -20,
            "Uma taxa brutal e elitista freia a imigração enchendo o tesouro, mas famílias separadas nas catracas nutrem repulsa pela tirania excludente.\n\n +25 de Fundos Econômicos\n -25 de População\n -20 de Aprovação Pública"),

            new Escolha("Construir conjuntos habitacionais verticais rápidos", -25, -20, +25, +15,
            "Guindastes sobem blocos infinitos sobre santuários verdes; o custo rasga o cofre municipal, mas a moradia barata acolhe as multidões desamparadas.\n\n -25 de Meio Ambiente\n -20 de Fundos Econômicos\n +25 de População\n +15 de Aprovação Pública"),

            new Escolha("Expandir o perímetro urbano sobre áreas verdes", -35, -15, +35, +20,
            "Motosserras fatiam cinturões verdes transformando bordas em estradas habitacionais gigantes; a perda floral é imensa, mas a oferta de lares apazigua a massa.\n\n -35 de Meio Ambiente\n -15 de Fundos Econômicos\n +35 de População\n +20 de Aprovação Pública")
        ));

        return eventoPopulacaoAlta;
    }

    // Evento de População Baixa
    public static List<Evento> eventoPopulacaoBaixa() {
        List<Evento> eventoPopulacaoBaixa = new ArrayList<>();

        eventoPopulacaoBaixa.add(new Evento("URGENTE!!\n\nO exílio massivo esvaziou os bairros; indústrias morrem sem mão de obra e o comércio jaz trancado numa cidade que lentamente vira fantasma.", "Popularidade Baixa.jpg",
            new Escolha("Não fazer nada e reduzir o tamanho dos serviços públicos", +20, +15, -20, -25,
            "Desligando postes periféricos você poupa impostos e deixa as plantas tomarem conta da cidade, mas os idosos e comerciantes amargam profunda depressão.\n\n +20 de Meio Ambiente\n +15 de Fundos Econômicos\n -20 de População\n -25 de Aprovação Pública"),

            new Escolha("Investir em automação e tecnologia para suprir a falta de pessoas", 0, -35, -5, +10,
            "As contas do governo são estraçalhadas importando limpeza robótica, sustentando a ordem limpa enquanto as praças permanecem tristes, frias e mecânicas sem vidas felizes.\n\n -35 de Fundos Econômicos\n -5 de População\n +10 de Aprovação Pública"),

            new Escolha("Oferecer isenção de impostos e moradia grátis para novos imigrantes", -10, -30, +35, +15,
            "Você zera as contas públicas distribuindo casas e anulando boletos; o asfalto é ocupado, a fauna é afugentada, mas o coração orgânico da cidade volta a pulsar sorridente.\n\n -10 de Meio Ambiente\n -30 de Fundos Econômicos\n +35 de População\n +15 de Aprovação Pública")
        ));

        return eventoPopulacaoBaixa;
    }

    // Evento Aprovação Alta 
    public static List<Evento> eventoAprovacaoAlta() {
        List<Evento> eventoAprovacaoAlta = new ArrayList<>();

        eventoAprovacaoAlta.add(new Evento("URGENTE!!\n\nSua aprovação cruzou patamares históricos, oferecendo um 'cheque em branco' da paciência cidadã que permite emplacar reformas grandes e difíceis sem resistências.", "Aprovacao alta.png",
            new Escolha("Aprovar reformas econômicas estratégicas", -10, +30, +10, +10,
            "Enquanto a proteção orgânica é atropelada, o livre mercado é acionado atraindo lucros bilionários e gerando prosperidade imediata no capital aberto.\n\n -10 de Meio Ambiente\n +30 de Fundos Econômicos\n +10 de População\n +10 de Aprovação Pública"),

            new Escolha("Manter a estabilidade e evitar riscos", 0, +10, +5, -5,
            "Evitando apostas ousadas a economia gera lucros constantes e seguros nas calçadas calmas, mas o medo de inovar quebra a alta expectativa popular criada.\n\n +10 de Fundos Econômicos\n +5 de População\n -5 de Aprovação Pública"),

            new Escolha("Lançar grandes projetos para a cidade", +10, -25, +20, +15,
            "Mega museus e centros verdes monumentais explodem no centro consumindo fortunas; pássaros e pessoas aplaudem a genialidade cultural flertando com a falência contábil.\n\n +10 de Meio Ambiente\n -25 de Fundos Econômicos\n +20 de População\n +15 de Aprovação Pública")
        ));

        return eventoAprovacaoAlta;
    }

    // Evento Aprovação Baixa 
    public static List<Evento> eventoAprovacaoBaixa() {
        List<Evento> eventoAprovacaoBaixa = new ArrayList<>();

        eventoAprovacaoBaixa.add(new Evento("URGENTE!!\n\nSua aprovação atingiu o fundo do poço; protestos furiosos trancam as portas da prefeitura exigindo manobras mágicas e radicais para evitar o impeachment iminente.", "Aprovacao Baixa.png",
            new Escolha("Ignorar e focar em alianças políticas nos bastidores", 0, +20, -15, -15,
            "Loteando as secretarias você junta moedas sujas resgatando a força no plenário legislativo, enquanto as famílias fogem com nojo moral irreparável.\n\n +20 de Fundos Econômicos\n -15 de População\n -15 de Aprovação Pública"),

            new Escolha("Fazer um pronunciamento oficial prometendo bônus e auxílios", 0, -30, 0, +30,
            "Derramando cestas e auxílios de emergência na TV, você joga a prefeitura inteira no buraco vermelho do tesouro, mas readquire rapidamente o amor e gritos felizes da massa.\n\n -30 de Fundos Econômicos\n +30 de Aprovação Pública"),

            new Escolha("Iniciar um grande mutirão de obras públicas para gerar empregos", -15, -20, +15, +20,
            "O maquinário pesado fere o chão das reservas para garantir cimento ao trabalhador; a natureza lamenta as obras custosas, mas os pais de família perdoam seu mandato felizes.\n\n -15 de Meio Ambiente\n -20 de Fundos Econômicos\n +15 de População\n +20 de Aprovação Pública")
        ));

        return eventoAprovacaoBaixa;
    }
}