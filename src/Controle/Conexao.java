package Controle;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aelysson
 */
public class Conexao {
    public String db="bdreserva";
    public String url="jdbc:mysql://127.0.0.1" +db;
    public String user="root";
    public String pass="";
    
    public Conexao(){
        
    }
    
    public Connection conectar(){
        Connection link=null;
        
        try {
            Class.forName("org.gjt.nm.mysql.Driver");
            link=(Connection) DriverManager.getConnection(this.url, this.user, this.pass);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);
        }
        
        return link;
    } 
    
}