package Ejercicio009;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import Teclado.Rango;
import Teclado.Teclado;

/**
Partiendo del fichero binario del ejercicio anterior, crear un fichero de acceso aleatorio
donde vamos a poder hacer lo siguiente (el identificador empieza en 1):
	• Consultar el fichero entero (hacerlo de manera secuencial, no con el seek) (mostrarle al
	usuario los identificadores)
	• Consultar un contacto (pedirle al usuario el identificador)
	• Añadir un contacto
		➢ Por el final
		➢ En la primera posición libre
	• Eliminar un contacto (considerar baja lógica) (pedirle al usuario el identificador)
	• Modificar si le debo dinero y la cantidad (pedirle al usuario el identificador)
	• Compactación del fichero
	**/
/*
 * Espacio ocupado por contacto: 
 * 		boolean eliminado = 1 byte.
 * 		int id = 4 bytes;
 * 		String nombre = 10 * 2 = 20 bytes. --> 10 caracteres que ocupa la cadena * 2 bytes que ocupa cada char. 
 * 		String telefono = 9 * 2 = 18 bytes.
 * 		String direccion = 20 * 2 = 40.
 * 		int CP = 4 bytes.
 * 		boolean debodinero = 1 byte.
 * 		float CantidadDebida = 4 bytes. 
 * TOTAL = 92 bytes. 
 */
public class Ejercicio009 {
	
	/**ATRIBUTOS**/
	private final static int NUM_CHAR_NOMBRE = 10, NUM_CHAR_TLF = 9, NUM_CHAR_DIRECCION = 20;
	private final static byte ESPACIO_CONTACTO = 92, POSICION_DEBOMONEY = 87;
	public static File agenda = new File("binarioSerializabe.dat");
	private static RandomAccessFile ficheroAleatorio = null;
	private static StringBuffer buffer = new StringBuffer();

	/**MAIN**/
	public static void main(String args[]){
		
		//VACIAMOS LA AGENDA PARA COMENZAR DE 0
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(agenda));
			bw.write("");
			bw.close();
		} catch (IOException e) {
			
		}
		
		//CREAMOS 4 CONTACTOS**/
		Contacto p1 = new Contacto(1,"Cristin", "644282828", "Urb. Santa Margarita", 11300, true, 10.2f);
		Contacto p2 = new Contacto(2,"Eva", "956666666", "El faro Algeciras", 11300, false, 0f);
		Contacto p3 = new Contacto(3,"Ismael", "856121212", "Cerca Menendez Tolosa La Linea", 11300, false, 0f);
		Contacto p4 = new Contacto(4,"Carlos", "856787878", "San josé, centro", 11300, false, 0f);
		int opcion; boolean salir = false;
		
		do {
			/**MENU PRINCIPAL**/
			System.out.println("---------------------------------------------------------------------------------");
			opcion = Teclado.numeroInt("Indique la opción que desee: \n\n"
					+ "1. Consultar el fichero completo.\n"
					+ "2. Añadir contacto.\n"
					+ "3. Modificar si le debo dinero y la cantidad.\n"
					+ "4. Eliminar contacto.\n"
					+ "5. Compactar fichero.\n"
					+ "6. Consultar un contacto.\n"
					+ "7. Salir.\n"
					+ "\nRespuesta: ", 1, 7, Rango.INCLUIDO_MIN_MAX);
			System.out.println("---------------------------------------------------------------------------------\n");
			try {
				
				// SE INICIALIZA EL FICHERO ALEATORIO
				if (ficheroAleatorio == null){
					ficheroAleatorio = new RandomAccessFile(agenda, "rw");
					
					// AGREGAMOS LOS CONTACTOS A LA AGENDA
					agregarContactoAgenda(p1);
					agregarContactoAgenda(p2);
					agregarContactoAgenda(p3);
					agregarContactoAgenda(p4);
				}
				
				//CADA OPCION LLAMA AL METODO CORRESPONDIENTE
				switch (opcion) {
				case 1:
					leerFicheroCompleto();
					break;
				case 2:
					aniadirContacto();
					break;
				case 3:
					modificarDineroCantidad(Teclado.numeroInt("- Indique el ID del contacto al que desea modificar: "));
					break;
				case 4:
					eliminarContacto(Teclado.numeroInt("Indique el ID del contacto que quiere eliminar: "));
					break;
				case 5:
					compactarFichero();
					break;
				case 6:
					consultarContacto(Teclado.numeroInt("Indique el ID del contacto que quiere consultar: "));
					break;
				case 7:
					salir = true;
					ficheroAleatorio.close();
					break;
				}
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {

			}
		} while (!salir);
		
	}
	
	/**AGREGAR UN CONTACTO A LA AGENDA**/
	private static void agregarContactoAgenda(Contacto c) throws IOException{
		
		ficheroAleatorio.writeBoolean(false); // SI ES TRUE ES QUE ESTA ELIMINADO
		ficheroAleatorio.writeInt(c.id);			
		
		buffer.replace(0,buffer.length(), c.nombreCont);
		buffer.setLength(NUM_CHAR_NOMBRE); 
		ficheroAleatorio.writeChars(buffer.toString());
		buffer.delete(0, NUM_CHAR_NOMBRE);
		
		buffer.replace(0,buffer.length(), c.telefono);
		buffer.setLength(NUM_CHAR_TLF); 
		ficheroAleatorio.writeChars(buffer.toString());
		buffer.delete(0, NUM_CHAR_TLF);
		
		buffer.replace(0,buffer.length(), c.direccion);
		buffer.setLength(NUM_CHAR_DIRECCION); 
		ficheroAleatorio.writeChars(buffer.toString());
		buffer.delete(0, NUM_CHAR_DIRECCION);
		
		ficheroAleatorio.writeInt(c.codP);
		ficheroAleatorio.writeBoolean(c.deboDinero);
		ficheroAleatorio.writeFloat(c.cantDeb);
	}
	
	/**LEEMOS Y MOSTRAMOS LA AGENDA COMPLETA**/
	private static void leerFicheroCompleto() throws IOException{
		
		boolean eliminado; 
		long posicion = 0;
		
		//SI EL FICHERO TIENE MAS DE 0 CONTACTOS MOSTRAMOS EL CONTENIDO
		if (agendaTieneContenido(0) != 0){
			
			System.out.println("Contenido del fichero agenda:\n");
			
			//PRIMERO APUNTAMOS EN LA POSICION 0
			ficheroAleatorio.seek(posicion);
			
			//MIENTRAS LA POSICION QUE ES EL DESPLAZAMIENTO, SEA DIFERENTE AL FINAL DEL FICHERO
			while ((posicion = ficheroAleatorio.getFilePointer()) != ficheroAleatorio.length()){
				
				eliminado = ficheroAleatorio.readBoolean();
				
				//SI EL CONTACTO NO ESTA ELIMINADO
				if (!eliminado)
					System.out.println(leerContacto().toString());
				
				//SINO LA SALTA
				else {
					ficheroAleatorio.skipBytes(ESPACIO_CONTACTO - 1);
				}
			}
			
		//SINO EL FICHERO ESTA VACIO
		} else 
			System.out.println("La agenda está vacía.");
		System.out.println();
	}
	
	/**COMPRUEBA SI EL FICHERO ESTA VACIO Y DEVUELVE CUANTOS CONTACTOS TIENE**/
	private static int agendaTieneContenido(long posicion) throws IOException{
		
		int cont = 0;
		
		//COMENZAMOS EN EL INICIO DEL FICHERO
		ficheroAleatorio.seek(posicion);
		
		//SI EL DESPLAZAMIENTO NO ES EL FINAL DEL FICHERO
		if (ficheroAleatorio.getFilePointer() != ficheroAleatorio.length()){
			
			//SI EL CONTACTO NO ESTA ELIMINADO
			if (!ficheroAleatorio.readBoolean())
				cont++;
			
			//SINO PROBAMOS LA SIGUIENTE POSICION EXISTENTE
			else 
				cont = agendaTieneContenido(posicion + ESPACIO_CONTACTO);
		}
		return cont;
	}
	
	/**LEEMOS EL CONTACTO DE FORMA SECUENCIAL**/
	private static Contacto leerContacto() throws IOException{
		
		int id = 0, codP = 0, i; 
		boolean deboMoney = false; 
		float cantDeb = 0;
		String nombre = "", tlf = "", direccion = "";
		
		//INTRODUCIMOS EL ID
		id = ficheroAleatorio.readInt();
		buffer.setLength(NUM_CHAR_NOMBRE);
		buffer.delete(0, NUM_CHAR_NOMBRE);
		for (i = 0; i < NUM_CHAR_NOMBRE; i++)
			buffer.insert(i, ficheroAleatorio.readChar());
		
		//INTRODUCIOMOS EL NOMBRE
		nombre = buffer.toString();
		buffer.setLength(NUM_CHAR_TLF);
		buffer.delete(0, NUM_CHAR_TLF);
		for (i = 0; i < NUM_CHAR_TLF; i++)
			buffer.insert(i, ficheroAleatorio.readChar());
		
		//INTRODUCIMOS EL TELEFONO
		tlf = buffer.toString();
		buffer.setLength(NUM_CHAR_DIRECCION);
		buffer.delete(0, NUM_CHAR_DIRECCION);
		for (i = 0; i < NUM_CHAR_DIRECCION; i++)
			buffer.insert(i, ficheroAleatorio.readChar());
		
		//INTRODUCIMOS EL RESTO DE DATOS
		direccion = buffer.toString();
		codP = ficheroAleatorio.readInt();
		deboMoney = ficheroAleatorio.readBoolean();
		cantDeb = ficheroAleatorio.readFloat();
		
		return new Contacto(id,nombre, tlf, direccion, codP, deboMoney, cantDeb);
	}
	
	/**ANIADIMOS UN CONTACTO**/
	private static void aniadirContacto() throws IOException{
		
		int id, resp;
		
		//ID = (ID DEL ULTIMO CONTACTO DE LA LISTA + 1)
		ficheroAleatorio.seek((ficheroAleatorio.length()-ESPACIO_CONTACTO)+1);
		id = ficheroAleatorio.readInt() + 1;
		
		//MOSTRAMOS SUBMENU
		resp = Teclado.numeroInt("1. Agregar contacto al final del fichero.\n"
				+ "2. Agregar contacto en hueco existente.\n"
				+ "3. Volver atrás.\n"
				+ "\nRespuesta: ", 1, 3, Rango.INCLUIDO_MIN_MAX);
		
		//DEPENDE LO ESCOGIDO LLAMA A UN METODO U OTRO
		switch (resp) {
		case 1:
			aniadirAlFinal(id);
			break;
		case 2:
			aniadirEnHueco();
			break;
		case 3:
			System.out.println();
			break;
		}
	}

	/**ANIADIMOS UN CONTACTO AL FINAL DEL FICHERO**/
	private static void aniadirAlFinal(int id) throws IOException{
		
		//NOS POSICIONAMES EN EL FINAL DEL FICHERO Y AGREGAMOS UN NUEVO CONTACTO
		ficheroAleatorio.seek(ficheroAleatorio.length());
		agregarContactoAgenda(solicitarDatos(id));
		System.out.println("\n- Contacto agregado.\n");
	}
	
	/**SOLICITAMOS LOS DATOS DEL NUEVO CONTACTO**/
	private static Contacto solicitarDatos(int id){
		
		int codP; 
		String nombre, tlf, direccion; 
		boolean deboMoney; 
		float cantDeb = 0;
		
		nombre = Teclado.cadena("\n- Nombre: ");
		tlf = Teclado.cadena("- Teléfono: ");
		direccion = Teclado.cadena("- Direccion: ");
		codP = Teclado.numeroInt("- CP: ");
		deboMoney = Teclado.booleano("¿Le debo dinero?: ", "Si", "No");
		
		if (deboMoney)
			cantDeb = Teclado.numeroFloat("- Cantidad que le debes: ");
		
		//CREA EL CONTACTO
		return new Contacto(id, nombre, tlf, direccion, codP, deboMoney, cantDeb);
	}
	
	/**ANIADIMOS UN CONTACTO EN UN HUECO**/
	private static void aniadirEnHueco() throws IOException{
		
		boolean parar = false; 
		int id = 0;
		
		//APUNTAMOS AL PRINCIPIO DEL FICHERO
		ficheroAleatorio.seek(0);
		
		//MIENTRAS PARAR SEA FALSE Y EL DESPLAZAMIENTO DEL FICHERO SEA DIFERENTE DEL FINAL DEL FICHERO
		while (!parar && ficheroAleatorio.getFilePointer() != ficheroAleatorio.length())
			
			//SI EL CONTACTO ESTA ELIMINADO, NOS POSICIONAMOS EN EL PRINCIPIO DE DICHO CONTACTO
			if (ficheroAleatorio.readBoolean()){
				parar = true;
				id = ficheroAleatorio.readInt();
				ficheroAleatorio.seek(ficheroAleatorio.getFilePointer() - 5);
				agregarContactoAgenda(solicitarDatos(id));
			
			//SINO LO SALTAMOS
			} else {
				id = ficheroAleatorio.readInt();
				
				//-5 PORQUE YA HE LEIDO EL BOOLEAN Y EL ENTERO
				ficheroAleatorio.skipBytes(ESPACIO_CONTACTO - 5);
			}
		
		//AGREGAMOS EL CONTACTO
		if (!parar)
			agregarContactoAgenda(solicitarDatos(id+1));
		
		System.out.println("\n- Contacto agregado.\n");
	}
	
	/**CONSULTAMOS UN CONTACTO**/
	private static void consultarContacto(int id) throws IOException{
		
		long posicion = (id - 1) * ESPACIO_CONTACTO;
		
		//SI EL ID EXISTE
		if (posicion >= 0 && posicion < ficheroAleatorio.length()){
			
			//NOS POSICIONAMOS EN TAL CONTACTO QUE HACE REFERENCIA EL ID
			ficheroAleatorio.seek(posicion);
			
			//SI NO ESTA ELIMINADO EL CONTACTO LO MOSTRAMOS
			if (!ficheroAleatorio.readBoolean())
				System.out.println(leerContacto().toString());
		
		//SI NO EXISTE
		} else 
			System.out.println("El id introducido no se corresponde con ningún contacto.");
		
		System.out.println();
	}

	/**MODIFICAR EL DINERO QUE DEBO A uN CONTACTO**/
	private static void modificarDineroCantidad(int ID) throws FileNotFoundException, IOException{
		
		boolean resp; 
		long posicion = (ID - 1) * ESPACIO_CONTACTO; 
		float cantDeb = 0;
		
		//SI EL ID EXISTE
		if (posicion >= 0 && posicion < ficheroAleatorio.length()){
			
			//NOS POSICIONAMPS EN EL CONTACTO
			ficheroAleatorio.seek(posicion);
			
			//SI NO ESTA ELIMINADO EL CONTACTO LO MOSTRAMOS
			if (!ficheroAleatorio.readBoolean()){
				leerContacto();
			
				System.out.println();
				
				//NOS POSICIONAMOS EN EL BOOLEAN DE DEBER DINERO Y PREGUNTAMOS
				ficheroAleatorio.seek(posicion + POSICION_DEBOMONEY);
				resp = Teclado.booleano("¿Debes dinero al contacto?: ", "Si", "No");
				
				//SI ES SI SOBREESCRIBIMOS LOS DATOS
				if (resp){
					cantDeb = Teclado.numeroFloat("- Introduzca la cantidad que le debe: ");
					ficheroAleatorio.writeBoolean(resp);
					ficheroAleatorio.writeFloat(cantDeb);
					
				// SI NO DEBE DNERO SOBREESCRIBIMOS LOS DATOS
				} else {
					ficheroAleatorio.writeBoolean(resp);
					ficheroAleatorio.writeFloat(cantDeb);
				}
				
				//MOSTRAMOS EL CONTACTO ACTUALIZADO
				System.out.println("\n- Datos actualizados:");
				ficheroAleatorio.seek((ID-1)*ESPACIO_CONTACTO);
				if (!ficheroAleatorio.readBoolean())
					System.out.println(leerContacto().toString());
			}
		} else 
			System.out.println("- El id introducido no se corresponde con ningún contacto.");
		
		System.out.println();
	}
	
	/**ELIMINAR CONTACTO**/
	private static void eliminarContacto(int ID) throws FileNotFoundException, IOException{
		
		long posicion = (ID - 1)*ESPACIO_CONTACTO;
		
		//SI EL ID EXISTE
		if (posicion >= 0 && posicion < ficheroAleatorio.length()){
			
			//NOS POSICIONAMOS EN DICHO CONTACTO
			ficheroAleatorio.seek(posicion);
			
			//SI NO ESTA ELIMINADO, CAMBIAMOS SU writeBoolean A TRUE PARA QUE SE DE POR ELIMINADO
			if (!ficheroAleatorio.readBoolean()){
				ficheroAleatorio.seek(posicion);
				ficheroAleatorio.writeBoolean(true);
				System.out.println("Contacto eliminado.");
			} else 
				System.out.println("El id introducido no se corresponde con ningún contacto.");
		}else 
			System.out.println("El id introducido no se corresponde con ningún contacto.");
		
		System.out.println();
	}
	
	/**COMPACTAMOS EL FICHERO**/
	private static void compactarFichero() throws FileNotFoundException, IOException{
		
		LinkedList<Contacto> lista = new LinkedList<Contacto>(); int newID = 1;
		
		//NOS POSICIONAMOS AL PRINCIPIO DEL FICHERO Y RECORREMOS LINEA A LINEA DE CONTACTO HASTA EL FINAL
		ficheroAleatorio.seek(0);
		while (ficheroAleatorio.getFilePointer() != ficheroAleatorio.length()){
			
			//SI EL FICHERO NO ESTA ELIMINADO LO ANIADE A LA LISTA
			if (!ficheroAleatorio.readBoolean())
				lista.add(leerContacto());
		
			//SINO LO SALTA
			else 
				ficheroAleatorio.skipBytes(ESPACIO_CONTACTO - 1);
		}

		//CERRAMOS EL FICHERO ALEATORIO
		ficheroAleatorio.close();
		//BORRAMOS LA AGENDA
		agenda.delete();
		//CREAMOS LA AGENDA
		agenda.createNewFile();
		
		//SOBREESCRIBIMOS NUESTRO ALEATORIO Y AÑADIMOS LA LISTA DE CONTACTOS
		ficheroAleatorio = new RandomAccessFile(agenda, "rw");
		for (Contacto c: lista){
			c.setID(newID);
			agregarContactoAgenda(c);
			newID++;
		}
		
		System.out.println("Fichero compactado.\n");
	}
	
	
}