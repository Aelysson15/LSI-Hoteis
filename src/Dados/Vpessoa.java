
package Dados;

/**
 *
 * @author cragl
 */
public class Vpessoa {
    
    private int id;
    private String nome;
    
    public Vpessoa (int id, String nome){
        this.id = id;
        this.nome = nome;
    }
    
    public Vpessoa(){
        
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
}
