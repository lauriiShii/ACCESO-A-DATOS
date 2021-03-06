import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio12 {

	/**Mostrar el horario de un curso. A�adir un asterisco en aquellos tramos horarios donde haya
desdoble.**/
	
	public static void main(String[] args) throws SQLException {
		
	  // VARIABLES
	  final String ASTERISCO = "*";
	  ResultSet result;
	
	  // ABRIMOS CONEXION
	  LibreriaJDBC.abrirConexion();
	
	  /*result = LibreriaJDBC.selectEscrito("SELECT * FROM horario where codoe='DAM' and codcurso='1A'");
	
	  while (result.next()) {
	   // SI ES UN TRAMO CON DESDOBLE
	   if (result.getString(4).matches("@.+"))
	    System.out.printf(ASTERISCO);
	   
	    System.out.printf("%-5s | %-5s | %-5s | %s\n", result.getString(1),
	      result.getString(2), result.getString(3), result.getString(4));
	  }*/
	  
	  LibreriaJDBC.dameHorarioCurso("SMR", "1A", true);
	
	  // CERRAMOS CONEXION
	  LibreriaJDBC.cerrarConexion();

	}

}
