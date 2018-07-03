package Ejercicio02;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.Query;
import datos.SessionFactoryUtil;

public class MainHQL {

	public static void main(String[] args) {
		   SessionFactory sessionFactory = SessionFactoryUtil.getSessionFactory();
		   Session session = sessionFactory.openSession();
		   Transaction transaction = session.beginTransaction();

		  Query query = session
		    .createQuery("update Profesor set nombre = 'Koala', apellidos='Rimuelo Ortaz' where codProf='NEW'");
		  System.out.println("Modifico el nombre del profesor.");

		  int filasModificadas = query.executeUpdate();
		  System.out.println("Filas afectadas: " + filasModificadas);

		  transaction.commit();
		  System.out.println("Cambio realizado.");

		  if (session.isOpen()) {
		   System.out.println("Closing session");
		   session.close();
		  }
		  if (!sessionFactory.isClosed()) {
		   System.out.println("Closing SessionFactory");
		   sessionFactory.close();
		  }

	}

}
