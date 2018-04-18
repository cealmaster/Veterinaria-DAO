package Control.DAO;

import Control.Conexion.*;
import Control.Logica.GestorAdministrador;
import Control.Logica.GestorUsuario;
import Modelo.MascotaVO;
import Vista.IniciarSesion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UsuarioDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public UsuarioDAO(){

          con = null;
         st = null;
         rs = null;
    }
        public MascotaVO VerificarUsuario (String usuario, String contrasena, int rol){
        MascotaVO mascota = null;
        String consulta = "SELECT * FROM Veterinaria.Usuarios WHERE usuario='"+usuario+"' AND contrasena='"+contrasena+"' AND rol="+rol+" AND rol!=1";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
          
                
                if (rs.next()){
                GestorUsuario gu=new GestorUsuario();
                }
                else{
                JOptionPane.showMessageDialog(null, "no existe un usario con esas caracteristicas");
                IniciarSesion is= new IniciarSesion();
                }
            st.close();
           Conexion.desconectar();
        } catch (SQLException ex) {
            
        }
        return mascota;
    }
    public MascotaVO consultarMascota (int Codigo){
        MascotaVO mascota = null;
        String consulta = "SELECT * FROM Veterinaria.Mascotas WHERE id="+Codigo;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
                if (rs.next()){
                mascota = new MascotaVO();
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setIdraza(rs.getInt("idraza"));
                }
            st.close();
          Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return mascota;
    }
    public void modificarMascota(int id, String nombreModificado,int edadModificada) {

        String modificacion = "UPDATE Mascotas SET nombre='"+nombreModificado+"', edad="+edadModificada+"WHERE id="+id;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(modificacion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la modificacion");
        }
    }
}
