import java.sql.SQLException;

/** Mostrar dónde se encuentra un profesor en un tramo horario concreto. **/

public class Ejercicio13 {

	public static void main(String[] args) throws SQLException {

		//ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();

		/*
		 * LibreriaJDBC.
		 * selectEscritaMostrarDosDatos("select reparto.codcurso, reparto.codoe from horario, reparto where "
		 * + "horario.codasignatura=reparto.codAsignatura " +
		 * "and codtramo='L5' " + "and codprof='DPD'");
		 */

		//MOSTRAMOS
		LibreriaJDBC.dondeEstaProfesor("DPD", "L5");

		//CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}