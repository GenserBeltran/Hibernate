package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.dao.AsignacionDAO;
import mx.com.gm.dao.ContactoDAO;
import mx.com.gm.dao.CursoDAO;
import mx.com.gm.dao.DomicilioDAO;

public class TestDAOs {
    public static void main(String[] args) {
        
        
          //Listando los objetos ALUMNO
//        AlumnoDAO alumnoDAO = new AlumnoDAO();
//        System.out.println("Alumnos:");
//        imprimir(alumnoDAO.listar());

        //Listando los objetos DOMICILIO
//        DomicilioDAO domicilioDAO = new DomicilioDAO();
//        System.out.println("Domicilios:");
//        imprimir(domicilioDAO.listar());
        
        //Listando los objetos CONTACTO
//        ContactoDAO contactoDAO = new ContactoDAO();
//        System.out.println("Contactos:");
//        imprimir(contactoDAO.listar());
        
        //Listando los objetos Cursos
//        CursoDAO cursoDAO = new CursoDAO();
//        System.out.println("Cursos:");
//        imprimir(cursoDAO.listar());
        
        //Listando los objetos Asignaciones
        AsignacionDAO asignacionDAO = new AsignacionDAO();
        System.out.println("Asignaciones:");
        imprimir(asignacionDAO.listar());
        
    }
    
    private static void imprimir(List coleccion){
        for(Object o: coleccion){
            System.out.println("valor = " + o);
        }
    }
}
