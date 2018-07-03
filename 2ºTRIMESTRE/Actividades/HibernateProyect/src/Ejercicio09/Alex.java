package Ejercicio09;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import Teclado.Teclado;
import datos.SessionFactoryUtil;

import java.util.Iterator;

/**
 * Created by Alejandro on 20/01/2017.
 */
public class Alex {
    public static void main(String[] args) {
        final String HQL = "SELECT r.id.codOe, AVG(a.horasSemanales) " +
                "FROM Reparto r JOIN r.asignatura a " +
                "WHERE r.id.codOe = :codOe " +
                "GROUP BY r.id.codOe";
        SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();

        Query q;
        Iterator it;

        String codOe;

        //Código
        codOe = Teclado.next("¿De qué oferta educativa quieres buscar la media de las horas semanales de sus asignaturas?");
        q = session.createQuery(HQL);
        q.setParameter("codOe", codOe);
        q.setFetchSize(2);
        it = q.iterate();
        while (it.hasNext()) {
            Object[] o = (Object[]) it.next();
            System.out.printf("[Oferta educativa: %s] [Media: %.2f]", o[0], (o[1]));
        }

        session.close();
        System.exit(0);
    }
}
