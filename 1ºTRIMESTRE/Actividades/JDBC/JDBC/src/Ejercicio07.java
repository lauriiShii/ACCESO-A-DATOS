import java.sql.ResultSet;
import java.sql.SQLException;

public class Ejercicio07 {

	/**Mostrar todos los datos de los profesores y de los cursos de los que son tutores. Si no son
tutores, que aparezca “Este profesor no es tutor” en lugar de los datos del curso.**/
	
	/** @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//VARIABLES
		final String NO_TUTOR = "[Este profesor no es tutor]";
        ResultSet result;
        
        //ABRIMOS CONEXION
        LibreriaJDBC.abrirConexion();
        
        result = LibreriaJDBC.selectEscrito("SELECT * FROM profesor LEFT JOIN curso ON CodProf = Tutor;");
        
        while (result.next()) {
        	// MOSTRAMOS LOS DATOS DE LOS PROFESORES
            System.out.printf("[CodProf: %s] [Nombre: %s] [Apellidos: %s] [FechaAlta: %s] ", result.getString(1), result.getString(2), result.getString(3), result.getTimestamp(4));
            
            //SI NO ES PROFESOR LO INDICAMOS
            if (result.getString(5) == null)
                System.out.println(NO_TUTOR);
            
            //SI ES PROFESOR MOSTRAMOS LOS DATOS DE LA TABLA CURSO TAMBIEN
            else
                System.out.printf("[CodOe: %s] [CodCurso: %s] [Tutor: %s]%n", result.getString(5), result.getString(6), result.getString(7));
        }

        
        //CERRAMOS CONEXION
        LibreriaJDBC.cerrarConexion();

	}

}
