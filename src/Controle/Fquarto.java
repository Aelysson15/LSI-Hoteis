package Controle;

import Dados.Vquarto;
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
 * @author aelysson
 */
public class Fquarto {
    private Conexao mysql= new Conexao();
    private Connection con=mysql.conectar();
    private String sSQL="";
    public Integer totalderegistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"id","número","andar","descrição",
            "características","preço","status","quarto tipo"};
        
        String [] registro = new String[8];
        totalderegistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        sSQL="select * from quarto where andar like '%" + buscar + "%' "
                + "order by idquarto";
        
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            
            while (rs.next()) {
                registro[0]=rs.getString("idquarto");
                registro[1]=rs.getString("numero");
                registro[2]=rs.getString("andar");
                registro[3]=rs.getString("descricao");
                registro[4]=rs.getString("idquarto");
                registro[5]=rs.getString("características");
                registro[6]=rs.getString("preco_diario");
                registro[7]=rs.getString("status");
                registro[8]=rs.getString("tipo_quarto");
                
                totalderegistros = totalderegistros+1;
                
                modelo.addRow(registro);
            }
            return modelo;
            
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
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
