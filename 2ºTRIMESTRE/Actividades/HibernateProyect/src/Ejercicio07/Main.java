package Ejercicio07;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import datos.SessionFactoryUtil;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        final String HQL = "SELECT r.id.codCurso, r.id.codOe, c.profesor.nombre, a.id.codAsignatura, a.nombre, a.horasSemanales, a.horasTotales " +
                "FROM Reparto r JOIN r.asignatura a JOIN r.curso c";
        SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();

        Object[] o;
        Query q;
        Iterator it;

        //Código
        q = session.createQuery(HQL);
        it = q.iterate();
        while (it.hasNext()) {
            o = (Object[]) it.next();
            System.out.printf("[Curso: %s %s][Tutor: %s] [CodAsignatura: %s] [Nombre: %s] [Horas semanales: %s] [Horas totales: %s]%n", o[0], o[1], o[2], o[3], o[4], o[5], o[6]);
        }

        session.close();
        System.exit(0);
    }
}
