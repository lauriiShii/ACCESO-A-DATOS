import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class Ejercicio08 {

	/**Del resultado de la consulta del ejercicio anterior, muestra el nombre de la columna, el tipo
de dato de dicha columna, si puede contener valores nulos y el máximo ancho de caracteres
de la columna.
	 * @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//VARIABLES
        ResultSet result;
        ResultSetMetaData meta;
        
        //ABRIR CONEXION
        LibreriaJDBC.abrirConexion();

        //MOSTRAMOS LA INFORMACION
        result = LibreriaJDBC.selectEscrito( "SELECT * FROM profesor LEFT JOIN curso ON CodProf = Tutor");
        meta = result.getMetaData();

        for (int i = 1; i < meta.getColumnCount(); i++)
            System.out.printf("Nombre:%-10s | Tipo de dato:%-10s |¿Admite nulos?:%-5s |Maximo ancho de caracteres:%s %n", meta.getColumnName(i), meta.getColumnTypeName(i), meta.isNullable(i) == 1?"Si":"No", meta.getColumnDisplaySize(i));

        //OTRA FORMA
        System.out.println("");
        
        ResultSetMetaData metadatos; int numColumnas;
		System.out.println("\n EJERCICIO 08");
		metadatos = result.getMetaData();
		numColumnas = metadatos.getColumnCount();
		for (int i = 1; i <= numColumnas; i++){
			System.out.println("- COLUMNA" +i+":");
			System.out.println("\tNombre columnas: " + metadatos.getColumnName(i));
			System.out.println("\tTipo: " + (metadatos.getColumnTypeName(i)).toLowerCase());
			System.out.printf("\t¿Puede ser nula?: %s\n", metadatos.isNullable(i)== 0? "no":"si");
			System.out.println("\tMáximo de caracteres: " + metadatos.getColumnDisplaySize(i) + "\n");
		}
		
        //CERRAR CONEXION
        LibreriaJDBC.cerrarConexion();
	}

}
