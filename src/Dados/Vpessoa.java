package Dados;

/**
 *
 * @author cragl
 */
public class Vpessoa {
    
    private int id;
    private String nome;
    private String endereco;
    private String telefone;
    private String documento;
    
    public Vpessoa (int id, String nome, String endereco, String telefone, String documento){
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.documento = documento;
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
    
    public String getDocumento(){
        return documento;
    }
    
    public void setDocumento(String documento){
        this.documento = documento;
    }
}