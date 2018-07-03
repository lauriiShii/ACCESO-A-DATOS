import java.sql.SQLException;

public class Ejercicio01 {
	
	/**Mostrar información sobre las columnas de una tabla, sus claves primarias, las claves ajenas
existentes en la tabla y las claves ajenas que utilizan la clave primaria de esta tabla.*/
	
	/** @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();
		
		//MOSTRAMO INFORMACION DE UNA TABLA
		LibreriaJDBC.dameInformacionTabla("curso");
		//LibreriaJDBC.dameContenidoBDD();
		
		//CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}
