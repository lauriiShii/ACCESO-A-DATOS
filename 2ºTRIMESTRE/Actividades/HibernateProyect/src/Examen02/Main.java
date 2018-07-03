package Examen02;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import datos.SessionFactoryUtil;

public class Main {

	@SuppressWarnings({ "rawtypes", "deprecation" })
	public static void main(String[] args) {

		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

		Query query = session.createQuery(
				"select c.id.codCurso, c.id.codOe, t.dia, count(distinct a) from Curso c left join c.horarios h left join h.tramohorario t left join h.asignatura a where h.asignatura not like '@%' group by 3, 1, 2 having count(distinct a)>(select count(distinct a) from Curso c left join c.horarios h left join h.tramohorario t left join h.asignatura a where h.asignatura not like '@%' and c.id.codCurso like :curso and c.id.codOe like :oferta and t.dia = :dia) order by 1, 2 ,3");

		query.setParameter("curso", Teclado.Teclado.next("Introduzca el curso: ", "[12]A"));
		query.setParameter("oferta", Teclado.Teclado.next("Introduzca la oferta: ", "DAM||SMR"));
		query.setParameter("dia", Teclado.Teclado.next("Introduzca el dia: ", "LUNES||MARTES||MIERCOLES||JUEVES||VIERNES"));
		
		Iterator it = query.iterate();

		while (it.hasNext()) {
			Object[] o = (Object[]) it.next();
			System.out.printf(" -Curso: %s | Dia: %s | NumAsig: %s\n", o[0] + " " + o[1], o[2], o[3].toString());
		}

		session.close();

		System.exit(0);
	}

}
