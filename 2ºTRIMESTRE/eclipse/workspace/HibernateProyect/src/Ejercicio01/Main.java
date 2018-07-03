package Ejercicio01;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.Profesor;
import datos.SessionFactoryUtil;

public class Main {
	
	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Profesor profe = new Profesor();
		
		profe.setCodProf("NEW");
		profe.setFechaAlta(new Date());
		profe.setNombre("Nuevo");
		
		session.save(profe);
		transaction.commit();
		System.out.println("Profesor añadido");
		session.close();
		
	}
}