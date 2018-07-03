package Ejercicio002;

import java.io.File;
import java.io.IOException;

/**Realiza un programa que cree un directorio en el directorio actual, luego cree tres ficheros
   en dicho directorio donde uno se borre y otro se renombre. Crearle también un subdirectorio con un
   fichero dentro. Después mostrar la ruta absoluta de ambos directorios y sus contenidos.**/
public class Ejercicio002 {

	public static void main(String[] args) {

		//DECLARAMOS UN DIRECTORIO
		File dir1 = new File("Dir");
		
		//DECLARAMOS 3 FICHEROS
		File fich1 = new File("Dir/fichero1");
        File fich2 = new File("Dir/fichero2");
        File fich3 = new File("Dir/fichero3");
        
        //DECLARAMOS UN SUBDIRECTORIO EN EL ANTERIOR CON UN FICHERO DENTRO
        File dir2 = new File("Dir/DirectorioInterno");
        File fich4 = new File("Dir/DirectorioInterno/ficherito");
        
        //ASUMIMOS QUE LOS DIRECTORIOS EXISTEN, A EXECEPCION DE ESTOS DOS ULTIMOS QUE SERAN LOS 
        //DIRECTORIOS GENERADOS
        dir1.mkdir();
        dir2.mkdir();
        
        //CREAMOS LOS FICHEROS DECLARADOS
        try {
            fich1.createNewFile();
            fich2.createNewFile();
            fich3.createNewFile();
            fich4.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        //BORRAMOS UN FICHERO
        fich1.delete();
        
        //RENOMBRAMOS UN FICHERO
        fich2.renameTo(new File("Dir/ficheroRenombrado"));
        
        //MOSTRAMOS RUTA ABSOLUTA DE AMBOS DIRECTORIOS
        System.out.printf("- Directorio 1: %s\n- Directorio 2: %s", dir1.getAbsolutePath(), dir2.getAbsolutePath());
        
        //MOSTRAMOS CONTENIDO DE AMBOS DIRECTORIOS
        System.out.printf("\n\nContenido del directorio 1 (%s):\n", dir1.getName());
        for (int i = 0; i < dir1.list().length; i++)
            System.out.println(dir1.list()[i]);

        System.out.printf("\nContenido del directorio 2(%s):\n", dir2.getName());
        for (int i = 0; i < dir2.list().length; i++)
            System.out.println(dir2.list()[i]);
        
	}

}
