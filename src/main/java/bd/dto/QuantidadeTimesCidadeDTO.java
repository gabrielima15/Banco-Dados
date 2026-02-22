package bd.dto;

public class  QuantidadeTimesCidadeDTO {
    private String nomeCidade;
    private Long quantidade;

    public QuantidadeTimesCidadeDTO(String nomeCidade, Long quantidade) {
        this.nomeCidade = nomeCidade;
        this.quantidade = quantidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public Long getQuantidade() {
        return quantidade;
    }

    

}
