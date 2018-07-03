import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Statement;

public class Ejercicio15 {

	static Connection conexion;
	
	public static void main(String[] args)throws SQLException, ClassNotFoundException  {
		/*
		Mostrar de cada asignatura el nombre, el número de horas a la semana, el número de cursos
		distintos donde se imparte, el número de ofertas educativas distintas donde se imparte, de
		aquellas asignaturas que tengan 3 o más horas a la semana. 
		*/
		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?useServerPrepStmts=true", "root",
				"root");
		String select = "select nombre, horasSemanales, (select count(distinct(codOe)) from reparto where CodAsignatura = a.CodAsignatura), "
				+ "(select count(distinct(codCurso)) from reparto where CodAsignatura = a.CodAsignatura) from asignatura a where horasSemanales >= 3;";
		Statement sentencia; ResultSet result;
		
		try {
			sentencia = (Statement) conexion.createStatement();
			result = sentencia.executeQuery(select);
			while (result.next())
				System.out.println("Nombre asignatura: " + result.getString(1) +" | Horas semanales: "+ result.getString(2) + " | Nº ofertas educativas: " + result.getString(3) + " | Nº cursos: " + result.getString(4));
			
			result.close();
			sentencia.close();
			result.close();
		} catch (SQLException e){e.printStackTrace();}
		conexion.close();
	}

}