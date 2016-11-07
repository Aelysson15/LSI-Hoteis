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
public class Vfuncionario extends Vpessoa{
    int id;
    String nome;
    String funcao;
    String login;
    String senha;
    String estado;

    public Vfuncionario() {
    }

    public Vfuncionario(int id, String nome, String funcao, String login, String senha, String estado) {
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.funcao = funcao;
        this.login = login;
        this.senha = senha;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
     
     
     
}
