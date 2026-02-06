package bd.model;

public class TimeFutebol {
    private int id;
    private String nome;
    private Integer idcidade;
    private Integer idtecnico;

    public TimeFutebol(){

    }

    public TimeFutebol(int id, String nome, Integer idcidade, Integer idtecnico) {
        this.id = id;
        this.nome = nome;
        this.idcidade = idcidade;
        this.idtecnico = idtecnico;
    }

    public TimeFutebol(String nome, Integer idcidade, Integer idtecnico) {
        this.nome = nome;
        this.idcidade = idcidade;
        this.idtecnico = idtecnico;
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

    public Integer getIdcidade() {
        return idcidade;
    }

    public void setIdcidade(Integer idcidade) {
        this.idcidade = idcidade;
    }

    public Integer getIdtecnico() {
        return idtecnico;
    }

    public void setIdtecnico(Integer idtecnico) {
        this.idtecnico = idtecnico;
    }

}
