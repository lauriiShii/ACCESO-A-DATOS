package Ejercicio008SinSerializar;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
Queremos hacer una agenda telefónica con los siguientes datos:
	• Nombre del contacto
	• Teléfono
	• Dirección
	• Código postal (número entero)
	• Fecha de nacimiento
	• Si le debo dinero (booleano)
	• Cuánto le debo(número decimal)
	
Realiza un programa que almacene los datos en un fichero binario. A continuación, lee el fichero y
muestra el contenido por consola. Hacer dos versiones:
	• Sin serialización de objeto*
	• Con serialización de objeto
	
**/

public class Ejercicio008SinSerializar {
	
	//VARIABLES
	private static DataInputStream leer;
	private static DataOutputStream escribir;
	
	public static void main(String[] args) {
		
		//CREAMOS DOS CONTACTOS
		Contacto p1 = new Contacto("Pepe", "123", "rosales", 11300, true, 10.2f);
		Contacto p2 = new Contacto("Juan", "4578", "SanPedro", 11300, false, 0f);	
		
		try {
			
			//INICIALIZACION
			escribir = new DataOutputStream(new FileOutputStream("binarioNoSerializable.dat"));
			leer = new DataInputStream(new FileInputStream("binarioNoSerializable.dat"));
			
			//LOS AGREGAMOS SIN SERIALIZAR AL FICHERO BINARIO
			agregarSinSerializar(p1);
			agregarSinSerializar(p2);
			escribir.close();
			
			try {
				//LEEMOS EL FICHERO BINARIO SIN SERIALIZAR
				while (true)				
					System.out.println(leerSinSerializar());
			} catch (EOFException eo){}
			leer.close();
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
		} 
	}
	
	public static String leerSinSerializar() throws EOFException, FileNotFoundException, IOException {		
		float dinero;
		return String.format("Nombre: %s | Telefono: %s | Direccio: %s | CP: %d | ¿Debe dinero?: %s %s",
				leer.readUTF(), leer.readUTF(), leer.readUTF(), leer.readInt(), leer.readBoolean()?"Si":"No le debo dinero.", (dinero = leer.readFloat()) == 0?"":"| Cantidad debida: " + dinero);
	}
	public static void agregarSinSerializar(Contacto c) throws IOException{
		escribir.writeUTF(c.nombreCont);
		escribir.writeUTF(c.telefono);
		escribir.writeUTF(c.direccion);
		escribir.writeInt(c.codP);
		escribir.writeBoolean(c.deboMoney);
		escribir.writeFloat(c.cantDeb);
	}

}
