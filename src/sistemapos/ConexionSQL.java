package sistemapos;

//LIBRERIAS
import java.sql.*;
import javax.swing.*;

public class ConexionSQL {

    //VARIABLES
    static Connection cn;
    static Statement st;
    static ResultSet rs;

    //METODO PARA HACER LA CONEXION A LA BASE DE DATOS
    public void conectar() {
        try {
            String url = "jdbc:mariadb://localhost:0000/nombreDB";
            cn = DriverManager.getConnection(url, "Usuario", "Password");
            st = cn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido conectar\n" + e);
        }
    }

}
