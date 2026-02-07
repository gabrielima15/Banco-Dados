package bd.dto;

public class SerieDTO {
    private int id;
    private String nomeTime;       
    private String nomeCampeonato;

    public SerieDTO(int id, String nomeTime, String nomeCampeonato) {
        this.id = id;
        this.nomeTime = nomeTime;
        this.nomeCampeonato = nomeCampeonato;
    }

    public int getId() { return id; }
    public String getnomeTime() { return nomeTime; }
    public String getnomeCampeonato() { return nomeCampeonato; }
}
