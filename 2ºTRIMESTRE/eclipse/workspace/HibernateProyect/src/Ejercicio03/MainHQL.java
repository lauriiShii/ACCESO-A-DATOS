package Ejercicio03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import datos.SessionFactoryUtil;

public class MainHQL {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		Transaction transaccion = sesion.beginTransaction();
		int i, j;
		
		String insertHQL = "insert into Historicoprofesores (codProf, nombre, alta) select p.codProf, p.nombre, p.fechaAlta from Profesor p where p.codProf = :codProf";
		i = sesion.createQuery(insertHQL).setString("codProf", "NEW").executeUpdate();
		
		if (i == 1){
			System.out.println("Profesor agregado a la tabla de historicos.");
			String deleteHQL = "delete from Profesor p where p.codProf = :codProf";
			j = sesion.createQuery(deleteHQL).setString("codProf", "NEW").executeUpdate();
			
			if(j == 1)
				System.out.println("Profesor eliminado de profesores.");
		}
		
		transaccion.commit();
		sesion.close();
	}

}
