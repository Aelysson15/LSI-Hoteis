package Controle;

import Dados.Vpessoa;
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
public class Fusuario extends Fpessoa{
    
    private Conexao mysql= new Conexao();
    private Connection con= mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalderegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"ID", "Nome", "Endereco", "Telefone", "Documento"};

        String[] registro = new String[5];

        totalderegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[1]=rs.getString("id");
                registro[2]=rs.getString("nome");
                registro[3]=rs.getString("endereco");
                registro[4]=rs.getString("telefone");
                registro[5]=rs.getString("documento");
                
                totalderegistros = totalderegistros+1;
                
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean inserir(Vpessoa dts) {
        sSQL = "insert into usuario (nome, endereco, telefone, documento)"
                + "values (?,?,?,?)";
        sSQL2 = "insert into usuario (id)"
                + "values ((select id from usuario order by id desc limit 1),?)";
        try {

            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            pst2.setInt(1, dts.getId());
            
            pst.setString(2, dts.getNome());
            pst.setString(3, dts.getEndereco());
            pst.setString(4, dts.getTelefone());
            pst.setString(5, dts.getDocumento());
            

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
    
    public boolean editar(Vpessoa dts){
        sSQL = "update usuario set nome=?, endereco=?, telefone=?, documento=? "
                + "where id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setInt(1, dts.getId());
            
            pst.setString(2, dts.getNome());
            pst.setString(3, dts.getEndereco());
            pst.setString(4, dts.getTelefone());
            pst.setString(5, dts.getDocumento());
                        
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
    
    public boolean deletar (Vpessoa dts) {
        sSQL = "delete from usuario where id=?";
        sSQL2 = "delete from usuario where nome=?";

        try {

            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            
            pst2.setInt(1, dts.getId());
            
            pst.setString(2, dts.getNome());
            pst.setString(3, dts.getEndereco());
            pst.setString(4, dts.getTelefone());
            pst.setString(5, dts.getDocumento());
            
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
}