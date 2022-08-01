package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado4EliminarObjeto {
     public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();
        
        //Objetivo. Eliminar el objeto de tipo contacto id 2 
        
        //1 Definir la variable que va recuperar el objeto
        Contacto contacto = null;
        
        //2. Recuperando el objeto (Estado Deatached)
        contacto = em.find(Contacto.class, 4);
        
        //3 Inicia la transaccion, elimina el objeto y hace el commit
        em.getTransaction().begin();
        em.remove(em.merge(contacto));
        em.getTransaction().commit();
        
        //4. Estado Transitivo
        System.out.println("contacto: " + contacto);
    }
}
