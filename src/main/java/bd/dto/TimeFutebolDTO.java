package bd.dto;

public class TimeFutebolDTO {
    private int id;
    private String nome;
    private Integer idCidade;
    private Integer idTecnico;

    public TimeFutebolDTO() {
    
    }

    public TimeFutebolDTO(int id, String nome, Integer idCidade, Integer idTecnico) {
        this.id = id;
        this.nome = nome;
        this.idCidade = idCidade;
        this.idTecnico = idTecnico;
    }

    public TimeFutebolDTO(String nome, Integer idCidade, Integer idTecnico) {
        this.nome = nome;
        this.idCidade = idCidade;
        this.idTecnico = idTecnico;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

    
}
