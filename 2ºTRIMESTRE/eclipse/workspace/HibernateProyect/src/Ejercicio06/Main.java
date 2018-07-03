package Ejercicio06;

import datos.Asignatura;
import datos.SessionFactoryUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
    	
        final String HQL = "FROM Asignatura WHERE horasSemanales IN(:numeros)";
        SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();

        ArrayList<Byte> numeros = new ArrayList<>();
        Asignatura asignatura;
        Query q;
        Iterator<Asignatura> it;

        numeros.add((byte) 3);
        numeros.add((byte) 4);
        numeros.add((byte) 6);

        //codigo
        q = session.createQuery(HQL);
        q.setParameterList("numeros", numeros);
        it = q.iterate();
        while (it.hasNext()) {
            asignatura = it.next();
            System.out.printf("%s%n", asignatura.getCodAsignatura());
        }

        session.close();
        System.exit(0);
    }
}