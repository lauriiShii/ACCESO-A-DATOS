package Ejercicio007;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Teclado.Teclado;

/**Diseñar un programa para encriptar y desencriptar los datos de un fichero de texto. Se
   introduce una cadena por teclado que será la clave a aplicar para la encriptación y desencriptación.
   A cada carácter del fichero de texto original se le sumará una letra de la clave, cuando se hayan
   acabado las letras de la palabra clave y aún no se hayan acabado los caracteres del fichero, se
   volverá al principio de la cadena para seguir aplicando la encriptación. Los datos encriptados se
   escribirán en un fichero destino, que será usado como origen para desencriptar. Para desencriptar se
   aplicará la fórmula a la inversa. Por ejemplo, si el fichero origen contiene “abcdef” y la palabra
   clave es “rosa”, en el fichero destino se escribirán los caracteres correspondientes a: “a+r b+o c+s
   d+a e+r f+o”.**/

public class Ejercicio007 {
	
	public static void main(String[] args) {
		
		File origen = new File("./fichero.txt"), destinoEncriptado= new File("./Encriptado.txt"), destinoDesencriptado = new File("./Desencriptado.txt");
		String clave;
		
		//PEDIMOS CLAVE
		clave = Teclado.cadena("- Introduzca la clave de encriptación: ");

        try {
            encriptar(clave, origen, destinoEncriptado, true);
            encriptar(clave, destinoEncriptado, destinoDesencriptado, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void encriptar(String clave, File origen, File destino, boolean encriptar) throws IOException {
        int i, j = 0;
        FileReader leer = new FileReader(origen);
        FileWriter escribir = new FileWriter(destino);

        while ((i = leer.read()) != -1) {
            if (j == clave.length())
                j = 0;

            if (encriptar)
                escribir.append((char) (i + clave.charAt(j)));
            else
                escribir.append((char) (i - clave.charAt(j)));
            j++;
        }

        leer.close();
        escribir.close();
    }
}
