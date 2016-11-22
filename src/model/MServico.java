
package model;

/**
 *
 * @author cragl
 */
public class MServico {
    
    
    private int idservico;
    private String nome;
    private String descricao;
    private String medida;
    private Double preco_venda;

    public MServico() {
    }

    public MServico(int idservico, String nome, String descricao, String medida, Double preco_venda) {
        this.idservico = idservico;
        this.nome = nome;
        this.descricao = descricao;
        this.medida = medida;
        this.preco_venda = preco_venda;
    }

    public int getIdservico() {
        return idservico;
    }

    public void setIdservico(int idservico) {
        this.idservico = idservico;
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

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double precio_venta) {
        this.preco_venda = precio_venta;
    }

}
