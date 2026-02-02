package bd.model;

public class TimeFutebol {
    private int id;
    private String nome;
    private String cidade;
    private Integer idTecnico;

    public TimeFutebol(){

    }

    public TimeFutebol(int id, String nome, String cidade, Integer idTecnico) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.idTecnico = idTecnico;
    }

    public TimeFutebol(String nome, String cidade, Integer idTecnico) {
        this.nome = nome;
        this.cidade = cidade;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(Integer idTecnico) {
        this.idTecnico = idTecnico;
    }

}
