package Ejercicio06;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import datos.Asignatura;
import datos.SessionFactoryUtil;

public class Cristin {

	public static void main(String[] args) {
		
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session sesion = sesionFactory.openSession();
		String select = "from Asignatura where horasSemanales in (3,4,6)";
		Query consulta = sesion.createQuery(select);
		
		@SuppressWarnings("unchecked")
		List<Asignatura> lista = consulta.list();
		
		for (Asignatura a:lista)
			System.out.printf("Código: %s, Nombre: %s, Horas semanales: %d, Horas totales: %d\n",a.getCodAsignatura(), a.getNombre(), a.getHorasSemanales(), a.getHorasTotales());
		
		sesion.close();

	}

}