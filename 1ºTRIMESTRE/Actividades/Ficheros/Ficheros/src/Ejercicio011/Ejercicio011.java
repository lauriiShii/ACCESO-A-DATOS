package Ejercicio011;

/**Dado el XML del ejercicio anterior, utilizando XStream, pásalo a un fichero binario sin
serialización de objetos. Compara que sea igual al fichero binario obtenido en el ejercicio 8. Haz la
comparación byte a byte.**/

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ListIterator;

import com.thoughtworks.xstream.XStream;

import Ejercicio008SinSerializar.Contacto;
import Ejercicio010.ListaContactos;

public class Ejercicio011 {

	private static DataOutputStream escribir;

	public static void main(String[] args) throws IOException {

		//DECLARACION DE VARIABLES Y OBJETOS
		FileInputStream leerAntiguo, leerNuevo;
		XStream xstream = new XStream();
		ListaContactos lista;
		
		//Usaremos el iterator para recorrer el fichero caracter a caracter y proceder a la comprobacion.
		ListIterator<Contacto> it;
		Contacto c;
		int i, j;
		boolean salir = false;

		//PASAMOS DE XML A FICHERO BINARIO SIN SENIALIZAR
		xstream.alias("Contactos", ListaContactos.class);
		xstream.alias("Contacto", Contacto.class);
		xstream.addImplicitCollection(ListaContactos.class, "lista");

		lista = (ListaContactos) xstream.fromXML(new FileInputStream("ContactosNoSerializable.xml"));
		it = lista.getLista().listIterator();

		escribir = new DataOutputStream(new FileOutputStream("ContactosNoSerializableXML.dat"));

		//AGREGAMOS LOS CONTACTOS SACADOS DEL XML AL LIST ITERATOR
		while (it.hasNext()) {
			c = it.next();
			agregarSinSerializar(c);
		}

		escribir.close();

		//COMPARAMOS EL FICHERO ANTIGUO Y NUEVO BYTE A BYTE
		leerAntiguo = new FileInputStream("binarioNoSerializable.dat");
		leerNuevo = new FileInputStream("ContactosNoSerializableXML.dat");

		while (!salir && (i = leerAntiguo.read()) != -1 && (j = leerNuevo.read()) != -1)
			if (i != j)
				salir = true;

		if (salir)
			System.out.println("Los ficheros no son iguales.");
		else
			System.out.println("Los ficheros son iguales.");

		leerAntiguo.close();
		leerNuevo.close();

	}

	//AGREGAR UN CONTACTO NO SENIALIZADO
	public static void agregarSinSerializar(Contacto c) throws IOException {
		escribir.writeUTF(c.nombreCont);
		escribir.writeUTF(c.telefono);
		escribir.writeUTF(c.direccion);
		escribir.writeInt(c.codP);
		escribir.writeBoolean(c.deboMoney);
		escribir.writeFloat(c.cantDeb);
	}
}