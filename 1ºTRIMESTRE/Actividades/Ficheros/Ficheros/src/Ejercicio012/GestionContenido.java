package Ejercicio012;

import java.io.IOException;
import java.io.PrintWriter;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GestionContenido extends DefaultHandler {
	
	//VARIABLES
	private PrintWriter escribir;
	String contenido = "";
	private final String prefijo = "(Attb.";

	//COSTRUCTOR
	public GestionContenido() throws IOException {
		super();
		//INDICAMOS QUE ARCHIVO ESCRIBIREMOS
		escribir = new PrintWriter("ContactosConAtributos.txt");
	}

	//INDICAMOS DE QUE ARCHIVO A QUE ARCHIVO ESTAMOS PASANDO LOS DATOS
	public void startDocument() throws SAXException {
		System.out.println("Parseando contenido de \"ContactosConAtributos.xml\" a \"ContactosConAtributos.txt\"");
	}

	//INDICA CUANDO ESTA FINALIZADO EL PROCESO
	public void endDocument() throws SAXException {
		System.out.println("fichero \"ContactosConAtributos.txt\" creado con el contenido de \"ContactosConAtributos.xml\"");
		escribir.close();
	}

	//INCORPORAMOS LOS NUEVOS ATRIBUTOS (QUE PRIMERO PUSIMOS A MANO EN EL XML)
	public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {
		if (!localName.equals("Contactos") && !localName.equals("Contacto"))
			escribir.print(localName + ": ");

		if (attributes.getLength() > 0)
			for (int i = 0; i < attributes.getLength(); i++)
				escribir.print(prefijo + attributes.getQName(i) + ": " + attributes.getValue(i) + ") ");
	}

	//CUANDO ESCRIBE UN ELEMENTO HACE UN SALTO DE LINEA
	public void endElement(String uri, String localName, String name) throws SAXException {
		if (localName.equals("Contacto"))
			escribir.println();
	}

	//METEMOS LOS ESPACIOS ENTRE CADA DATO
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		contenido = new String(ch, inicio, longitud);
		contenido = contenido.replaceAll("[\t\n ]", "");
		if (!contenido.equals("")) {
			contenido += ", "; // la coma se ve mejor que el espacio en blanco
			escribir.print(contenido);
		}
	}
}