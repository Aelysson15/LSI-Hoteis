
package controle;

import model.MDespesas;
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
public class Despesas {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   public Double totaldespesa;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","idreserva","idservico","servico","quantidade","Preco Venda","Estado"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       totaldespesa=0.0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select c.idservico,c.idreserva,c.idproducto,p.nome,c.quantidade,c.preco_venda "
               + ",c.estado from despesa c inner join servico p on c.idservico=p.idservico"
               + " where c.idreserva ="+ buscar + " order by c.iddespesa desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("iddespesa");
               registro [1]=rs.getString("idreserva");
               registro [2]=rs.getString("idservico");
               registro [3]=rs.getString("nome");
               registro [4]=rs.getString("quantidade");
               registro [5]=rs.getString("preco_venda");
               registro [6]=rs.getString("estado");
               
               totalregistros=totalregistros+1;
               totaldespesa=totaldespesa + (rs.getDouble("quantidade") * rs.getDouble("preco_venda") );
               
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
   } 
   
   public boolean insertar (MDespesas dts){
       sSQL="insert into despesa (idreserva,idservico,quantidade,preco_venda,estado)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdreserva());
           pst.setInt(2, dts.getIdservico());
           pst.setDouble(3, dts.getQuantidade());
           pst.setDouble(4, dts.getPreco_venda());
           pst.setString(5, dts.getEstado());
           
           
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
   
   public boolean editar (MDespesas dts){
       sSQL="update despesa set idreserva=?,idservico=?,quantidade=?,preco_venda=?,estado=?"+
               " where iddespesa=?";
           
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdreserva());
           pst.setInt(2, dts.getIdservico());
           pst.setDouble(3, dts.getQuantidade());
           pst.setDouble(4, dts.getPreco_venda());
           pst.setString(5, dts.getEstado());
           
           pst.setInt(6, dts.getIddespesa());
           
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
  
   public boolean eliminar (MDespesas dts){
       sSQL="delete from despesa where iddespesa=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIddespesa());
           
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
