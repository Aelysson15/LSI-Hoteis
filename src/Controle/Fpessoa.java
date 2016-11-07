package Controle;


import Dados.Vpessoa;
import com.sun.org.apache.xerces.internal.impl.dtd.models.DFAContentModel;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;
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
public class Fpessoa {
    
    private Conexao mysql= new Conexao();
    private Connection con=mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalderegistros;
    
    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;
        
        String[] titulos = {"ID", "Nome"};

        String[] registro = new String[2];

        totalderegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[1]=rs.getString("id");
                registro[2]=rs.getString("nome");
                
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
        sSQL = "insert into pessoa (nome)"
                + "values (?)";
        sSQL2 = "insert into pessoa (id)"
                + "values ((select id from pessoa order by id desc limit 1),?)";
        try {

            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            
            pst2.setInt(1, dts.getIdpessoa());

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
        sSQL = "update pessoa set nome=?, "
                + "where id=?";
        try {
            PreparedStatement pst = con.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdpessoa());
            pst.setString(2, dts.getNome());
                        
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
        sSQL = "delete from pessoa where id=?";
        sSQL2 = "delete from pessoa where nome=?";

        try {

            PreparedStatement pst = con.prepareStatement(sSQL);
            PreparedStatement pst2 = con.prepareStatement(sSQL2);

            
            pst.setInt(1, dts.getIdpessoa());
            pst2.setString(1, dts.getNome());

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
