package Ejercicio015;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.LinkedList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

/** MOSTRAR LA AGENDA BONITA **/

public class Ejercicio015 {

	public static void main(String[] args) throws IOException {

		// CONSTANTES
		final String ASTERISCOS = "*****************************************************************************************************\n";
		final String INICIO = "\t\t\t\t\tAGENDA TELEFÓNICA\n";
		final String FIN = "\t\t\t\t\tFIN AGENDA TELEFÓNICA\n";

		// FORMATEADOR DE FECHAS PARA GSON
		Gson gson = new GsonBuilder().setPrettyPrinting().setDateFormat("dd/MM/yyyy").create();

		// OBJETOS NECESARIOS
		LinkedList<Contacto> lista; //lista donde vamos a guardar los contactos
		BufferedWriter escritor;//buffer que vamos a usar para obtener los datos y escribirlos
		FileReader lector;
		Type tipo = new TypeToken<LinkedList<Contacto>>() {}.getType(); // Se usa para convertir lo que hay en el json en objetos

		lector = new FileReader("ContactosJSONfechas.json");
		escritor = new BufferedWriter(new FileWriter("ContactosJSONfechas.txt"));
		lista = gson.fromJson(lector, tipo);

		//ESCRIBIMOS LOS DATOS EN UN TXT
		escritor.write(ASTERISCOS);
		escritor.newLine();
		escritor.write(INICIO);
		escritor.newLine();
		escritor.write(ASTERISCOS);
		escritor.newLine();
		
		//metemos la informacion de cada contacto entre asteriscos
		for (Contacto c : lista) {
			escritor.write(c.toString());
			escritor.newLine();
			escritor.write(ASTERISCOS);
			escritor.newLine();
		}
		escritor.write(FIN);
		escritor.newLine();
		escritor.write(ASTERISCOS);
		escritor.newLine();
		escritor.close();
		lector.close();

	}

}