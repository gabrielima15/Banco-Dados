package bd.dto;

public class JogadorTimeCidadeDTO {

    private String nomeJogador;
    private String nomeTime;
    private String nomeCidade;
    private int posicao;

    public JogadorTimeCidadeDTO(String nomeJogador, String nomeTime, String nomeCidade, int posicao) {
        this.nomeJogador = nomeJogador;
        this.nomeTime = nomeTime;
        this.nomeCidade = nomeCidade;
        this.posicao = posicao;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public int getPosicao() {
        return posicao;
    }

    

    
}
