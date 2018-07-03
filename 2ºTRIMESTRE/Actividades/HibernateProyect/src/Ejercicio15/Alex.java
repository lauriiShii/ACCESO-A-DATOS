package Ejercicio15;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import Teclado.Teclado;
import datos.SessionFactoryUtil;

import java.util.List;

/**
 * Created by Alejandro on 23/01/2017.
 */
public class Alex {
    public static void main(String[] args) {
        final String HQL = "SELECT c.id.codOe, c.id.codCurso, o.nombre, AVG(a.horasTotales) " +
                "FROM Curso c JOIN c.ofertaeducativa o JOIN c.repartos r JOIN r.asignatura a " +
                "GROUP BY c.id HAVING AVG(a.horasTotales) < " +
                "(SELECT AVG(asi.horasTotales) FROM Asignatura asi JOIN asi.repartos rep WHERE rep.profesor.codProf = :profe)";

		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

        Query q;
        List<Object[]> lista;
        String profe = Teclado.next("Introduce el código de un profesor");

        //Código
        q = session.createQuery(HQL);
        q.setParameter("profe", profe);
        lista = q.list();
        for (Object[] o:lista) {
            System.out.printf("[Oferta educativa: %s] [Curso: %s] [Nombre: %s]%n", o[0], o[1], o[2]);
        }

        session.close();
        System.exit(0);
    }
}
