package Ejercicio13;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import datos.SessionFactoryUtil;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT c.id.codOe, c.id.codCurso, h.tramohorario.dia, a.nombre, COUNT(a.codAsignatura) " +
                "FROM Horario h JOIN h.curso c JOIN h.asignatura a " +
                "GROUP BY a.codAsignatura, h.tramohorario.dia, c.id " +
                "ORDER BY c.id, h.tramohorario.dia";

		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();

        Query q;
        Iterator it;
        Object[] o;

        //Código
        q = session.createQuery(HQL);
        it = q.iterate();
        while (it.hasNext()) {
            o = (Object[]) it.next();
            System.out.printf("[Curso: %s %s] [Día: %s] [Asignatura: %s] [Horas: %d]%n", o[0], o[1], o[2], o[3], o[4]);
        }

        session.close();
        System.exit(0);
    }
}