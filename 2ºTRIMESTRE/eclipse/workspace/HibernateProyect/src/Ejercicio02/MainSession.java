package Ejercicio02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import datos.Profesor;
import datos.SessionFactoryUtil;

public class MainSession {

	public static void main(String[] args) {
		SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		Profesor profe = new Profesor();
		
		profe = (Profesor) session.load(Profesor.class, "NEW");
		System.out.println("Nombre antiguo: " + profe.getNombre());
		profe.setNombre("Pepito");
		System.out.println("Nuevo nombre: " + profe.getNombre());
		
		session.update(profe);
		transaction.commit();
		System.out.println("Profesor añadido");
		session.close();

	}

}
