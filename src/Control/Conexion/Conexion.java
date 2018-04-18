package Control.Conexion;


import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JFileChooser;

public class Conexion {
    Properties propiedades= new Properties();
    private static String URLBD;
    private static String usuario;
    private static String contrasena;
    public Conexion(){
        Properties misPropiedades = new Properties();
        misPropiedades = cargar();
    }
    
    private File f;
        public Properties cargar() {
        try {
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
            fc.showOpenDialog(fc);
            f = fc.getSelectedFile();
            FileInputStream archivo = new FileInputStream(f);
            Properties propiedades = new Properties();
            propiedades.load(archivo);
            archivo.close();
            if (!propiedades.isEmpty()) {
                URLBD=propiedades.getProperty("URLBD");
                usuario=propiedades.getProperty("usuario");
                contrasena=propiedades.getProperty("contrasena");
                return propiedades;
            }
        } catch (HeadlessException e) {
            System.out.println("No se pudo cargar el archivo properties");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo properties");
        }
        return null;
    }
    
    private static Connection cn = null;
    private static Driver driver = new org.apache.derby.jdbc.ClientDriver();
   

    
    public static Connection getConexion() throws SQLException {
        DriverManager.registerDriver(driver);
        cn = DriverManager.getConnection(URLBD, usuario, contrasena);
        return cn;
    }
    public static void desconectar(){
      cn = null;
   }

}