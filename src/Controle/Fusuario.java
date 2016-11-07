/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controle;

import Dados.Vusuario;
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
public class Fusuario {

    private Conexao mysql = new Conexao();
    private Connection con = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    public Integer totalregistros;

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nome", "Sobrenome", "Ultimonome", "Doc", "Número Documento", "Direcao", "Telefone", "Email", "Código"};

        String[] registro = new String[10];

        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select p.idpessoa,p.nome,p.sobrenome,p.ultimonome,p.tipo_documento,p.num_documento,"
                + "p.direcao,p.telefone,p.email,c.codigo_cliente from pessoa p inner join usuario c "
                + "on p.idpessoa=c.idpessoa where num_documento like '%"
                + buscar + "%' order by idpessoa desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idpessoa");
                registro[1] = rs.getString("nome");
                registro[2] = rs.getString("sobrenome");
                registro[3] = rs.getString("ultimonome");
                registro[4] = rs.getString("tipo_documento");
                registro[5] = rs.getString("num_documento");
                registro[6] = rs.getString("direccion");
                registro[7] = rs.getString("telefono");
                registro[8] = rs.getString("email");
                registro[9] = rs.getString("codigo_usuario");

                totalregistros = totalregistros + 1;
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(Vusuario dts) {
        sSQL = "insert into pessoa (nome,sobrenome,ultimonome,tipo_documento,num_documento,direcao,telefone,email)"
                + "values (?,?,?,?,?,?,?,?)";
        sSQL2 = "insert into usuario (idpessoa,codigo_usuario)"
                + "values ((select idpessoa from pessoa order by idpessoa desc limit 1),?)";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getSobrenome());
            pst.setString(3, dts.getUltimonome());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDirecao());
            pst.setString(7, dts.getTelefone());
            pst.setString(8, dts.getEmail());

            pst2.setString(1, dts.getCodigo_usuario());

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

    public boolean editar(Vusuario dts) {
        sSQL = "update pessoa set nome=?,sobrenome=?,ultimonome=?,tipo_documento=?,num_documento=?,"
                + " direcao=?,telefone=?,email=? where idpessoa=?";
        
        sSQL2 = "update usuario set codigo_usuario=?"
                + " where idpessoa=?";
        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);

            pst.setString(1, dts.getNome());
            pst.setString(2, dts.getSobrenome());
            pst.setString(3, dts.getUltimonome());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getNum_documento());
            pst.setString(6, dts.getDirecao());
            pst.setString(7, dts.getTelefone());
            pst.setString(8, dts.getEmail());
            pst.setInt(9, dts.getIdpessoa());

            pst2.setString(1, dts.getCodigo_usuario());
            pst2.setInt(2, dts.getIdpessoa());

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

    public boolean eliminar(Vusuario dts) {
        sSQL = "delete from pessoa where idpessoa=?";
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
}
