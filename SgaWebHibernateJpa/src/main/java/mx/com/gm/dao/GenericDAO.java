package mx.com.gm.dao;

import javax.persistence.*;

public class GenericDAO {
    
    protected static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String PU = "HibernatePU";

    public GenericDAO() {
        //iNSTANCIA LA fabrica si el valor es igual a nulo
        if(emf == null){
            emf = Persistence.createEntityManagerFactory(PU);
        }
    }
    
    protected EntityManager getEntityManager(){
        if(em == null){
            em = emf.createEntityManager();
        }
        return em;
    }
    
            
            
}
