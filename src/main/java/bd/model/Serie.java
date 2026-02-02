package bd.model;

public class Serie {
    private int id;
    private String nome;
    private Integer id_time;
    private Integer id_campeonato;

    public Serie(int id, String nome, Integer id_time, Integer id_campeonato) {
        this.id = id;
        this.nome = nome;
        this.id_time = id_time;
        this.id_campeonato = id_campeonato;
    }

    public Serie(String nome, Integer id_time, Integer id_campeonato) {
        this.nome = nome;
        this.id_time = id_time;
        this.id_campeonato = id_campeonato;
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

    public Integer getId_time() {
        return id_time;
    }

    public void setId_time(Integer id_time) {
        this.id_time = id_time;
    }

    public Integer getId_campeonato() {
        return id_campeonato;
    }

    public void setId_campeonato(Integer id_campeonato) {
        this.id_campeonato = id_campeonato;
    }

    
    
}
