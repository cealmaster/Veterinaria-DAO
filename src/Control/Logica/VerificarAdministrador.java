package Control.Logica;
import Control.DAO.MascotaDAO;



public class VerificarAdministrador {
    int rol;
    String usuario;
    String contrasena;
    public VerificarAdministrador(){
        VerificarAdministrador(usuario, contrasena, rol);
    }
    private MascotaDAO miMascotaDAO;

    public VerificarAdministrador(String usuario, String contrasena, int rol) {
          miMascotaDAO = new MascotaDAO();
        miMascotaDAO.VerificarAdministrador(usuario, contrasena, rol);
        
        
    }
        private void VerificarAdministrador(String usuario, String contrasena, int rol){
        miMascotaDAO = new MascotaDAO();
        miMascotaDAO.VerificarAdministrador(usuario, contrasena, rol);
        
    }
}
