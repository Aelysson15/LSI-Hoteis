package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aelysson
 */
public class Conexao {
    public String db="basereserva";
    public String url = "jdbc:postgresql://localhost:5432/basereserva";
    public String user="postgres";
    public String pass="123";

    public Conexao() {
    }
    
    public Connection conectar(){
        Connection link=null;     
        try {
            Class.forName("org.postgresql.Driver");
            link=DriverManager.getConnection(this.url, this.user, this.pass);
            
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);      
        }
        return link;
    }
    
}
