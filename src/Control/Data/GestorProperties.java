/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control.Data;

import Control.Conexion.Conexion;
import Modelo.MascotaVO;
import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JFileChooser;


public class GestorProperties {
        private static String URLBD;
    private static String usuario;
    private static String contrasena;
    Properties misPropiedades;
    private ArrayList <MascotaVO> mascotavo;
    private Connection con;
    private Statement st;
    
        public GestorProperties() {
        misPropiedades = new Properties();
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
                return propiedades;
            }
        } catch (HeadlessException e) {
            System.out.println("No se pudo cargar el archivo properties");
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo properties");
        }
        return null;
    }
        
    public void insertarDatosMascotas() {
        int mascotas= Integer.parseInt (misPropiedades.getProperty("mascotas"));

        for (int x = 1; x<=mascotas; x++){
            String i = misPropiedades.getProperty("mascota"+x+".id");
            int id=Integer.parseInt(i);
            String nombre = misPropiedades.getProperty("mascota"+x+".nombre");
            String ed = misPropiedades.getProperty("mascota"+x+".edad");
            int edad= Integer.parseInt(ed);
            String raza = misPropiedades.getProperty("mascota"+x+".raza");
            String idr = misPropiedades.getProperty("mascota"+x+".idraza");
            int idraza= Integer.parseInt(idr);
            try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Veterinaria.Mascotas VALUES(" + id + ",'" + nombre + "'," + edad + ",'"+ raza+"',"+idraza+")";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
        }
    }
        public void insertarDatosRazas() {
        int razas= Integer.parseInt (misPropiedades.getProperty("razas"));
        for (int x = 1; x<=razas; x++){
            String i = misPropiedades.getProperty("raza"+x+".id");
            int id=Integer.parseInt(i);
            String nombre = misPropiedades.getProperty("raza"+x+".nombre");
            String descripcion = misPropiedades.getProperty("raza"+x+".descripcion");
 
            try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Veterinaria.Razas VALUES(" + id + ",'" + nombre + "','"+ descripcion+"')";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
        }
    }
        public void insertarAdministrador() {

            String usuario = misPropiedades.getProperty("nombreadministrador");
            String contrasena = misPropiedades.getProperty("contrasenaadministrador");
            String ro = misPropiedades.getProperty("rol");
            int rol= Integer.parseInt(ro);
 
            try {
            con = Conexion.getConexion();
            st = con.createStatement();
            String insercion = "INSERT INTO Veterinaria.Usuarios VALUES('" + usuario + "','" + contrasena + "',"+ rol+")";
            st.executeUpdate(insercion);
            st.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            System.out.print("No se pudo realizar la insercion");
        }
        
    }

}
