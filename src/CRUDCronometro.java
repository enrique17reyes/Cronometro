import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class CRUDCronometro {
    private Conexion conexion = new Conexion();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUDCronometro(){

        try{
            if((con = conexion.Conectar())== null){
                JOptionPane.showMessageDialog(null,"Error en la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public boolean guardarTiempo(String tiempo){
        try{
            String query = "INSERT INTO cronometraje Values('"+tiempo+"')";
            st.executeUpdate (query);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public  ResultSet getListaTiempos(){
        try{
            String query = "SELECT * FROM cronometraje";

            rs =  st.executeQuery (query);
            return rs;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean borrarTiempos(){
        try{
            String query = "DELETE FROM cronometraje";
            st.executeUpdate (query);
            return true;
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
