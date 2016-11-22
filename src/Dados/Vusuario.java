/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dados;

/**
 *
 * @author cragl
 */
public class Vusuario extends Vpessoa{
    private String codigo_usuario;

    public Vusuario() {
    }

    public Vusuario(String codigo_cliente) {
        this.codigo_usuario = codigo_cliente;
    }

    public String getCodigo_usuario() {
        return codigo_usuario;
    }

    public void setCodigo_usuario(String codigo_usuario) {
        this.codigo_usuario = codigo_usuario;
    }

    
}
