package Ejercicio004;

import java.io.File;
import java.io.FilenameFilter;

import Teclado.Teclado;

/**Un filtro sirve para que el método list devuelva solo aquellos archivos o carpetas que
   cumplan una condición (que tengan una extensión determinada, contengan en su nombre una
   cadena concreta, empiecen por un carácter, etc). Un filtro es un objeto de una clase que implementa
   el interface FilenameFilter. Realiza un programa que muestre los archivos de un directorio que
   posean una extensión concreta. Tanto la extensión como el directorio se solicita al usuario.**/
public class Ejercicio004 {

    public static void main(String[] args) {
        String ext;
        File dir;
        String[] ficheros;

        //PEDIMOS UBICACION
        dir = new File(Teclado.cadena("Indique el directorio donde desea buscar: "));
        
        //PEDIMOS EXTENSION
        ext = Teclado.cadena("Indique la extensión de los ficheros que desea listar: ");

        //CREAMOS UNA LISTA CON TODOS LOS ARCHIVOS DE LA UBICACION QUE CUMPLEN LA EXTENSION
        ficheros = dir.list(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                boolean r = false;
                if (name.matches(".+\\."+ext))
                    r = true;
                return r;
            }
        });
        
        //MOSTRAMOS LOS DATOS DE LA LISTA
        if (ficheros.length > 0) {
            System.out.println("\nSe han encontrado los siguientes ficheros con la extensión \'" + ext +"\': ");
            for (int i = 0; i < ficheros.length; i++)
                System.out.println("- " + ficheros[i]);
        } else
            System.out.println("\nNo se ha encontrado ningún fichero con la extensión '" + ext +"\'. ");

    }
}
