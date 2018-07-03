package Ejercicio05;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import Teclado.Teclado;
import datos.Profesor;
import datos.SessionFactoryUtil;

public class Main {

	public static void main(String[] args) {
		
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();
        final String HQL_COD = "FROM Profesor WHERE codProf = ?";
        final String HQL_NOMBRE = "FROM Profesor WHERE nombre = :nombre";

        String cod = Teclado.next("Introduce un codigo");
        String nombre = Teclado.next("Introduce un nombre");

        Profesor profesor;
        Query q;

        //Codigo
        q = session.createQuery(HQL_COD);
        q.setParameter(0, cod);
        profesor = (Profesor) q.uniqueResult();
        System.out.printf("%s %s %s %s%n", profesor.getCodProf(), profesor.getNombre(), profesor.getApellidos(), profesor.getFechaAlta());

        //Nombre
        q = session.createQuery(HQL_NOMBRE);
        q.setParameter("nombre", nombre);
        profesor = (Profesor) q.uniqueResult();
        System.out.printf("%s %s %s %s%n", profesor.getCodProf(), profesor.getNombre(), profesor.getApellidos(), profesor.getFechaAlta());

        session.close();
        System.exit(0);

	}

}
