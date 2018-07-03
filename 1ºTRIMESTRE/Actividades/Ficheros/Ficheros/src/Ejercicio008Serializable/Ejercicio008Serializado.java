package Ejercicio008Serializable;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

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


public class Ejercicio008Serializado {
	
	public static void main(String[] args) {

		Contacto p1 = new Contacto("Manue", "4578", "SanPedro", 11300, false, 0f);
		Contacto p2 = new Contacto("Rosa", "4578", "SanPedro", 11300, false, 0f);
		
		ObjectInputStream leerOb;
		ObjectOutput escribirOb;
		
		try { 

			escribirOb = new ObjectOutputStream(new FileOutputStream("binarioSerializable.dat"));
			leerOb = new ObjectInputStream(new FileInputStream("binarioSerializable.dat"));
			
			escribirOb.writeObject(p1);
			escribirOb.writeObject(p2);
			escribirOb.close();
			
			try {
				
				while (true)
					System.out.println(leerOb.readObject().toString());
				
			} catch (EOFException e){
				
			} catch (ClassNotFoundException e){
				
			}
			
			leerOb.close();
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
		
		} 
	}
}
