
package controle;

import model.MQuarto;
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
public class Quarto {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Número","Andar","Descrição","Caracteristicas","Preco","Estado","Tipo quarto"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from quarto where andar like '%"+ buscar + "%' order by idquarto";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idquarto");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("andar");
               registro [3]=rs.getString("descricao");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("preco_diario");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_quarto");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
   public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Número","Andar","Descrição","Caracteristicas","Preco","Estado","Tipo quarto"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from quarto where andar like '%"+ buscar + "%' and estado='Disponivel' order by idquarto";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idquarto");
               registro [1]=rs.getString("numero");
               registro [2]=rs.getString("andar");
               registro [3]=rs.getString("descricao");
               registro [4]=rs.getString("caracteristicas");
               registro [5]=rs.getString("preco_diario");
               registro [6]=rs.getString("estado");
               registro [7]=rs.getString("tipo_quarto");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
   public boolean insertar (MQuarto dts){
       sSQL="insert into quarto (numero,andar,descricao,caracteristicas,preco_diario,estado,tipo_quarto)" +
               "values (?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNumero());
           pst.setString(2, dts.getAndar());
           pst.setString(3, dts.getDescricao());
           pst.setString(4, dts.getCaracteristicas());
           pst.setDouble(5, dts.getPreco_diario());
           pst.setString(6, dts.getEstado());
           pst.setString(7, dts.getTipo_quarto());
           
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
   
   public boolean editar (MQuarto dts){
       sSQL="update quarto set numero=?,piso=?,descricao=?,caracteristicas=?,preco_diario=?,estado=?,tipo_quarto=?"+
               " where idquarto=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNumero());
           pst.setString(2, dts.getAndar());
           pst.setString(3, dts.getDescricao());
           pst.setString(4, dts.getCaracteristicas());
           pst.setDouble(5, dts.getPreco_diario());
           pst.setString(6, dts.getEstado());
           pst.setString(7, dts.getTipo_quarto());
           pst.setInt(8, dts.getIdquarto());
           
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
  
   public boolean desocupar (MQuarto dts){
       sSQL="update quarto set estado='Disponivel'"+
               " where idquarto=?";
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getIdquarto());
           
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

   public boolean ocupar (MQuarto dts){
       sSQL="update quarto set estado='Ocupado'"+
               " where idquarto=?";
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
          
           pst.setInt(1, dts.getIdquarto());
           
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
  
   
   
   
   public boolean eliminar (MQuarto dts){
       sSQL="delete from quarto where idquarto=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdquarto());
           
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
