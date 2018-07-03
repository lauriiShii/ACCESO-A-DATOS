import java.sql.SQLException;

public class Ejercicio02 {

	/**Insertar la siguiente oferta educativa:
		cod_OE: FPB
		nombre: FP Básica Informática y comunicaciones
		tipo: FPB
		descripción: La formación profesional básica de informática y comunicaciones tiene una
		duración de 2000 horas repartidas entre dos cursos académicos incluyendo 240 horas de
		Formación en centros de trabajo (FCT) en empresas del Sector*/
		
		
	 /** @throws SQLException */
	
	public static void main(String[] args) throws SQLException {

		// ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();

		// MOSTRAMO INFORMACION DE UNA TABLA
		LibreriaJDBC.insertPreparadoCincoDatos("ofertaeducativa","FPB", "FP Básica Informática y comunicaciones", "La formación profesional básica de informática "
				+ "y comunicaciones tiene una duración de 2000 horas repartidas entre dos cursos académicos incluyendo "
				+ "240 horas de Formación en centros de trabajo (FCT) en empresas del Sector", "FPB", null);

		// CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}
