package Dados;

/**
 *
 * @author cragl
 */
public class Vhotel {
    
    private String nome;
    private String endereco;
    
    public Vhotel(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }
    
    public Vhotel(){
        
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
}
