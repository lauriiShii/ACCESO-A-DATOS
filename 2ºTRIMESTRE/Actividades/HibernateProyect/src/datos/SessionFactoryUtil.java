package datos;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
	/**
	 * La f�brica de sesiones.
	 */
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		// Crea una SessionFactory de hibernate.cfg.xml.
		try {
			return new Configuration().configure()
					.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		} catch (Throwable e) {
			System.err.println("Creaci�n inicial de SessionFactory ha fallado. " + e);
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}