package PrefeitoSimulator;

// Classe responsável por Moldar os Eventos no Jogo
public class Evento {
    private String descricao;
    private String imagem;  
    private Escolha[] escolhas;

    // Construtor sem imagem
    public Evento(String descricao, Escolha... escolhas) {
        this.descricao = descricao;
        this.imagem    = null;
        this.escolhas  = escolhas;
    }

    // Construtor com imagem
    public Evento(String descricao, String imagem, Escolha... escolhas) {
        this.descricao = descricao;
        this.imagem    = imagem;
        this.escolhas  = escolhas;
    }

    public String getDescricao() {
        return descricao;
    }

    // Retorna o caminho da imagem, ou null se o evento não tiver imagem
    public String getImagem() {
        return imagem;
    }

    public Escolha[] getEscolhas() {
        return escolhas;
    }
}