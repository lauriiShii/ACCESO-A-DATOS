package ExamenLauraFicheros;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;



import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class Ejercicio02 {
	public static void main(String[] args) throws IOException, SAXException, FileNotFoundException {

		XMLReader procesadorXML;
		GestionEmpleados gestor;
		InputSource fileXML;
		ObjectInputStream leer;
		
		//PROCESAMOS FICHERO FINARIO
		procesadorXML = XMLReaderFactory.createXMLReader();
		gestor = new GestionEmpleados();
		procesadorXML.setContentHandler(gestor);
		fileXML = new InputSource("Empleados.xml");
		procesadorXML.parse(fileXML);
		
		//MOSTRAMOS FICHERO BINARIO
		System.out.println("");
		
		leer = new ObjectInputStream(new FileInputStream("EmpleadosBinario.dat"));

		try {

			while (true)
				System.out.println(leer.readObject().toString());
			
		} catch (EOFException e){
			
		} catch (ClassNotFoundException e){
			
		}
		leer.close();
		
	}
		
}