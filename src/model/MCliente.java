
package model;

/**
 *
 * @author cragl
 */
public class MCliente extends MPessoa{
    private String codigo_cliente;

    public MCliente() {
    }

    public MCliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(String codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }


    
}
