
package model;

/**
 *
 * @author aelysson
 */
public class MDespesas {
    private int iddespesa;
    private int idreserva;
    private int idservico;
    private Double quantidade;
    private Double preco_venda;
    private String estado;

    public MDespesas() {
    }

    public MDespesas(int iddespesa, int idreserva, int idservico, Double quantidade, Double preco_venda, String estado) {
        this.iddespesa = iddespesa;
        this.idreserva = idreserva;
        this.idservico = idservico;
        this.quantidade = quantidade;
        this.preco_venda = preco_venda;
        this.estado = estado;
    }

    public int getIddespesa() {
        return iddespesa;
    }

    public void setIddespesa(int iddespesa) {
        this.iddespesa = iddespesa;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdservico() {
        return idservico;
    }

    public void setIdservico(int idservico) {
        this.idservico = idservico;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_venda() {
        return preco_venda;
    }

    public void setPreco_venda(Double preco_venda) {
        this.preco_venda = preco_venda;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
