package bd.model;

public class Tecnico {
    private int id;
    private String nome;
    private Integer idTime;

    public Tecnico(int id, String nome, Integer idTime) {
        this.id = id;
        this.nome = nome;
        this.idTime = idTime;
    }

    public Tecnico(String nome, Integer idTime) {
        this.nome = nome;
        this.idTime = idTime;
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

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    }


}
