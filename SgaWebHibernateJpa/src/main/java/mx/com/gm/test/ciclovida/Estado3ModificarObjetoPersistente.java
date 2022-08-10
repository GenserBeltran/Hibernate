package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado3ModificarObjetoPersistente {
     public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();
        
        //Objetivo. Recuperando el objeto de tipo contacto id 2 y lo modificamos
        
        //1 Definir la variable que va recuperar el objeto
        Contacto contacto = null;
        
        //Si se esta haciendo el ambio dentro de una transaccion se inicio el begiin si no no es necesario para este caso se hara fuera de la transaccion
        //em.getTransaction().begin();
        
        //2. Recuperando el objeto (Estado Deatached)
        contacto = em.find(Contacto.class, 2);
        
        //3. Se modifica el valor
        contacto.setEmail("clara@gmail.com");
        
        //3.1 Inicia la transaccion
        em.getTransaction().begin();
        
        //4. Pasa al estado de Persistido (merge() o persist()) y se hace el commit
        //em.persist(contacto);
        em.merge(contacto);
        em.getTransaction().commit();
        
        //5. Estado Detached
        System.out.println("contacto: " + contacto);
    }
}
