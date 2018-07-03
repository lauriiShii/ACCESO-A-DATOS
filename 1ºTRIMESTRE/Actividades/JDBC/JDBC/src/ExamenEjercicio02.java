import java.sql.ResultSet;
import java.sql.SQLException;

public class ExamenEjercicio02 {

	/** @throws SQLException **/
	
	public static void main(String[] args) throws SQLException {
		
		//VARIABLES
        ResultSet result;
        final String NOMBRE = "ASIGNATURAS DEL IES SALADILLO";
        String reultadoAnterior = "";
		String ofertaAnterior = "";
		String cursoAnterior = "";

        
        //ABRIMOS CONEXION
        LibreriaJDBC.abrirConexion();
        
        result = LibreriaJDBC.selectEscrito("SELECT a.codasignatura, a.nombre, a.horassemanales, h.codoe, h.codcurso, t.codtramo, dia FROM asignatura a, horario h, tramohorario t WHERE a.codasignatura=h.codasignatura AND h.CodTramo=t.CodTramo  ORDER BY 1, 4, 5, 7, 6;");
        
        //CABEZERA
        ponEstrellas(60);
        System.out.printf(" %45s \n",NOMBRE);
        ponEstrellas(60);

        //MOSTRAR DATOS
		while (result.next()) {
			//UNA ASIGNATURA DIFERENTE A LA ANTERIOR
			if (!result.getString(1).equals(reultadoAnterior)) {

				reultadoAnterior = result.getString(1);
				ofertaAnterior = result.getString(4);
				cursoAnterior = result.getString(5);
				System.out.printf("\nCodigo: %s Nombre: %sHoras Semanales: %d\n\tCodigo curso: %s %sTramos horarios: %s",result.getString(1), result.getString(2), result.getInt(3), result.getString(4),result.getString(5), result.getString(6));

			}
			//SI ES LA MISMA HAY QUE MOSTRAR TODOS LOS CODIGOS Y LOS TRAMOS QUE EXISTAN
			else if (result.getString(1).equals(reultadoAnterior) && !(result.getString(4).equals(ofertaAnterior) && result.getString(5).equals(cursoAnterior))) {

				ofertaAnterior = result.getString(4);
				cursoAnterior = result.getString(5);
				System.out.printf("\n\tCodigo curso: %s %sTramos horarios: %s", result.getString(4),result.getString(5), result.getString(6));
			}
			
			//SI SOLO TIENE UN TRAMO LO MOSTRAMOS
			else

				System.out.printf(", %s", result.getString(6));

		}

		System.out.println("\n");
        //CERRAMOS CONEXION
        LibreriaJDBC.cerrarConexion();

	}
	
	public static void ponEstrellas (int num){
        int i;
        
        for(i = 0; i <= num; i++){
        	if(i == num)
        		System.out.println("*");
        	else
        		System.out.print("*");
        }
	}

}
