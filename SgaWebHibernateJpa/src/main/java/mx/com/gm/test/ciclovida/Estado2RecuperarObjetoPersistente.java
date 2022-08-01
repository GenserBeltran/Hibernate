package mx.com.gm.test.ciclovida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import mx.com.gm.domain.Contacto;

public class Estado2RecuperarObjetoPersistente {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();
        
        //Objetivo. Recuperando el objeto de tipo contacto id 2
        
        //1 Definir la variable que va recuperar el objeto
        Contacto contacto = null;
        
        //2. Recuperando el objeto
        contacto = em.find(Contacto.class, 2);
        
        //3. Estado Detached
        System.out.println("contacto: " + contacto);
    }
}
