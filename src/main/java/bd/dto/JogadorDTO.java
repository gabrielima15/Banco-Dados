package bd.dto;

public class JogadorDTO {
    private int id;
    private String nome;
    private int numeroCamisa;
    private int posicao;
    private Integer idTime;
    
    public JogadorDTO() {
        
    }

    public JogadorDTO(int id, String nome, int numeroCamisa, int posicao, Integer idTime) {
        this.id = id;
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
        this.posicao = posicao;
        this.idTime = idTime;
    }

    public JogadorDTO(String nome, int numeroCamisa, int posicao, Integer idTime) {
        this.nome = nome;
        this.numeroCamisa = numeroCamisa;
        this.posicao = posicao;
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

    public int getNumeroCamisa() {
        return numeroCamisa;
    }

    public void setNumeroCamisa(int numeroCamisa) {
        this.numeroCamisa = numeroCamisa;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public Integer getIdTime() {
        return idTime;
    }

    public void setIdTime(Integer idTime) {
        this.idTime = idTime;
    } 
    
}
