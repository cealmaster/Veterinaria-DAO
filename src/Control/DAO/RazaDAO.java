/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control.DAO;

import Control.Conexion.Conexion;
import Modelo.MascotaVO;
import Modelo.RazaVO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author IvanCamilo
 */
public class RazaDAO {
    private Connection con;
    private Statement st;
    private ResultSet rs;
        public void insertarRazas(RazaVO raza) {
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Veterinaria.Razas VALUES(" + raza.getId() + ",'" + raza.getNombre() + "','" + raza.getDescripcion()+"')";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
    }
            public RazaVO consultarDescripcion(int Codigo){
        
        RazaVO raza= null;
        String consulta = "SELECT * FROM Veterinaria.Razas WHERE id="+Codigo;
        
        try {
            con = Conexion.getConexion();
            st = con.createStatement();
            rs = st.executeQuery(consulta);

                if (rs.next() ){
                
                raza= new RazaVO();
                raza.setDescripcion(rs.getString("descripcion"));
                }
            st.close();
           Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.println("No se pudo realizar la consulta");
        }
        return raza;
    }
            public ArrayList<MascotaVO> listaDeMascotasRaza(int idraza) {
        ArrayList<MascotaVO> misMascotas = new ArrayList<MascotaVO>();
        String consulta = "SELECT * FROM Veterinaria.Mascotas WHERE Mascotas.idraza="+idraza;
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
