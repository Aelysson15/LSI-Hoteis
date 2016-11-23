
package controle;

import model.MCliente;
import model.MServico;
import model.MFuncionario;
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
public class Funcionario {

    private Conexao mysql = new Conexao();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "Doc", "Número Documento", "Endereco", "Telefone", "Email", "Salario","Acesso","Login","Senha","Estado"};

        String[] registro = new String[14];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpessoa,p.nome,p.tipo_documento,p.num_documento,"
                + "p.endereco,p.telefone,p.email,t.salario,t.acesso,t.login,t.senha,t.estado from pessoa p inner join funcionario t "
                + "on p.idpessoa=t.idpessoa where num_documento like '%"
                + buscar + "%' order by idpessoa desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("endereco");
                registro[7] = rs.getString("telefone");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("salario");
                registro[10] = rs.getString("acesso");
                registro[11] = rs.getString("login");
                registro[12] = rs.getString("senha");
                registro[13] = rs.getString("estado");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean inserir(MFuncionario dts) {
        sSQL = "insert into pessoa (nome,tipo_documento,num_documento,endereco,telefone,email)"
                + "values (?,?,?,?,?,?)";
        sSQL2 = "insert into funcionario (idpessoa,salario,acesso,login,senha,estado)"
                + "values ((select idpessoa from pessoa order by idpessoa desc limit 1),?,?,?,?,?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getTelefone());
            pst.setString(6, dts.getEmail());

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());
            
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

    public boolean editar(MFuncionario dts) {
        sSQL = "update pessoa set nome=?,tipo_documento=?,num_documento=?,"
                + " endereco=?,telefone=?,email=? where idpessoa=?";
        
        sSQL2 = "update funcionario set salario=?,acesso=?,login=?,senha=?,estado=?"
                + " where idpessoa=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getTipo_documento());
            pst.setString(3, dts.getNum_documento());
            pst.setString(4, dts.getEndereco());
            pst.setString(5, dts.getTelefone());
            pst.setString(6, dts.getEmail());
            pst.setInt(7, dts.getIdpessoa());

            pst2.setDouble(1, dts.getSalario());
            pst2.setString(2, dts.getAcesso());
            pst2.setString(3, dts.getLogin());
            pst2.setString(4, dts.getSenha());
            pst2.setString(5, dts.getEstado());
            pst2.setInt(6, dts.getIdpessoa());

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

    public boolean eliminar(MFuncionario dts) {
        sSQL = "delete from funcionario where idpessoa=?";
        sSQL2 = "delete from pessoa where idpessoa=?";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            
            pst.setInt(1, dts.getIdpessoa());

            
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
    
    public DefaultTableModel login(String login,String senha) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "Acesso","Login","Senha","Estado"};

        String[] registro = new String[8];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpessoa,p.nome,t.acesso,t.login,t.senha,"
                + "t.estado from pessoa p inner join funcionario t "
                + "on p.idpessoa=t.idpessoa where t.login='"
                + login + "' and t.senha='" + senha + "' and t.estado='A'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[3] = rs.getString("acesso");
                registro[4] = rs.getString("login");
                registro[5] = rs.getString("senha");
                registro[6] = rs.getString("estado");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
