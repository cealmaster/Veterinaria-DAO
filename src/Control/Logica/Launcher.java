/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control.Logica;

import Control.Conexion.Conexion;
import Control.Data.GestorProperties;
import Vista.IniciarSesion;

public class Launcher {

    public static void main(String[] args) {
    Conexion cn= new Conexion();
    GestorProperties p= new GestorProperties();
    
    p.insertarAdministrador();
    p.insertarDatosMascotas();
    p.insertarDatosRazas();
    IniciarSesion lg=new IniciarSesion();
    
    }
    
}
