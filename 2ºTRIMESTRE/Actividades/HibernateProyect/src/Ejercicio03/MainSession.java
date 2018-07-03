package Ejercicio03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import datos.Historicoprofesores;
import datos.Profesor;
import datos.SessionFactoryUtil;

public class MainSession {
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		Transaction transaccion = sesion.beginTransaction();
		
		Profesor profe = (Profesor)sesion.load(Profesor.class, "NEW");
		Historicoprofesores newProf = new Historicoprofesores();
		
		newProf.setCodProf(profe.getCodProf());
		newProf.setNombre(profe.getNombre());
		newProf.setAlta(profe.getFechaAlta());
		
		sesion.save(newProf);
		System.out.println("Profe agregado al historico.");
		sesion.delete(profe);
		System.out.println("Profe borrado de la tabla profesores.");
		transaccion.commit();
		sesion.close();
	}
}
