
package model;

/**
 *
 * @author cragl
 */

import java.sql.Date;

public class MReserva {
    private int idreserva;
    private int idquarto;
    private int idcliente;
    private int idfuncionario;
    private String tipo_reserva;
    /*private Date data_reserva;
    private Date data_entrada;
    private Date data_saida;*/
    private Double custo_alojamento;
    private String estado;

    public MReserva() {
    }

    public MReserva(int idreserva, int idquarto, int idcliente, int idfuncionario,
            String tipo_reserva, Date data_reserva, Date data_entrada, 
            Date data_saida, Double custo_alojamiento, String estado) {
        this.idreserva = idreserva;
        this.idquarto = idquarto;
        this.idcliente = idcliente;
        this.idfuncionario = idfuncionario;
        this.tipo_reserva = tipo_reserva;
        /*this.data_reserva = data_reserva;
        this.data_entrada = data_entrada;
        this.data_saida = data_saida;*/
        this.custo_alojamento = custo_alojamento;
        this.estado = estado;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public int getIdquarto() {
        return idquarto;
    }

    public void setIdquarto(int idquarto) {
        this.idquarto = idquarto;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public int getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(int idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getTipo_reserva() {
        return tipo_reserva;
    }

    public void setTipo_reserva(String tipo_reserva) {
        this.tipo_reserva = tipo_reserva;
    }

    /*public Date getData_reserva() {
        return data_reserva;
    }

    public void setData_reserva(Date data_reserva) {
        this.data_reserva = data_reserva;
    }

    public Date getData_entrada() {
        return data_entrada;
    }

    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }

    public Date getData_saida() {
        return data_saida;
    }

    public void setData_saida(Date data_saida) {
        this.data_saida = data_saida;
    }*/

    public Double getCusto_alojamento() {
        return custo_alojamento;
    }

    public void setCusto_alojamento(Double custo_alojamento) {
        this.custo_alojamento = custo_alojamento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
