package bd.dto;

public class TimeTecnicoCampeonatoDTO {

    private String nomeTime;
    private String nomeTecnico;
    private String nomeCampeonato;

    public TimeTecnicoCampeonatoDTO(String nomeTime, String nomeTecnico, String nomeCampeonato) {
        this.nomeTime = nomeTime;
        this.nomeTecnico = nomeTecnico;
        this.nomeCampeonato = nomeCampeonato;
    }

    public String getNomeTime() {
        return nomeTime;
    }

    public String getNomeTecnico() {
        return nomeTecnico;
    }

    public String getNomeCampeonato() {
        return nomeCampeonato;
    }
}