import java.io.IOException;
import java.sql.SQLException;

public class resetBDD {
	public static void main(String[] args) throws SQLException, IOException {

		// ABRIMOS CONEXION
		LibreriaJDBC.abrirConexion();

		//RESET BDD
		LibreriaJDBC.ejecutarScriptCreacion();

		// CERRAMOS CONEXION
		LibreriaJDBC.cerrarConexion();

	}

}
