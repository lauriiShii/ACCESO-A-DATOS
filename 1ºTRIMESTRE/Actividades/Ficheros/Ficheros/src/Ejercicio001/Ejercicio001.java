package Ejercicio001;
import java.io.File;
import Teclado.Teclado;

/**Realiza un programa que dado un fichero que se le solicite al usuario, muestre su nombre, si
   es un ejecutable, si est� oculto, la ruta relativa, la ruta absoluta y el tama�o.*/

public class Ejercicio001 {
	
    public static void main (String[] args){
    	
    	//VARIABLES
        File buscar;
        String nombreF;

        //DATO SOLICITADO
        nombreF = Teclado.cadena("Escriba el nombre del fichero a buscar: ");

        //BUSCAMOS Y MOSTRAMOS LOS DATOS DEL FICHERO
        buscar = new File(nombreF);
        
        if (buscar.exists())
            System.out.printf("\n- Nombre del fichero: %s\n- �Es un ejecutable?: %s\n- �Est� oculto?: %s\n- Ruta relativa: %s\n- Ruta absoluta: %s\n"
                    +"- Tama�o: %d\n\n", buscar.getName(), buscar.canExecute()?"si":"no", buscar.isHidden()?"si":"no", buscar.getPath(),
                    buscar.getAbsolutePath(), buscar.length());
        else
            System.out.println("El fichero no existe o no se encuentra en la ruta introducida.");

    }
}