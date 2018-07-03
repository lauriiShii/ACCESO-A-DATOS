package Ejercicio08;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datos.Profesor;
import datos.SessionFactoryUtil;

public class Main {
	
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		String select = "from Profesor";
		Query consulta = sesion.createQuery(select);
		
		@SuppressWarnings("unchecked")
		List<Profesor> lista = consulta.list();
		
		for (Profesor p:lista)
			System.out.println(new ProfEj8(p).toString());
		
		sesion.close();
	}
}