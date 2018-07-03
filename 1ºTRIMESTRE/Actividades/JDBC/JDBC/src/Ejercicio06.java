import java.sql.SQLException;

public class Ejercicio06 {

	/**Mostrar todos los datos de los profesores ordenados por:
			a) Apellidos en orden ascendente.
			b) Fecha de alta en el sistema en orden descendente.**/
	
	/** @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();
		
		//APELLIDOS EN ORDEN ASCENDENTE
		LibreriaJDBC.selectEscritaMostrarCuatroDatos("SELECT * from profesor ORDER BY apellidos ASC");
		
		//FECHA ALTA EN EL SISTEMA EN ORDEN DESCENDENTE
		LibreriaJDBC.selectEscritaMostrarCuatroDatos("SELECT * from profesor ORDER BY fechaAlta DESC");
		
		//CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();		

	}

}
