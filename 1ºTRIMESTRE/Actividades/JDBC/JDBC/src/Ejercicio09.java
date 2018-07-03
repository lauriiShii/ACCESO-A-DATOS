import java.sql.SQLException;

public class Ejercicio09 {

	/**Mostrar de todos los cursos el nombre de la oferta educativa, la clave primaria del curso y el
nombre del tutor.

	 * @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
        
        //ABRIR CONEXION
        LibreriaJDBC.abrirConexion();

        //MOSTRAMOS CONTENIDO
        LibreriaJDBC.selectEscritaMostrarCuatroDatos("SELECT o.nombre,c.codOe, Codcurso, p.nombre FROM ofertaEducativa o, curso c, profesor p WHERE p.CodProf = tutor AND o.codOe = c.codOe");
		
        //CERRAR CONEXION
        LibreriaJDBC.cerrarConexion();
	}

}
