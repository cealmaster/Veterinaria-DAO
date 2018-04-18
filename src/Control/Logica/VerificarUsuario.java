/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Control.Logica;

import Control.DAO.UsuarioDAO;


public class VerificarUsuario {
   int rol;
    String usuario;
    String contrasena;
    public VerificarUsuario(){
        VerificarUsuario(usuario, contrasena, rol);
    }
    private UsuarioDAO miUsuarioDAO;

    public VerificarUsuario(String usuario, String contrasena, int rol) {
          miUsuarioDAO = new UsuarioDAO();
        miUsuarioDAO.VerificarUsuario(usuario, contrasena, rol);
        
        
    }
        private void VerificarUsuario(String usuario, String contrasena, int rol){
        miUsuarioDAO = new UsuarioDAO();
        miUsuarioDAO.VerificarUsuario(usuario, contrasena, rol);
        
    } 
}
