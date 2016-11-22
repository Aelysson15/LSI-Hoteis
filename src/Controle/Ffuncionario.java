package Controle;

import Dados.Vfuncionario;
import Dados.Vquarto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cragl
 */
public class Ffuncionario extends Fpessoa{
    
    private Conexao mysql= new Conexao();
    private Connection con= mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalderegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"ID", "Nome", "Login", "Senha", "Funcao"};

        String[] registro = new String[5];

        totalderegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[1]=rs.getString("id");
                registro[2]=rs.getString("nome");
                registro[3]=rs.getString("login");
                registro[4]=rs.getString("senha");
                registro[5]=rs.getString("funcao");
                
                totalderegistros = totalderegistros+1;
                
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean inserir(Vfuncionario dts) {
        sSQL = "insert into funcionario (nome, login, senha, funcao)"
                + "values (?,?,?,?)";
        sSQL2 = "insert into funcionario (id)"
                + "values ((select id from funcionario order by id desc limit 1),?)";
        try {

            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            pst2.setInt(1, dts.getId());
            
            pst.setString(2, dts.getNome());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getSenha());
            pst.setString(5, dts.getFuncao());
            

            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(Vfuncionario dts){
        sSQL = "update funcionario set nome=?, login=?, senha=?, funcao=? "
                + "where id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setInt(1, dts.getId());
            
            pst.setString(2, dts.getNome());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getSenha());
            pst.setString(5, dts.getFuncao());
                        
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean deletar (Vfuncionario dts) {
        sSQL = "delete from funcionario where id=?";
        sSQL2 = "delete from funcionario where nome=?";

        try {

            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            
            pst2.setInt(1, dts.getId());
            
            pst.setString(2, dts.getNome());
            pst.setString(3, dts.getLogin());
            pst.setString(4, dts.getSenha());
            pst.setString(5, dts.getFuncao());
            
            int n = pst.executeUpdate();

            if (n != 0) {
                int n2 = pst2.executeUpdate();

                if (n2 != 0) {
                    return true;

                } else {
                    return false;
                }

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    // adicionando, alterando e removendo quartos do sistema
    
    public boolean inserir(Vquarto dts){
        sSQL = "insert into quarto (numero, andar, descricao, "
                    + "caracteristicas, preco_diario, status, tipo_quarto)" 
                    + "values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPreco_diario());
            pst.setString(6, dts.getStatus());
            pst.setString(7, dts.getTipo_quarto());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean editar(Vquarto dts){
        sSQL = "update quarto set numero=?, andar=?, descricao=?, "
                + "caracteristicas=?, preco_diario=?, status=?, tipo_quarto=?"
                + "where idquarto=?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setString(1, dts.getNumero());
            pst.setString(2, dts.getAndar());
            pst.setString(3, dts.getDescricao());
            pst.setString(4, dts.getCaracteristicas());
            pst.setDouble(5, dts.getPreco_diario());
            pst.setString(6, dts.getStatus());
            pst.setString(7, dts.getTipo_quarto());
            pst.setInt(8, dts.getIdquarto());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }
    
    public boolean deletar(Vquarto dts){
        sSQL = " delete from quarto where idquarto=?";
        try {
            
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdquarto());
            
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }
}