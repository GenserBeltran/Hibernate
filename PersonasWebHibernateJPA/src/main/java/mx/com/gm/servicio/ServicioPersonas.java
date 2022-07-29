package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {
    //Esta clase es la que aplica la tecnologia de EJB o Spring para conventirlas en clases transaccionales
    
    private PersonaDAO personaDao;

    public ServicioPersonas() {
    this.personaDao = new PersonaDAO();
    }
    
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
        
    }
}
