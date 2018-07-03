package Libreria;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ListIterator;

import com.thoughtworks.xstream.XStream;

import Ejercicio008SinSerializar.Contacto;
import Ejercicio010.ListaContactos;
import Teclado.Teclado;

public class LibreriaFicheros {
	
	//OBJETOS 
	private static DataOutputStream escribir;
	
	/**MUESTRA INFORMACION DE UN FICHERO**/
	public static void informacionFichero (File fichero){
        
        //SI EL FICHERO EXISTE MUESTRA SUS DATOS
        if (fichero.exists())
            System.out.printf("\n- Nombre del fichero: %s\n- ¿Es un ejecutable?: %s\n- ¿Está oculto?: %s\n- Ruta relativa: %s\n- Ruta absoluta: %s\n"
                    +"- Tamaño: %d\n\n", fichero.getName(), fichero.canExecute()?"si":"no", fichero.isHidden()?"si":"no", fichero.getPath(),
                    		fichero.getAbsolutePath(), fichero.length());
        else
            System.out.println("El fichero no existe o no se encuentra en la ruta introducida.");
	}
	/**MUESTRA EL CONTENIDO DE UN DIRECTORIO**/
	public static  void mostrarContenidoDirectorio(File dir){
		
		//RECORREMOS PARA MOSTRAR EL CONTENIDO
		System.out.printf("\n\nContenido del directorio 1 (%s):\n", dir.getName());
        for (int i = 0; i < dir.list().length; i++)
            System.out.println(dir.list()[i]);
	}
	
	/**MUESTRA EL CONTENIDO DE UN DIRECTORIO Y LOS SUBDIRECTORIOS**/
	//Cont es un contador que al inializar el metodo debe ser 0
	public static  void mostrarContenidoDirectorioSubdirectorio(File directorio, int cont){
		
		String tab = "";
		
		//RECORREMOS TODO EL CONTENIDO DEL DIRECTORIO
		 if (directorio.isDirectory()){
	        	System.out.printf("\nEl directorio %s contiene: \n", directorio);
	        	for (int i = 0; i < cont; i++)
	        		tab += "\t";
	            for (int i = 0; i < directorio.list().length; i++) {
	            	System.out.printf("%s- Nombre: %s | Tipo: %s\n", tab, directorio.listFiles()[i].getName(), directorio.listFiles()[i].isDirectory()?"directorio":"fichero");
	                if (directorio.listFiles()[i].isDirectory()) 
	                	mostrarContenidoDirectorioSubdirectorio(directorio.listFiles()[i], cont+1);
	            }
		 }      
		 else 
			 System.out.println("El fichero no existe o no se encuentra en la ruta introducida.");
	}
	
	/** COPIA UN ARCHIVO DE UN ORIGEN A UN DESTINO **/
	public static void copiarArchivo(File fichero, File destino) throws IOException{

		PrintWriter escritor;
		BufferedReader lector;
		String linea;
		boolean decision = false;

		try {
			// COPIAMOS EL FICHERO EN EL BUFFER
			lector = new BufferedReader(new FileReader(fichero));

			// SI EL DESTINO ES UN DIRECTORIO SE COPIA EL ARCHIVO
			if (destino.isDirectory()) {
				escritor = new PrintWriter(new File(destino.getAbsolutePath() + "\\" + fichero.getName().toString()));
				// ESCRIBIMOS EN EL NUEVO ARCHIVO
				while ((linea = lector.readLine()) != null)
					escritor.println(linea);

				System.out.println("\n- Fichero copiado.");
				escritor.close();

			} else {
				// EL DESTINO ES UN ARCHIVO EXISTENTE
				if (destino.exists()) {

					// SE REMPLAZA POR EL ARCHIVO ORIGEN SI EL USUARIO DICE QUE SI
					decision = Teclado.booleano("El fichero introducido ya existe, ¿Quieres sobre escribirlo?", "si",
							"no");
					if (decision) {
						escritor = new PrintWriter(destino);
						while ((linea = lector.readLine()) != null)
							escritor.println(linea);

						System.out.println("\n- Fichero copiado.");
						escritor.close();
					}
				}
			}
			lector.close();
		} catch (FileNotFoundException e) {
			//NO SE ENCONTRO EL FICHERO
			System.out.println("\n- El fichero introducido no se ha encontrado.");
		}
	}
	
	/**ENCRIPTAR UN FICHERO**/
	 public static void encriptar (String clave, File origen, File destino) throws IOException {
		 
	        int i, j = 0;
	        FileReader leer = new FileReader(origen);
	        FileWriter escribir = new FileWriter(destino);

	        //LEEMOS EL ORIGEN
	        while ((i = leer.read()) != -1) {
	        	
	        	//ENCRIPTAMOS INTRODUCIENDO LETRAS DE LA CLAVE
	            if (j == clave.length())
	            	j = 0;
	            
	            escribir.append((char) (i + clave.charAt(j)));
	            j++;
	        }

	        leer.close();
	        escribir.close();
	    }
	
	/**DESENCRIPTAR UN FICHERO**/
	 public static void desencriptar (String clave, File origen, File destino) throws IOException {
		 
	        int i, j = 0;
	        FileReader leer = new FileReader(origen);
	        FileWriter escribir = new FileWriter(destino);

	        //LEEMOS EL ORIGEN
	        while ((i = leer.read()) != -1) {
	        	
	        	//DESENCRIPTAMOS INTRODUCIENDO LETRAS DE LA CLAVE
	            if (j == clave.length())
	                j = 0;

	            escribir.append((char) (i - clave.charAt(j)));
	            j++;
	        }

	        leer.close();
	        escribir.close();
	    }
}
