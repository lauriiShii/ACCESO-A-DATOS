import java.sql.SQLException;

public class Ejercicio04 {

	/**Aumenta las horas semanales y las horas totales en un 10% de aquellas asignaturas de la FP
	Básica que empiecen por M.**/
	
	/** @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();
		
		//AUMENTAMOS LOS VALORES
		LibreriaJDBC.actualizarEscrito("UPDATE asignatura SET HorasSemanales = HorasSemanales*1.10 AND HorasTotales = HorasTotales*1.10 WHERE CodAsignatura IN "
				+ "(SELECT CodAsignatura FROM reparto r WHERE CodOe = 'FPB') AND nombre like 'M%';");
		
		//CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();
	}

}
