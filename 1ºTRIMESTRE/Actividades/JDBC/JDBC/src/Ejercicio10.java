import java.sql.SQLException;

public class Ejercicio10 {

	/**Mostrar cuándo se imparte una asignatura en un curso concreto.
	 * @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
        //ABRIR CONEXION
        LibreriaJDBC.abrirConexion();

        //MOSTRAMOS CONTENIDO
        LibreriaJDBC.dimeCuandoAsignatura("FOL", "1A", "DAM");
		
        //CERRAR CONEXION
        LibreriaJDBC.cerrarConexion();

	}

}
