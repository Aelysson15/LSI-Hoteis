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
public class Vpessoa {
    private int idpessoa;
    private String nome;
    private String documento;
    private String endereco;
    private String telefone;
    private String email;

    public Vpessoa() {
    }

    public Vpessoa(int idpessoa, String nome, String documento,
            String endereco, String telefone, String email) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setDirecao(String direcao) {
        this.endereco = endereco;
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
