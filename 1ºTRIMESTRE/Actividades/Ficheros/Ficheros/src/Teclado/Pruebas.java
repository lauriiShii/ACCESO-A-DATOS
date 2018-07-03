package Teclado;


public class Pruebas {

	public static void main(String[] args) {
		
		
		//declaramos variable
		char caracter;
		boolean booleano=false;
		String cadena;
		byte numero;

		
		/**PRUEBA NUMERO BYTE**/
		
		//numero entre un valor min y un valor max admisibles
		numero = Teclado.numeroByte("El numero debe estar entre 10 y 20 incluidos",30,20,Rango.INCLUIDO_MIN_MAX);
		System.out.println("El numero es: "+numero);
		
		numero = Teclado.numeroByte("El numero debe estar entre 10 y 20 excluidos",10,20,Rango.EXCLUIDO_MIN_MAX);
		System.out.println("El numero es: "+numero);
		
		numero = Teclado.numeroByte("El numero debe estar entre 10 (incluido) y 20 (excluido). ",10,20,Rango.MIN_INCLUIDO_MAX_EXCLUIDO);
		System.out.println("El numero es: "+numero);
		
		numero = Teclado.numeroByte("El numero debe estar entre 10 (excluido) y 20 (incluido). ",10,20,Rango.MIN_EXCLUIDO_MAX_INCLUIDO);
		System.out.println("El numero es: "+numero);

		
		
		//numero byte menor o mayor a otro.
		numero = Teclado.numeroByte("Introduce un numero byte mayor o igual que 22",22,Limite.MAYOR_IGUAL);
		System.out.println("El numero es: "+numero);
		
		numero = Teclado.numeroByte("Introduce un numero byte menor o igual que que 22",22,Limite.MENOR_IGUAL);
		System.out.println("El numero es: "+numero);
		
		numero = Teclado.numeroByte("Introduce un numero byte mayor que 22",22,Limite.MAYOR);
		System.out.println("El numero es: "+numero);
		
		numero = Teclado.numeroByte("Introduce un numero byte menor que 22",22,Limite.MENOR);
		System.out.println("El numero es: "+numero);

		//numero cualquiera
		numero = Teclado.numeroByte("Introduce un numero byte (-128 a 127): ");
		System.out.println("El numero es: "+numero);

		/**PRUEBA CARACTER**/
		
		//llamamos a la funcion caracter
		caracter = Teclado.caracter("Introduce un caracter: ");
		//mostramos resultado
		System.out.println("El caracter introducido es: "+caracter);
		
		
		/**PRUEBA CON CADENA**/
		
		cadena = Teclado.cadena("Introduce una cadena: ");
		System.out.println("la cadena introducida es: "+cadena);
		
		
		/**PRUEBA CON BOOLEANO**/
		
		booleano = Teclado.booleano("Introduce pepe o maria: ","pepe", "maria");
		System.out.println("Has introducido: "+ booleano);
		
		Teclado.cerrar();
	}

}
