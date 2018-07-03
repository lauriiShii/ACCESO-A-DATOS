package Ejercicio11;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import datos.SessionFactoryUtil;

import java.util.List;

/**
 * Created by Alejandro on 21/01/2017.
 */
public class Alex {
    public static void main(String[] args) {
        /*final String HQL = "SELECT new ejercicio11.CursoCompleto(" +
                "o.codOe, o.nombre, o.descripcion, o.tipo, o.fechaLey, c.id.codCurso, c.profesor)" +
                "FROM Ofertaeducativa o LEFT JOIN Curso c ON o.codOe = c.codOe";*/
        final String HQL = "SELECT new Ejercicio11.CursoCompleto(o, c) FROM Ofertaeducativa o LEFT JOIN o.cursos c";
		SessionFactory sesionFactory = SessionFactoryUtil.getSessionFactory();
		Session session = sesionFactory.openSession();

        Query q;
        List<CursoCompleto> lista;

        //Código
        q = session.createQuery(HQL);
        lista = q.list();
        for (CursoCompleto cursoCompleto: lista)
            System.out.println(cursoCompleto);

        session.close();
        System.exit(0);
    }
}
