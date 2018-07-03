package Ejercicio005;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import Teclado.Teclado;

/**Realiza un programa que dadas dos rutas, origen y destino, copie el archivo origen en el
   destino. El archivo origen es un fichero de texto y la copia se hará línea a línea (una línea se
   considera hasta que se encuentre un salto de línea) . Si el destino es un directorio, se copiará el
   archivo en dicho directorio, y si es un archivo, habrá varias opciones según un booleano:
	• Si el booleano es verdadero y el destino es un archivo existente, se reemplazará por el
	archivo origen.
	• Si el booleano es verdadero y el destino es un archivo inexistente, no se hará nada.
	• Si el booleano es falso y el destino es un archivo existente, se lanzará una excepción.
	• Si el booleano es falso y el destino es un archivo inexistente, no se hará nada.**/

public class Ejercicio005 {
	
		@SuppressWarnings("resource")
		public static void main(String[] args) throws Exception {
			
			File fichero, destino;
			PrintWriter escritor;
			BufferedReader lector;
			String linea; 
			boolean bool = false;
			
			//PEDIMOS UICACION
			fichero = new File(Teclado.cadena("- Introduzca la ruta del fichero que quiere copiar: "));
			
			//PEDIMOS UBICACION A DONDE VAMOS A MOVER
			destino = new File(Teclado.cadena("- Indique la ruta de destino: "));
			
			try {
				try {
					//COPIAMOS EL FICHERO EN EL BUFFER
					lector = new BufferedReader(new FileReader(fichero));
					
					//SI EL DESTINO ES UN DIRECTORIO SE COPIA EL ARCHIVO
					if (destino.isDirectory()){
						escritor = new PrintWriter(new File(destino.getAbsolutePath()+"\\"+fichero.getName().toString()));
						//ESCRIBIMOS EN EL NUEVO ARCHIVO
						while ((linea = lector.readLine()) != null)
								escritor.println(linea);
						
						System.out.println("\n- Fichero copiado.");
						escritor.close();
					
					} else {
						//EL DESTINO ES UN ARCHIVO EXISTENTE Y BOOL ES TRUE
						if (destino.exists() && bool){
							//SE REMPLAZA POR EL ARCHIVO ORIGEN
							escritor = new PrintWriter(destino);
							while ((linea = lector.readLine()) != null)
								escritor.println(linea);
							
							System.out.println("\n- Fichero copiado.");
							escritor.close();	
							
						// BOOL ES FALSO Y EL DESTINO ES UN ARCHIVO EXISTENTE
						} else if (!bool && destino.exists())
							//SE LANZA UNA EXCEPCION
							throw new Exception();
					}
					lector.close();
				} catch (FileNotFoundException e){
					System.out.println("\n- El fichero introducido no se ha encontrado.");
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
}
