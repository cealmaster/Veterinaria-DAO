package Control.Logica;

import Control.Conexion.Conexion;
import Control.DAO.MascotaDAO;
import Control.DAO.RazaDAO;
import Control.DAO.UsuarioDAO;
import Modelo.MascotaVO;
import Modelo.RazaVO;
import Modelo.UsuarioVO;
import Vista.InsertarUsuario;
import Vista.VentanaAdministrador;
import Vista.VistaRaza;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestorAdministrador {
    private MascotaDAO miMascotaDAO;
    InsertarUsuario iu;
    VentanaAdministrador v;
    VistaRaza vr;
    int id; String nombre; int edad;
    private UsuarioDAO miUsuarioDAO;
    private RazaDAO miRazaDAO;
    public GestorAdministrador() {
        
        invocarInterfaz();
       
    }
    public void invocarInterfaz(){
        v= new VentanaAdministrador (this);
        iu= new InsertarUsuario (this);
        vr= new VistaRaza(this);
        
    }
    
    public void registrarMascota(String nombre,int edad,int id, String raza, int idraza) {
        miMascotaDAO = new MascotaDAO();
        MascotaVO miMascota1 = new MascotaVO(id,nombre,edad, raza,idraza);
        miMascota1.setId(id);
        miMascota1.setNombre(nombre);
        miMascota1.setEdad(edad);
        miMascota1.setRaza(raza);
        miMascotaDAO.insertarDatos(miMascota1);
    
    }
        public void registrarRaza(int id, String nombre,String descripcion) {
        miRazaDAO = new RazaDAO();
        RazaVO miRaza1 = new RazaVO(id,nombre,descripcion);
        miRaza1.setId(id);
        miRaza1.setNombre(nombre);
        miRaza1.setDescripcion(descripcion);

        miRazaDAO.insertarRazas(miRaza1);
    }
        public void registrarUsuario(String usuario, String contrasena, int rol) {
        miMascotaDAO = new MascotaDAO();
        miUsuarioDAO = new UsuarioDAO();
        UsuarioVO miUsuario1 = new UsuarioVO(usuario, contrasena, rol);
        miUsuario1.setNombre(usuario);
        miUsuario1.setContraseña(contrasena);
        miUsuario1.setRol(rol);
        miMascotaDAO.insertarUsuario(miUsuario1);
        }
        

    public void obtenerRegistros() {
        miRazaDAO= new RazaDAO();
        miMascotaDAO = new MascotaDAO();
        MascotaVO miMascota;
        ArrayList<MascotaVO> listaMascotas = miMascotaDAO.listaDeMascotas();
        
        if (listaMascotas.size() > 0) {
            int numeroMascota = 0;
            for (int i = 0; i < listaMascotas.size(); i++) {
                numeroMascota++;
                miMascota = listaMascotas.get(i);
                System.out.println("****************Mascota " + numeroMascota + "**********************\n"+"Id Mascota: " + miMascota.getId()+"\n"+"Nombre Mascota: " + miMascota.getNombre()+"\n"+"Edad Mascota: " + miMascota.getEdad()+"\n"+"ID raza:"+miMascota.getIdraza()+"\n"+"*************************************************\n");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Actualmente no existen registros de mascotas");
        }
    }
        public void obtenerRegistrosRaza(int idraza) {
        miRazaDAO = new RazaDAO();
        MascotaVO miMascota;
        ArrayList<MascotaVO> listaMascotas = miRazaDAO.listaDeMascotasRaza(idraza);
       
        if (listaMascotas.size() > 0) {
            int numeroMascota = 0;
            for (int i = 0; i < listaMascotas.size(); i++) {
                numeroMascota++;
                miMascota = listaMascotas.get(i);
                System.out.println("****************Raza Elegida**************** \n \"****************Mascota " + numeroMascota + "**********************\n"+"Id Mascota: " + miMascota.getId()+"\n"+"Nombre Mascota: " + miMascota.getNombre()+"\n"+"Edad Mascota: " + miMascota.getEdad()+"\n"+"Raza: "+ miMascota.getRaza()+"\n"+"*************************************************\n");
            }
        } else {
            JOptionPane.showMessageDialog(null,"Actualmente no existen registros de mascotas con esa raza");
        }
    }
    
    public void eliminarMascota(int id){
        miMascotaDAO = new MascotaDAO();
        miMascotaDAO.eliminarMascota(id); 
        
    }
    
    public void modificarMascota(int id, String nombreModificado, int edadModificada){
        miMascotaDAO = new MascotaDAO();
        miMascotaDAO.modificarMascota(id,nombreModificado, edadModificada);
    }
    
    public void buscarMascota(int id) {
        miMascotaDAO = new MascotaDAO();
        miRazaDAO =new RazaDAO();
        
        MascotaVO mascotaEncontrada = miMascotaDAO.consultarMascota(id);
        RazaVO razaEncontrada= miRazaDAO.consultarDescripcion(id);
        if (mascotaEncontrada != null) {
            JOptionPane.showMessageDialog (null,"Resultados de la busqueda: \n ****************Mascota*************************\n"+"Id Mascota: " + mascotaEncontrada.getId()+"\n"+"Nombre Mascota: " + mascotaEncontrada.getNombre()+"\n"+"Edad Mascota: " + mascotaEncontrada.getEdad()+"\n"+"Raza: "+ mascotaEncontrada.getRaza()+"\n" +"Descripcion:"+razaEncontrada.getDescripcion()+"\n"+"*************************************************\n");
           

        } else {
            JOptionPane.showMessageDialog (null,"No existen una mascota con ese codigo");
        }
    }
    

}
