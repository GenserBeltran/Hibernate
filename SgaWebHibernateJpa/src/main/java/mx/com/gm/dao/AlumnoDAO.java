package mx.com.gm.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import static mx.com.gm.dao.GenericDAO.em;
import mx.com.gm.domain.Alumno;
import org.hibernate.Hibernate;
import org.hibernate.Session;

public class AlumnoDAO extends GenericDAO {

    public List<Alumno> listar() {
        String consulta = "SELECT a FROM Alumno a";
        em = getEntityManager();
        Query query = em.createQuery(consulta);
        return query.getResultList();
    }

    public void insertar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }

    public void actualizar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }

    public void eliminar(Alumno alumno) {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
//        } finally {
//            if (em != null) {
//                em.close();
//            }
        }
    }

    public Alumno buscarPorId(Alumno alumno) {
        em = getEntityManager();
        return em.find(Alumno.class, alumno.getIdAlumno());
    }

    public Alumno buscarPB(int identificador) {

        Alumno alumno = null;
        List<Alumno> alumnos = new ArrayList<>();
        alumnos = this.listar();

        for (Alumno a : alumnos) {
            if (a.getIdAlumno() == identificador) {
                alumno = a;
                break;
            }
        }

        return alumno;

    }
}
