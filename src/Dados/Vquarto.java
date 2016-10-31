package Dados;

/**
 *
 * @author aelysson
 */
public class Vquarto {
    private int idquarto;
    private String numero;
    private String andar;
    private String descricao;
    private String caracteristicas;
    private Double preco_diario;
    private String status;
    private String tipo_quarto;

    public Vquarto(int idquarto, String numero, String andar, String descricao, String caracteristica, Double preco_diario, String status, String tipo_quarto) {
        this.idquarto = idquarto;
        this.numero = numero;
        this.andar = andar;
        this.descricao = descricao;
        this.caracteristicas = caracteristica;
        this.preco_diario = preco_diario;
        this.status = status;
        this.tipo_quarto = tipo_quarto;
    }

    public Vquarto() {
    }

    public int getIdquarto() {
        return idquarto;
    }

    public void setIdquarto(int idquarto) {
        this.idquarto = idquarto;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Double getPreco_diario() {
        return preco_diario;
    }

    public void setPreco_diario(Double preco_diario) {
        this.preco_diario = preco_diario;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTipo_quarto() {
        return tipo_quarto;
    }

    public void setTipo_quarto(String tipo_quarto) {
        this.tipo_quarto = tipo_quarto;
    }
    
}
