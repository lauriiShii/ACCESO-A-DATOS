package Ejercicio04;

import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import datos.Profesor;
import datos.SessionFactoryUtil;


public class MainIterator {
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		String select = "from Profesor";
		Query consulta = sesion.createQuery(select);
		Iterator<Profesor> it;
		Profesor p;
		
		consulta.setFetchSize(5);
		it = consulta.iterate();
		
		while (it.hasNext()){
			p = it.next();
			System.out.printf("Código: %s, Nombre: %s\n",p.getCodProf(), p.getNombre());
		}
		sesion.close();
	}
}
