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
public class Vusuario {
    
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String rg;
    
    
    public Vusuario (int id, String nome, String endereco, String telefone, String rg){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.rg = rg;
    }
    
    public Vusuario(){
        
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
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getRg(){
        return rg;
    }
    
    public void setRg(String rg){
        this.rg = rg;
    }
}
