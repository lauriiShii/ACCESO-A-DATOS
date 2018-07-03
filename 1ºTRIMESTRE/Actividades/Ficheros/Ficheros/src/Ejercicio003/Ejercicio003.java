package Ejercicio003;

import java.io.File;

import Teclado.Teclado;

/** Realiza un programa que muestre el nombre y tipo (fichero o directorio) de los ficheros y
	subdirectorios contenidos en un directorio solicitado al usuario. Mostrar también el contenido de
	todos los subdirectorios y si éstos contienen subdirectorios también...y así sucesivamente hasta
	mostrar todo el contenido de dicho directorio.**/
public class Ejercicio003 {

	public static void main(String[] args) {
		
		//VARIABLES
        File buscar;
        String nombreF;

        //DATO SOLICITADO
        nombreF = Teclado.cadena("Escriba el nombre del fichero a buscar: ");

        //BUSCAMOS Y MOSTRAMOS LOS DATOS DEL FICHERO
        buscar = new File(nombreF);
        
        if (buscar.isDirectory()){
        	System.out.printf("\nEl directorio %s contiene: \n", nombreF);
        	listar(buscar, 0);
        }else
            System.out.println("El fichero no existe o no se encuentra en la ruta introducida.");

    }
	
	//LISTAMOS
	private static void listar(File directorio, int cont) {
    	String tab = "";
    	for (int i = 0; i < cont; i++)
    		tab += "\t";
        for (int i = 0; i < directorio.list().length; i++) {
        	System.out.printf("%s- Nombre: %s | Tipo: %s\n", tab, directorio.listFiles()[i].getName(), directorio.listFiles()[i].isDirectory()?"directorio":"fichero");
            if (directorio.listFiles()[i].isDirectory()) 
                listar(directorio.listFiles()[i], cont+1);
        }
	}

}


