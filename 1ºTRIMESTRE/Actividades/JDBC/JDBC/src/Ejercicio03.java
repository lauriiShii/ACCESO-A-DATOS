import java.sql.SQLException;

public class Ejercicio03 {

	/**Añade el primer curso de la FP Básica con el tutor Pilar Baena García y las siguientes
asignaturas. Utiliza sentencias preparadas.**/
	
	public static void main(String[] args) throws SQLException {

		// ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();

		// AÑADIMOS EL PRIMER CURSO DE LA FP BASICA CON EL TUTOR PILAR GARCIA
		LibreriaJDBC.insertPreparadoTresDatos("curso","FPB", "1A", "PBG");
		
		//AÑADIMOS ASIGNATURAS
		LibreriaJDBC.insertPreparadoCuatroDatos("asignatura","OACE","Operaciones auxiliares para la configuración y la explotación", "7", "245");
		LibreriaJDBC.insertPreparadoCuatroDatos("asignatura","MMSCI","Montaje y mantenimiento de sistemas y componentes informáticos", "9", "315");
		
		//ASIGNAMOS LAS ASIGNATURAS A LOS PROFESORES CORRESPONDIENTES
		LibreriaJDBC.insertPreparadoCuatroDatos("reparto","FPB", "1A", "OACE", "JMG");
		LibreriaJDBC.insertPreparadoCuatroDatos("reparto","FPB", "1A", "MMSCI", "MPG");
		
		// CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}
