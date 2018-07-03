package Libreria;

import java.io.File;
import java.io.IOException;

import Teclado.Teclado;
import Libreria.LibreriaFicheros;

public class Pruebas {

	public static void main(String[] args) throws IOException {
		
		/**PRUEBAS**/
		//B:\DAM\2CURSO\Sistemas\Practica\Atari Jaguar.pdf
		LibreriaFicheros.informacionFichero (new File(Teclado.cadena("- Introduzca ruta del fichero sobre el que desea saber informacion: ")));
		//B:\DAM\2CURSO\Sistemas\Practica
		LibreriaFicheros.mostrarContenidoDirectorio(new File(Teclado.cadena("- Introduzca ruta del directorio sobre el que desea saber su contenido: ")));
		LibreriaFicheros.mostrarContenidoDirectorioSubdirectorio(new File(Teclado.cadena("- Introduzca ruta del directorio sobre el que desea saber su contenido y el de sus subdirectorios: ")), 0);
		//B:\DAM\2CURSO\Acceso a datos\1ºTRIMESTRE\Actividades\PruebasFicheros\fichero.txt
		//B:\DAM\2CURSO\Acceso a datos\1ºTRIMESTRE\Actividades\PruebasFicheros\Destino
		LibreriaFicheros.copiarArchivo(new File(Teclado.cadena("- Introduzca ruta del fichero que desea copiar: ")), new File(Teclado.cadena("- Introduzca ruta donde desea copiar el fichero o sobre escribir uno: ")));
		//B:\DAM\2CURSO\Acceso a datos\1ºTRIMESTRE\Actividades\PruebasFicheros\fichero.txt
		//B:\DAM\2CURSO\Acceso a datos\1ºTRIMESTRE\Actividades\PruebasFicheros\ficheroSobreEscrito.txt
		LibreriaFicheros.copiarArchivo(new File(Teclado.cadena("- Introduzca ruta del fichero que desea copiar: ")), new File(Teclado.cadena("- Introduzca ruta donde desea copiar el fichero o sobre escribir uno: ")));
		
	}

}
