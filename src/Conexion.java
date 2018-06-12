import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {



   // public class ConexionMySQL {

        public String db = "bdboletaje";
        public String url = "jdbc:mysql://localhost:3306/" + db;
        public String user = "root";
        public String pass = "12345";
        Connection link = null;

    public Connection Conectar() {



        try {

            Class.forName("org.gjt.mm.mysql.Driver");

            link = DriverManager.getConnection(url,user,pass);
            return link;

        } catch (Exception ex) {

            ex.printStackTrace();
            return link;

        }




    }
}