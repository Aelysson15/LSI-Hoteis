
package controle;

import model.MQuarto;
import model.MPagamento;
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
public class Pagamento {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Idreserva","Comprovante","Número","Total"};
       
       String [] registro =new String [8];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from pagamento where idreserva="+ buscar + " order by idpagamento desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idpagamento");
               registro [1]=rs.getString("idreserva");
               registro [2]=rs.getString("tipo_comprovante");
               registro [3]=rs.getString("num_comprovante");
               registro [5]=rs.getString("total_pagamento");

               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }       
       
   } 
   
   public boolean adicionar (MPagamento dts){
       sSQL="insert into pagamento (idreserva,tipo_comprovante,num_comprovante,"
               + "total_pagamento)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdreserva());
           pst.setString(2, dts.getTipo_comprovante());
           pst.setString(3, dts.getNum_comprovante());
           pst.setDouble(5, dts.getTotal_pagamento());

           
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
   
   public boolean editar (MPagamento dts){
       sSQL="update pago set idreserva=?,tipo_comprovante=?,num_comprovante=?,total_pagamento=?"+
               " where idpagamento=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdreserva());
           pst.setString(2, dts.getTipo_comprovante());
           pst.setString(3, dts.getNum_comprovante());
           pst.setDouble(5, dts.getTotal_pagamento());
           /*pst.setDate(6, dts.getData_emissao());
           pst.setDate(7, dts.getData_pagamento());*/
           
           pst.setInt(6, dts.getIdpagamento());
           
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
  
   public boolean excluir (MPagamento dts){
       sSQL="delete from pagamento where idpagamento=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdpagamento());
           
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
