package Ejercicio016;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Teclado.Teclado;

/**
 * Dado el fichero Json anterior, mostrar todos los datos de un contacto cuyo
 * nombre nos indique el usuario. La b�squeda se har� directamente en el fichero
 * Json. No utilizar Gson.
 **/

public class Ejercicio16 {

	public static void main(String[] args) throws IOException {

		// VARIABLES Y OBJETOS
		String linea, json = "", nombre;
		BufferedReader lector;
		String buscar;
		Pattern patron;
		Matcher matcher;

		nombre = Teclado.cadena("Indique un nombre a buscar: ");

		// CADENA QUE DEBERA BUSCAR
		buscar = String.format("\"nombreCont\":.+?\""+nombre+"\",(.+?)}",nombre);
		//buscar = String.format("(\"nombreCont\":\"%s\",\"telefono\": \".*\",\"direccion\": \".*\",\"codP\": \\d{5},\"fechaNacimiento\": \"\\d{2}/\\d{2}/\\d{4}\",\"deboMoney\": .+,\"cantDeb\": \\d+\\.\\d+)}",nombre);

		// CONVERTIMOS LA CADENA EN UN PATRON
		patron = Pattern.compile(buscar);

		//LEEMOS EL JSON CON EL BUFFER LINEA POR LINEA
		lector = new BufferedReader(new FileReader("ContactosJSONfechas.json"));

		//SI NO ESTA VACIA QUITAMOS LOS ESPACIOS
		while ((linea = lector.readLine()) != null)
			json += linea.trim(); // Quita los espacios.

		//INDICAMOS QUE TINE QUE BUSCAR CON EL MATCHER
		matcher = patron.matcher(json);
		
		//MOSTRAMOS LOS DATOS SEPARADOS POR COMAS
		while (matcher.find())
			System.out.println(matcher.group(1).replaceAll("\"", ""));

	}

}
