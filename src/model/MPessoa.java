
package model;

/**
 *
 * @author aelysson
 */
public class MPessoa {
    private int idpessoa;
    private String nome;
    private String tipo_documento;
    private String num_documento;
    private String endereco;
    private String telefone;
    private String email;

    public MPessoa() {
    }

    public MPessoa(int idpessoa, String nome, String tipo_documento, 
            String num_documento, String endereco, String telefone, String email) {
        this.idpessoa = idpessoa;
        this.nome = nome;
        this.tipo_documento = tipo_documento;
        this.num_documento = num_documento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public int getIdpessoa() {
        return idpessoa;
    }

    public void setIdpessoa(int idpessoa) {
        this.idpessoa = idpessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
  
    
}
