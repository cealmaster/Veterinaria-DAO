package Control.DAO;

import Control.Conexion.*;
import Control.Logica.GestorAdministrador;
import Modelo.MascotaVO;
import Modelo.RazaVO;
import Modelo.UsuarioVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MascotaDAO {

    private Connection con;
    private Statement st;
    private ResultSet rs;
    private ResultSet ru;
    private Connection co;
    private Statement s;
    private ResultSet r;

    public MascotaDAO() {
         con = null;
         st = null;
         rs = null;
    }
    private UsuarioDAO miUsuarioDAO;
        public MascotaVO VerificarAdministrador (String usuario,String contrasena, int rol){
        MascotaVO mascota = null;
        String consulta = "SELECT * FROM Veterinaria.Usuarios WHERE usuario='"+usuario+"' AND contrasena='"+contrasena+"' AND rol=1";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
          
                
                if (rs.next()){
                GestorAdministrador ga=new GestorAdministrador();
                }
                else {
                 miUsuarioDAO=new UsuarioDAO();
                 miUsuarioDAO.VerificarUsuario(usuario, contrasena, rol);
                 
                }
            st.close();
           Conexion.desconectar();
        } catch (SQLException ex) {}
        return mascota;
    }
    public MascotaVO consultarMascota (int Codigo){
        MascotaVO mascota = null;
        RazaVO raza= null;
        String consulta = "SELECT * FROM Veterinaria.Mascotas WHERE id="+Codigo;
        
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

                if (rs.next() ){
                mascota = new MascotaVO();
                raza= new RazaVO();
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setRaza(rs.getString("raza"));
                }
            st.close();
           Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return mascota;
    }
    public void insertarDatos(MascotaVO mascota) {
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Veterinaria.Mascotas VALUES(" + mascota.getId() + ",'" + mascota.getNombre() + "'," + mascota.getEdad() + ",'"+ mascota.getRaza()+"',"+mascota.getIdraza()+")";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
        public void insertarUsuario(UsuarioVO usuario) {
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Veterinaria.Usuarios VALUES('" + usuario.getNombre() + "','" + usuario.getContraseña() + "'," + usuario.getRol() + ")";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
    public void eliminarMascota(int codigo){
        String eliminacion = "DELETE FROM Veterinaria.Mascotas WHERE id="+codigo;
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            st.executeUpdate(eliminacion);
            st.close();
            Conexion.desconectar();
            System.out.println("el registro "+codigo+" ha sido elimindado");
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la eliminacion");
        }
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
    public ArrayList<MascotaVO> listaDeMascotas() {
        ArrayList<MascotaVO> misMascotas = new ArrayList<MascotaVO>();
        ArrayList<RazaVO> misRazas = new ArrayList<RazaVO>();
        String consulta = "SELECT * FROM Veterinaria.Mascotas ";
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);
            while (rs.next()) {
                MascotaVO mascota = new MascotaVO();
                
                mascota.setId(rs.getInt("id"));
                mascota.setNombre(rs.getString("nombre"));
                mascota.setEdad(rs.getInt("edad"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setIdraza(rs.getInt("idraza"));
                misMascotas.add(mascota);
               
                
            }
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return misMascotas;
    }
}
