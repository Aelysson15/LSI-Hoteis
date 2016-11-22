
package model;

import java.sql.Date;

/**
 *
 * @author aelysson
 */
public class MPagamento {
    private int idpagamento;
    private int idreserva;
    private String tipo_comprovante;
    private String num_comprovante;
    private Double total_pagamento;


    public MPagamento() {
    }

    public MPagamento(int idpagamento, int idreserva, String tipo_comprovante, String num_comprovante, Double total_pagamento) {
        this.idpagamento = idpagamento;
        this.idreserva = idreserva;
        this.tipo_comprovante = tipo_comprovante;
        this.num_comprovante = num_comprovante;
        this.total_pagamento = total_pagamento;

    }

    public int getIdpagamento() {
        return idpagamento;
    }

    public void setIdpagamento(int idpagamento) {
        this.idpagamento = idpagamento;
    }

    public int getIdreserva() {
        return idreserva;
    }

    public void setIdreserva(int idreserva) {
        this.idreserva = idreserva;
    }

    public String getTipo_comprovante() {
        return tipo_comprovante;
    }

    public void setTipo_comprovante(String tipo_comprovante) {
        this.tipo_comprovante = tipo_comprovante;
    }

    public String getNum_comprovante() {
        return num_comprovante;
    }

    public void setNum_comprovante(String num_comprovante) {
        this.num_comprovante = num_comprovante;
    }


    public Double getTotal_pagamento() {
        return total_pagamento;
    }

    public void setTotal_pagamento(Double total_pagamento) {
        this.total_pagamento = total_pagamento;
    }

    /*public Date getData_emissao() {
        return data_emissao;
    }

    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    public Date getData_pagamento() {
        return data_pagamento;
    }

    public void setData_pagamento(Date data_pagamento) {
        this.data_pagamento = data_pagamento;
    }*/
    

}
