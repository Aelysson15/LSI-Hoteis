package Controle;

import Dados.Vquarto;
import Dados.Vproduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Aelysson
 */
public class Fproduto {
    
   private Conexao mysql=new Conexao();
   private Connection cn=mysql.conectar();
   private String sSQL="";
   public Integer totalregistros;
   
   
   public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Produto","Descricao","Unidade Medida","Preco Venda"};
       
       String [] registro =new String [5];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from produto where nome like '%"+ buscar + "%' order by idproduto desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idproduto");
               registro [1]=rs.getString("nome");
               registro [2]=rs.getString("descricao");
               registro [3]=rs.getString("unidade_medida");
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
   
   public boolean insertar (Vproduto dts){
       sSQL="insert into produto (nome,descricao,unidade_medida,preco_venda)" +
               "values (?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNome());
           pst.setString(2, dts.getDescricao());
           pst.setString(3, dts.getUnidade_medida());
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
   
   public boolean editar (Vproduto dts){
       sSQL="update produto set nome=?,descricao=?,unidade_medida=?,preco_venda=?"+
               " where idproduto=?";
           
       
       try {
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNome());
           pst.setString(2, dts.getDescricao());
           pst.setString(3, dts.getUnidade_medida());
           pst.setDouble(4, dts.getPreco_venda());
           
           pst.setInt(5, dts.getIdproduto());
           
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
  
   public boolean eliminar (Vproduto dts){
       sSQL="delete from produto where idproduto=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdproduto());
           
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
