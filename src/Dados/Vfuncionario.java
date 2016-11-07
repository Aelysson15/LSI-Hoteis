package Dados;

/**
 *
 * @author cragl
 */
public class Vfuncionario {
    
     private int id;
    private String nome;
    private String login;
    private String senha;
    private String funcao;
    
    
    public Vfuncionario (int id, String nome, String login, String senha, String funcao){
        this.id = id;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.funcao = funcao;
    }
    
    public Vfuncionario(){
        
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
    
    public String getLogin(){
        return login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getFuncao(){
        return funcao;
    }
    
    public void setFuncao(String funcao){
        this.funcao = funcao;
    }
}
