package Control.Logica;

import Control.Conexion.Conexion;
import Control.DAO.MascotaDAO;
import Control.DAO.UsuarioDAO;
import Modelo.MascotaVO;
import Vista.VentanaAdministrador;
import Vista.VentanaUsuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorUsuario {
 private UsuarioDAO miUsuarioDAO;
 VentanaUsuario v;
 int id; String nombre; int edad;
 
 public GestorUsuario(){
     invocarInterfaz();
 }
    public void invocarInterfaz(){
        v= new VentanaUsuario (this);
    }
 
     public void modificarMascota(int id, String nombreModificado, int edadModificada){
        miUsuarioDAO = new UsuarioDAO();
        miUsuarioDAO.modificarMascota(id,nombreModificado, edadModificada);
    }
    
    public void buscarMascota(int id) {
        miUsuarioDAO = new UsuarioDAO();
        MascotaVO mascotaEncontrada = miUsuarioDAO.consultarMascota(id);
        if (mascotaEncontrada != null) {
            JOptionPane.showMessageDialog (null,"Resultados de la busqueda: \n ****************Mascota*************************\n"+"Id Mascota: " + mascotaEncontrada.getId()+"\n"+"Nombre Mascota: " + mascotaEncontrada.getNombre()+"\n"+"Edad Mascota: " + mascotaEncontrada.getEdad()+"\n raza:"+mascotaEncontrada.getRaza()+"\n"+"ID Raza:"+mascotaEncontrada.getIdraza()+"\n"+"*************************************************\n");
           

        } else {
            JOptionPane.showMessageDialog (null,"No existen una mascota con ese codigo");
        }
    }
}
