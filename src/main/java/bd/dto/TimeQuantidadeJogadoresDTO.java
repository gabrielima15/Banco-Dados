package bd.dto;
public class TimeQuantidadeJogadoresDTO {

    private String nomeTime;
    private Long quantidade;

    public TimeQuantidadeJogadoresDTO(String nomeTime, Long quantidade) {
        this.nomeTime = nomeTime;
        this.quantidade = quantidade;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    
}