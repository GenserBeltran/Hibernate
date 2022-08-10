package mx.com.gm.web;

import java.io.IOException;
import java.util.List;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.domain.Alumno;
import mx.com.gm.domain.Contacto;
import mx.com.gm.domain.Domicilio;
import mx.com.gm.servicio.ServicioAlumno;
import org.hibernate.Hibernate;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                    this.editarAlumno(request, response);
                    break;

                default:
                    this.listarAlumnoDefault(request, response);
            }
        } else {
            this.listarAlumnoDefault(request, response);
        }
    }

    private void listarAlumnoDefault(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        List<Alumno> alumnos = servicioAlumno.listarAlumno();
        request.setAttribute("alumnos", alumnos);
        request.getRequestDispatcher("/WEB-INF/alumnos.jsp").forward(request, response);
    }

    private void editarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String idAlumnoS = request.getParameter("idAlumno");
        Integer idAlumno = Integer.parseInt(idAlumnoS);

        Alumno alumno = new Alumno(idAlumno);
        alumno.setIdAlumno(idAlumno);
        
        ServicioAlumno servicioAlumno = new ServicioAlumno();
        alumno = servicioAlumno.encontrarAlumno(alumno);

//        request.setAttribute("alumno", alumno);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("alumno", alumno);
        request.getRequestDispatcher("/WEB-INF/paginas/cliente/editarAlumno.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "guardar":
                    this.guardarAlumno(request, response);
                    break;
                case "modificar":
                    this.modificarAlumno(request, response);
                    break;
                default:
                    this.listarAlumnoDefault(request, response);
            }
        } else {
            this.listarAlumnoDefault(request, response);
        }
    }

    private void guardarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String calle = request.getParameter("calle");
        String noCalle = request.getParameter("noCalle");
        String pais = request.getParameter("pais");
        String email = request.getParameter("email");
        String telefono = request.getParameter("telefono");

        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(calle);
        domicilio.setNoCalle(noCalle);
        domicilio.setPais(pais);

        Contacto contacto = new Contacto();
        contacto.setEmail(email);
        contacto.setTelefono(telefono);

        Alumno alumno = new Alumno();
        alumno.setNombre(nombre);
        alumno.setApellido(apellido);
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);

        ServicioAlumno servicioAlumno = new ServicioAlumno();
        servicioAlumno.guardarAlumno(alumno);

        this.listarAlumnoDefault(request, response);

    }

    private void modificarAlumno(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String modificarS = request.getParameter("Modificar");
        ServicioAlumno servicioAlumno = new ServicioAlumno();

        if (modificarS != null) {
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String calle = request.getParameter("calle");
            String noCalle = request.getParameter("noCalle");
            String pais = request.getParameter("pais");
            String email = request.getParameter("email");
            String telefono = request.getParameter("telefono");

            HttpSession sesion = request.getSession();
            Alumno alumno = (Alumno) sesion.getAttribute("alumno");

            alumno.setNombre(nombre);
            alumno.setApellido(apellido);
            alumno.getDomicilio().setCalle(calle);
            alumno.getDomicilio().setNoCalle(noCalle);
            alumno.getDomicilio().setPais(pais);
            alumno.getContacto().setEmail(email);
            alumno.getContacto().setTelefono(telefono);

            servicioAlumno.guardarAlumno(alumno);

            sesion.removeAttribute("alumno");

        } else {
            //Eliminando el Alumno
            String idAlumnoS = request.getParameter("idAlumno");
            Integer idAlumno = Integer.parseInt(idAlumnoS);

            Alumno alumno = new Alumno(idAlumno);

            servicioAlumno.eliminarAlumno(alumno);
        }
        this.listarAlumnoDefault(request, response);
    }

}
