package bd.dto;

public class CidadeDTO {
    private int id;
    private String nomeDaCidade;

    public CidadeDTO() {
        
    }

    public CidadeDTO(int id, String nomeDaCidade) {
        this.id = id;
        this.nomeDaCidade = nomeDaCidade;
    }

    public CidadeDTO(String nomeDaCidade) {
        this.nomeDaCidade = nomeDaCidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDaCidade() {
        return nomeDaCidade;
    }

    public void setNomeDaCidade(String nomeDaCidade) {
        this.nomeDaCidade = nomeDaCidade;
    }

    
}
