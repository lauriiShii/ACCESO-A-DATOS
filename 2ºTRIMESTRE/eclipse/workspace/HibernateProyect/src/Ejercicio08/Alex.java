package Ejercicio08;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import datos.SessionFactoryUtil;

import java.util.Iterator;

/**
 * Created by Alejandro on 19/01/2017.
 */
public class Alex {
    public static void main(String[] args) {
        final String HQL = "SELECT new ejercicio08.CosasDeProfesores(p.codProf, p.nombre, COUNT(a.codAsignatura), SUM(a.horasSemanales), COUNT(DISTINCT r.curso.id)) " +
                "FROM Reparto r JOIN r.asignatura a JOIN r.profesor p " +
                "GROUP BY p.codProf";
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();

        Query q;
        Iterator it;

        //Código
        q = session.createQuery(HQL);
        it = q.iterate();
        while (it.hasNext()) {
            CosasDeProfesores cosasDeProfesores = (CosasDeProfesores) it.next();
            System.out.println(cosasDeProfesores);
        }

        session.close();
        System.exit(0);
    }
}
