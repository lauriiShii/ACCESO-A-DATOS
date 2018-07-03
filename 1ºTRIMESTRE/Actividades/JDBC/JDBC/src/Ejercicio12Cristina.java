import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio12Cristina {
	
	static Connection conexion;
	
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		Class.forName("com.mysql.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/horario?useServerPrepStmts=true", "root",
				"root");
		System.out.println("conexion a la base de datos establecida con exito :)\n");
					
		String select = "select CodAsignatura from horario where codOe = ? and CodCurso = ? and CodAsignatura not in "
				+ "(select CodAsignatura from horario h1 where CodAsignatura like '@%' and codTramo in (Select CodTramo from horario h2 where h1.codtramo = h2.codtramo))"
				+ " order by substring(codTramo, 2), substring(codTramo, 1) like 'L%' desc, substring(codTramo, 1) like 'M%' desc, substring(codTramo, 1) like 'X%' desc, "
				+ "substring(codTramo, 1) like 'J%' desc;", codOe, codCurso; int cont = 1;
		PreparedStatement sentencia; 
		ResultSet result;
		
		codOe = "DAM";
		codCurso = "1A";
		System.out.println();
		sentencia = conexion.prepareStatement(select);
		sentencia.setString(1, codOe);
		sentencia.setString(2, codCurso);
		result = sentencia.executeQuery();
		
		while (result.next()){
			if (cont <= 5)
				System.out.printf("%5s%-8s |", "", result.getString(1));
			else {
				System.out.printf("\n%5s%-8s |", "", result.getString(1));
				cont = 1;
			}
			cont ++;
		}
		result.close();
		sentencia.close();
		result.close();
		conexion.close();
	}
}
