package Ejercicio10;

import datos.Profesor;
import datos.SessionFactoryUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import Teclado.Teclado;

import java.text.SimpleDateFormat;
import java.util.Iterator;

/**
 * Created by Alejandro on 21/01/2017.
 */
public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT DISTINCT p FROM Reparto r JOIN r.asignatura a JOIN r.profesor p " +
                "WHERE r.id.codOe = :codOe AND a.horasSemanales > " +
                "(SELECT AVG(asi.horasSemanales) FROM Reparto r JOIN r.asignatura asi WHERE r.id.codOe = :codOe GROUP BY r.id.codOe)";
        SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
        Session session = sesionFactory.openSession();

        Query q;
        Iterator it;

        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String codOe;

        //Código
        codOe = Teclado.next("¿De qué oferta educativa quieres buscar la media de las horas semanales de sus asignaturas?");
        q = session.createQuery(HQL);
        q.setParameter("codOe", codOe);
        q.setFetchSize(6);
        it = q.iterate();
        while (it.hasNext()) {
            Profesor p = (Profesor) it.next();
            System.out.printf("[Código: %s] [Nombre: %s] [Apellidos: %s] [Fecha de alta: %s]%n", p.getCodProf(), p.getNombre(), p.getApellidos(), formato.format(p.getFechaAlta()));
        }

        session.close();
        System.exit(0);
    }
}
