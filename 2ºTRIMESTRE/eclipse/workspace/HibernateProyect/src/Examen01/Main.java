package Examen01;

import java.util.Iterator;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datos.SessionFactoryUtil;

public class Main {

	// EJERCICIO 01 DEL EXAMEN
	public static void main(String[] args) {

		SessionFactory fabrica = SessionFactoryUtil.getSessionFactory();
		Session session = fabrica.openSession();

		Query query = session.createQuery(
				"select p.codProf, p.nombre, p.apellidos, c.id.codCurso, c.id.codOe, o.nombre, o.tipo, count(distinct a), count(distinct o2), count(distinct c2) "
				+ "from Profesor p left join p.cursos c left join c.ofertaeducativa o left join p.repartos r left join r.curso c2 left join c2.ofertaeducativa o2 left join r.asignatura a "
				+ "group by 1, 2, 3, 4, 5, 6, 7");

		Iterator it = query.iterate();

		while (it.hasNext()) {
			Object[] o = (Object[]) it.next();
			System.out.printf(
					" - codProf: %s | NombreProf : %s | Apellidos: %s | Tutor: %s | OfertaTutor: %s | OfertaTipo: %s | NumAsig: %s | NumOfeDif: %s | NumCursos :%s\n",
					o[0], o[1], o[2], o[3] == null ? "No es tutor" : o[3] + " " + o[4], o[5] == null ? "---" : o[5],
					o[6] == null ? "---" : o[6], o[7].toString(), o[8].toString(), o[9].toString());
		}

		session.close();

		System.exit(0);

	}
}
