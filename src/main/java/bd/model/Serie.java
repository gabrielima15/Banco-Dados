package bd.model;

public class Serie {
    private int id; 
    private Integer idTime;
    private Integer idCampeonato;

    public Serie(int id,  Integer idTime, Integer idCampeonato) {
        this.id = id;
        this.idTime = idTime;
        this.idCampeonato = idCampeonato;
    }

    public Serie( Integer idTime, Integer idCampeonato) {

        this.idTime = idTime;
        this.idCampeonato = idCampeonato;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getIdtime() {
        return idTime;
    }

    public void setIdtime(Integer idTime) {
        this.idTime = idTime;
    }

    public Integer getIdcampeonato() {
        return idCampeonato;
    }

    public void setIdcampeonato(Integer idCampeonato) {
        this.idCampeonato = idCampeonato;
    }

    
    
}
