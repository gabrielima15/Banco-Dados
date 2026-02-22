package bd.dto;

public class TimeJogadorDTO {

    private String nomeTime;
    private String nomeJogador;

    public TimeJogadorDTO(String nomeTime, String nomeJogador) {
        this.nomeTime = nomeTime;
        this.nomeJogador = nomeJogador;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getNomeJogador() {
        return nomeJogador;
    }

    
}
