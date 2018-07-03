import java.sql.SQLException;

public class Ejercicio02 {

	/**Insertar la siguiente oferta educativa:
		cod_OE: FPB
		nombre: FP B�sica Inform�tica y comunicaciones
		tipo: FPB
		descripci�n: La formaci�n profesional b�sica de inform�tica y comunicaciones tiene una
		duraci�n de 2000 horas repartidas entre dos cursos acad�micos incluyendo 240 horas de
		Formaci�n en centros de trabajo (FCT) en empresas del Sector*/
		
		
	 /** @throws SQLException */
	
	public static void main(String[] args) throws SQLException {

		// ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();

		// MOSTRAMO INFORMACION DE UNA TABLA
		LibreriaJDBC.insertPreparadoCincoDatos("ofertaeducativa","FPB", "FP B�sica Inform�tica y comunicaciones", "La formaci�n profesional b�sica de inform�tica "
				+ "y comunicaciones tiene una duraci�n de 2000 horas repartidas entre dos cursos acad�micos incluyendo "
				+ "240 horas de Formaci�n en centros de trabajo (FCT) en empresas del Sector", "FPB", null);

		// CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}
