package mx.com.gm.test.cascade;

import javax.persistence.*;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;

public class PersistenciaCascadaTest {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
        EntityManager em = emf.createEntityManager();
        
        //Crearemos tres objetos de tipo contacto domiclio para persistirlo en el objeto de alumno
         Domicilio domicilio = new Domicilio();
         domicilio.setCalle("Nogales");
         domicilio.setNoCalle("10");
         domicilio.setPais("China");
         
         Contacto contacto = new Contacto();
         contacto.setEmail("clarasdaa@gmail.com");
         contacto.setTelefono("541541");
         
         Alumno alumno = new Alumno();
         alumno.setNombre("Carlos");
         alumno.setApellido("Lara");
         alumno.setDomicilio(domicilio);
         alumno.setContacto(contacto);
         
         //Sin importar el orden de la creacion de las tablas y las llaves el CASCADE permite persistir la creacion del nuevo objeto
         
         //Se inicia la transaccion y se persiste el objeto de alumno y cerramos la transaccion con commit
         em.getTransaction().begin();
         em.persist(alumno);
         em.getTransaction().commit();
         
         //Validando el objeto creado
         System.out.println("Alumno" + alumno);
        
    }
}
