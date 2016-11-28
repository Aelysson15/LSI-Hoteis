
package controle;

import model.MQuarto;
import model.MServico;
import model.MReserva;
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
public class Reserva {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","idquarto","Numero","idcliente","Cliente","idfuncionario","Funcionario","Tipo Reserva",
           /*"Data Reserva","Data Entrada","Data Saida",*/"Custo","Estado"};
       
       String [] registro =new String [13];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select r.idreserva,r.idquarto,h.numero,r.idcliente,"+
               "(select nome from pessoa where idpessoa=r.idcliente)as clienten,"+
               "r.idfuncionario,(select nome from pessoa where idpessoa=r.idfuncionario)as funcionario,"+
               "r.tipo_reserva"+
               "r.custo_alojamento,r.estado from reserva r inner join quarto h on r.idquarto=h.idquarto where r.idquarto '%"+ buscar + "%' order by idreserva desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idreserva");
               registro [1]=rs.getString("idquarto");
               registro [2]=rs.getString("numero");
               registro [3]=rs.getString("idcliente");
               registro [4]=rs.getString("clienten") ;
               registro [5]=rs.getString("idfuncionario");
               registro [6]=rs.getString("funcionario") ;
               registro [7]=rs.getString("tipo_reserva");
               /*registro [8]=rs.getString("data_reserva");
               registro [9]=rs.getString("data_entrada");
               registro [10]=rs.getString("data_saida");*/
               registro [8]=rs.getString("custo_alojamento");
               registro [9]=rs.getString("estado");
               
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
       
   } 
   
   public boolean insertar (MReserva dts){
       sSQL="insert into reserva (idquarto,idcliente,idfuncionario,tipo_reserva,"
               + "custo_alojamento,estado)" +
               "values (?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdquarto());
           pst.setInt(2, dts.getIdcliente());
           pst.setInt(3, dts.getIdfuncionario());
           pst.setString(4, dts.getTipo_reserva());
           /*pst.setDate(5, dts.getData_reserva());
           pst.setDate(6, dts.getData_entrada());
           pst.setDate(7, dts.getData_saida());*/
           pst.setDouble(5, dts.getCusto_alojamento());
           pst.setString(6, dts.getEstado());
           
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

   public boolean editar (MReserva dts){
       sSQL="update reserva set idquarto=?,idcliente=?,idfuncionario=?,"
               + "tipo_reserva=?,custo_alojamento=?,estado=?"+
               " where idreserva=?";
           
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
             pst.setInt(1, dts.getIdquarto());
           pst.setInt(2, dts.getIdcliente());
           pst.setInt(3, dts.getIdfuncionario());
           pst.setString(4, dts.getTipo_reserva());
           /*pst.setDate(5, dts.getData_reserva());
           pst.setDate(6, dts.getData_entrada());
           pst.setDate(7, dts.getData_saida());*/
           pst.setDouble(5, dts.getCusto_alojamento());
           pst.setString(6, dts.getEstado());           
           pst.setInt(7, dts.getIdreserva());
           
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
   
   public boolean pagar (MReserva dts){
       sSQL="update reserva set estado='Paga'"+
               " where idreserva=?";
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
             
           
           pst.setInt(1, dts.getIdreserva());
           
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
   
   public boolean eliminar (MReserva dts){
       sSQL="delete from reserva where idreserva=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdreserva());
           
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
