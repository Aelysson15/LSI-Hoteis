/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dados;

/**
 *
 * @author CARLOS
 */
public class Vpessoa {
    private int idpessoa;
    private String nome;
    private String sobrenome;
    private String ultimonome;
    private String tipo_documento;
    private String num_documento;
    private String direcao;
    private String telefone;
    private String email;

    public Vpessoa() {
    }

    public Vpessoa(int idpessoa, String nome, String sobrenome, 
            String ultimonome, String tipo_documento, String num_documento, 
            String direcao, String telefone, String email) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.ultimonome = ultimonome;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.direcao = direcao;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idppessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getUltimonome() {
        return ultimonome;
    }

    public void setUltimonome(String ultimonome) {
        this.ultimonome = ultimonome;
    }

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getNum_documento() {
        return num_documento;
    }

    public void setNum_documento(String num_documento) {
        this.num_documento = num_documento;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefono(String telefono) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    
}
