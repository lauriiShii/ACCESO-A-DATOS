import java.sql.SQLException;

public class Ejercicio11 {
	
	/**Mostrar qué asignaturas imparte un profesor.**/

	public static void main(String[] args) throws SQLException {
		
        //ABRIR CONEXION
        LibreriaJDBC.abrirConexion();

        //MOSTRAMOS CONTENIDO
        LibreriaJDBC.dimeQueAsignatura("AGL");
		
        //CERRAR CONEXION
        LibreriaJDBC.cerrarConexion();

	}
}
