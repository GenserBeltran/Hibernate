package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;
import mx.com.gm.domain.Alumno;

public class ServicioAlumno {

    private AlumnoDAO alumnoDAO = new AlumnoDAO();

    public List<Alumno> listarAlumno() {
        return alumnoDAO.listar();
    }

    public void guardarAlumno(Alumno alumno) {
        if (alumno != null && alumno.getIdAlumno() == null) {
            alumnoDAO.insertar(alumno);
        } else {
            alumnoDAO.actualizar(alumno);
        }
    }

    public void eliminarAlumno(Alumno alumno) {
        alumnoDAO.eliminar(alumno);
    }

    public Alumno encontrarAlumno(Alumno alumno) {
        return alumnoDAO.buscarPorId(alumno);
    }

    public void modificarAlumno(Alumno alumno) {
        alumnoDAO.actualizar(alumno);
    }

}
