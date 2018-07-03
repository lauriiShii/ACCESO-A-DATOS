import java.sql.SQLException;

public class Ejercicio05 {

	/**La FP Básica desaparece del IES Saladillo. Borra de la base de datos todo lo que sea de
	dicha oferta educativa.**/
	
	/** @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();
		
		//BORRAMOS TODO LO REFERENTE A LA FP BASICA
		LibreriaJDBC.actualizarEscrito("DELETE FROM ofertaeducativa WHERE codOE = 'FPB'");
		
		//CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();		

	}

}
