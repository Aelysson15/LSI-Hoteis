
package controle;

import model.MQuarto;
import model.MServico;
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
public class Servico {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Servico","Descricao","Medida","Preco Venda"};
       
       String [] registro =new String [5];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from servico where nome like '%"+ buscar + "%' order by idservico desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idservico");
               registro [1]=rs.getString("nome");
               registro [2]=rs.getString("descricao");
               registro [3]=rs.getString("medida");
               registro [4]=rs.getString("preco_venda");

               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }

   } 
   
   public boolean Inserir (MServico dts){
       sSQL="insert into servico (nome,descricao,medida,preco_venda)" +
               "values (?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNome());
           pst.setString(2, dts.getDescricao());
           pst.setString(3, dts.getMedida());
           pst.setDouble(4, dts.getPreco_venda());
           
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
 
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
   
   public boolean editar (MServico dts){
       sSQL="update servico set nome=?,descricao=?,medida=?,preco_venda=?"+
               " where idservico=?";
 
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNome());
           pst.setString(2, dts.getDescricao());
           pst.setString(3, dts.getMedida());
           pst.setDouble(4, dts.getPreco_venda());
           
           pst.setInt(5, dts.getIdservico());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
   public boolean eliminar (MServico dts){
       sSQL="delete from servico where idservico=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdservico());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }  
    
}
