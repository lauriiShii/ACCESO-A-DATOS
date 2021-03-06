package Ejercicio014;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.*;
import com.thoughtworks.xstream.XStream;

import Ejercicio008SinSerializar.Contacto;
import Ejercicio010.ListaContactos;

/**
 * A�partir�del�fichero�XML�de�la�agenda�telef�nica,�obtener�un�fichero�Json�utilizando�la�
 * librer�a�Gson.�
 **/

public class Ejercicio014 {
	public static void main(String[] args) throws IOException {
		
		//VARIABLES Y OBJETOS
		XStream xstream = new XStream();
		FileWriter escribirJson;
		ListaContactos lista;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		//GUARDAMOS LOS CONTACTOS DEL XML EN UNA LISTA
		xstream.alias("Contactos", ListaContactos.class);
		xstream.alias("Contacto", Contacto.class);
		xstream.addImplicitCollection(ListaContactos.class, "lista");

		//CON LA LISTA ESCRIBIMOS EL JSON
		try {
			escribirJson = new FileWriter("ContactosJSON.json");
			lista = (ListaContactos) xstream.fromXML(new FileInputStream("ContactosNoSerializable.xml"));
			escribirJson.write(gson.toJson(lista.getLista()));
			escribirJson.close();
		} catch (FileNotFoundException e) {

		} catch (IOException e) {

		}
	}

}
