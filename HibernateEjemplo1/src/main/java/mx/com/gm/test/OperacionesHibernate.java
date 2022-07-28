package mx.com.gm.test;

import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class OperacionesHibernate {
    
    public static void main(String[] args) {
         
        PersonaDAO personaDAO = new PersonaDAO();
        
        //1. Metodo Listar
        //personaDAO.listar();
        
        //2. Metodo Insertar
//        Persona persona = new Persona();
//        persona.setNombre("Carlos");
//        persona.setApellido("Lara");
//        persona.setEmail("carlares@gmail.com");
//        persona.setTelefono("1657134");
//        personaDAO.insertar(persona);

        //3. Metodo Modificar
        //-->Recuperar el idPersona primero
//        Persona persona = new Persona();
//        persona.setIdPersona(37);
//        persona = personaDAO.buscarPersonaPorId(persona);
//        System.out.println("Persona encontrada: " + persona);
//        persona.setApellido("Firmino");
//        personaDAO.modificar(persona);

        //4. Metodo Eliminar
        Persona persona = new Persona();
        persona.setIdPersona(37);
        persona = personaDAO.buscarPersonaPorId(persona);
        System.out.println("Persona encontrada: " + persona);
        personaDAO.eliminar(persona);
        
        
    }
}
