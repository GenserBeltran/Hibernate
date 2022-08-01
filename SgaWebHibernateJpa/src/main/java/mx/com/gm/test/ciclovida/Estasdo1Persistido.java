package mx.com.gm.test.ciclovida;

import javax.persistence.*;
import mx.com.gm.domain.Contacto;


public class Estasdo1Persistido {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();
        
        //Objetivo 1. parasar de objeto transitivo a objeto persistido
        Contacto contacto = new Contacto();
        contacto.setEmail("clara");
        contacto.setTelefono("65415");
        
        //Objetivo 2 Persistiendo el Objeto
        em.getTransaction().begin();
        
        em.persist(contacto);
        
        em.getTransaction().commit();
        
        //Objetivo 3. estado detached
        System.out.println("contacto: " + contacto);
    }
}
