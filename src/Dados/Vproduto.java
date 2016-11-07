
package Dados;

/**
 *
 * @author Aelysson
 */
public class Vproduto {
    
    
    private int idproduto;
    private String nome;
    private String descricao;
    private String unidade_medida;
    private Double preco_venda;

    public Vproduto() {
    }

    public Vproduto(int idproduto, String nome, String descricao, String unidade_medida, Double preco_venda) {
        this.idproduto = idproduto;
        this.nome = nome;
        this.descricao = descricao;
        this.unidade_medida = unidade_medida;
        this.preco_venda = preco_venda;
    }

    public int getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(int idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade_medida() {
        return unidade_medida;
    }

    public void setUnidade_medida(String unidade_medida) {
        this.unidade_medida = unidade_medida;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }
    
    
    
    
    
    
}
