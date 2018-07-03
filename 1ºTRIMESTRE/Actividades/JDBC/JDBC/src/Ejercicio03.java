import java.sql.SQLException;

public class Ejercicio03 {

	/**A�ade el primer curso de la FP B�sica con el tutor Pilar Baena Garc�a y las siguientes
asignaturas. Utiliza sentencias preparadas.**/
	
	public static void main(String[] args) throws SQLException {

		// ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();

		// A�ADIMOS EL PRIMER CURSO DE LA FP BASICA CON EL TUTOR PILAR GARCIA
		LibreriaJDBC.insertPreparadoTresDatos("curso","FPB", "1A", "PBG");
		
		//A�ADIMOS ASIGNATURAS
		LibreriaJDBC.insertPreparadoCuatroDatos("asignatura","OACE","Operaciones auxiliares para la configuraci�n y la explotaci�n", "7", "245");
		LibreriaJDBC.insertPreparadoCuatroDatos("asignatura","MMSCI","Montaje y mantenimiento de sistemas y componentes inform�ticos", "9", "315");
		
		//ASIGNAMOS LAS ASIGNATURAS A LOS PROFESORES CORRESPONDIENTES
		LibreriaJDBC.insertPreparadoCuatroDatos("reparto","FPB", "1A", "OACE", "JMG");
		LibreriaJDBC.insertPreparadoCuatroDatos("reparto","FPB", "1A", "MMSCI", "MPG");
		
		// CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}
