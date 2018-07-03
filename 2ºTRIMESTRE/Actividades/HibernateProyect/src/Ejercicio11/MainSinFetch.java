package Ejercicio11;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import datos.Curso;
import datos.Ofertaeducativa;
import datos.SessionFactoryUtil;

public class MainSinFetch {

	public static void main(String[] args) {
		
		Ofertaeducativa oe; 
		Curso c; 
		
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();
		final String HQL = "from Ofertaeducativa o left join o.cursos";
		
		
		Query cons = session.createQuery(HQL);
		Iterator<Object> it = cons.iterate();
		Object[] conjunto;

		while (it.hasNext()){
			conjunto = (Object[])it.next();
			oe = (Ofertaeducativa)conjunto[0];
			c = (Curso)conjunto[1];
			if (c != null)
				System.out.printf("- Oferta educativa: %s | idCurso: %s | tutor: %s\n", oe.getCodOe(), c.getId().getCodCurso(), c.getProfesor().getNombre());
			else 
				System.out.printf("- Oferta educativa: %s | %s\n", oe.getCodOe(), "No tiene curso.");
		}
		
		
		session.close();
		System.exit(0);

	}

}
