package Teclado;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

	static Scanner teclado = new Scanner(System.in);
	
	/**LECTURA DE UN CARACTER CUALQUIERA**/
	public static char caracter(String mensaje) {
		
		/**VARIABLES**/
		String cadena;
		
		do {
			/**PEDIMOS CARACTER**/
			System.out.println(mensaje);
			cadena = teclado.nextLine();

			//SI NO HA METIDO UN SOLO CARACTER SE INFORMA Y SE VUELVE A PEDIR
			if (cadena.length() != 1)
				System.out.println("!ERROR! No ha introducido un solo caracter");
			
		} while (cadena.length() != 1);
		return cadena.charAt(0); //DEVOLVEMOS EL CARACTER EXTRAYENDOLO DE LA CADENA
	}
	
	/**LECTURA DE UNA CADENA CUALQUIERA**/
	public static String cadena(String mensaje){
		
		/**VARIABLES**/
		String cadena;
		
		/**PEDIMOS CADENA**/
		System.out.println(mensaje);
	    cadena = teclado.nextLine();
	    
	    return cadena; //DEVOLVEMOS LA CADENA
	}
	    
	/**LECTURA DE UN BOOLEAN. SE LE PASARA COMO PARAMETRO EL MENSAJE DE PETICION AL USUARIO, 
	 * UNA CADENA PARA EL TUR Y UNA CADENA PARA EL FALSE**/
	public static boolean booleano (String mensaje, String trueBoolean, String falseBoolean) {
        boolean error = false, bool = false;
        byte num;


        do {
            System.out.println(mensaje);
            num = Teclado.numeroByte("1." + trueBoolean + " 2." + falseBoolean);
            if (num == 1) {
                bool = true;
                error = false;
            }
            else if (num == 2) {
                bool = false;
                error = false;
            }
            else
                error = true;
        } while (error);
        return bool;
    }
			
	/**LECTURA DE UN NUMERO CUALQUIERA**/
	//BYTE
	public static byte  numeroByte (String mensaje){
		
		/**VARIABLES**/
		byte numero=0;
		boolean bucle=true;

		do {

			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();
				bucle=false;
			
			//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);	
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//SHORT
	public static short  numeroShort (String mensaje){
		
		/**VARIABLES**/
		short numero=0;
		boolean bucle=true;
		
		do {

			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextShort();
				bucle=false;
			
			//CONTROLAMOS QUE INTRODUZCA UN NUMERO SHORT
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//INT
	public static int  numeroInt (String mensaje){
		
		/**VARIABLES**/
		int numero=0;
		boolean bucle=true;
		
		do {

			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextInt();
				bucle=false;
			
			//CONTROLAMOS QUE INTRODUZCA UN NUMERO INT
			}catch(InputMismatchException e){
				System.out.println("¡CARACER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//LONG
	public static long numeroLong (String mensaje){
		
		/**VARIABLES**/
		long numero=0;
		boolean bucle=true;
		
		do {

			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextLong();
				bucle=false;
			
			//CONTROLAMOS QUE INTRODUZCA UN NUMERO LONG
			}catch(InputMismatchException e){
				System.out.println("¡CARACER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//FLOAT
	public static float  numeroFloat (String mensaje){
		
		/**VARIABLES**/
		float numero=0;
		boolean bucle=true;
		
		do {

			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextShort();
				bucle=false;
			
			//CONTROLAMOS QUE INTRODUZCA UN NUMERO FLOAT
			}catch(InputMismatchException e){
				System.out.println("¡CARACER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//DOUBLE
	public static double  numeroDouble (String mensaje){
		
		/**VARIABLES**/
		double numero=0;
		boolean bucle=true;
		
		do {

			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextDouble();
				bucle=false;
			
			//CONTROLAMOS QUE INTRODUZCA UN NUMERO DOUBLE
			}catch(InputMismatchException e){
				System.out.println("¡CARACER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	/**LECTURA DE UN NUMERO QUE SE COMPARE CON UN VALOR MINIMO/MAXIMO PASADO COMO PARAMETRO.
	 *  AÑADIR UN PARAMETRO MAS PARA INDICAR**/
	//BYTE
	public static byte numeroByte(String mensaje, int maximini, Limite opcion){
		byte numero=0;
		boolean bucle=true;

		
		do {
			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();				

				switch(opcion){
				
				case MAYOR_IGUAL: //mayor igual que un valor min
					if (numero < maximini){
						System.out.println("¡ERROR! Numero debe ser mayor o igual que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MENOR_IGUAL: //menor o igual que un valor max
					if (numero > maximini){
						System.out.println("¡ERROR! Numero debe ser menor o igual que"+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MAYOR: //mayor que un valor min
					if (numero<=maximini){
						System.out.println("¡ERROR! Numero debe ser mayor que "+maximini+".");
						bucle=true;
					} else bucle=false;
					break;
				
				case MENOR: //menor que un valor min
					if (numero>=maximini){
						System.out.println("¡ERROR! Numero debe ser menor que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
				}
			
				//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//SHORT
	public static short numeroShort(String mensaje, int maximini, Limite opcion){
		short numero=0;
		boolean bucle=true;
		
		do {
			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();				

				switch(opcion){
				
				case MAYOR_IGUAL: //mayor igual que un valor min
					if (numero < maximini){
						System.out.println("¡ERROR! Numero debe ser mayor o igual que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MENOR_IGUAL: //menor o igual que un valor max
					if (numero > maximini){
						System.out.println("¡ERROR! Numero debe ser menor o igual que"+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MAYOR: //mayor que un valor min
					if (numero<=maximini){
						System.out.println("¡ERROR! Numero debe ser mayor que "+maximini+".");
						bucle=true;
					} else bucle=false;
					break;
				
				case MENOR: //menor que un valor min
					if (numero>=maximini){
						System.out.println("¡ERROR! Numero debe ser menor que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
				}
			
				//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//INT
	public static int numeroInt(String mensaje, int maximini, Limite opcion){
		int numero=0;
		boolean bucle=true;
		
		do {
			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();				

				switch(opcion){
				
				case MAYOR_IGUAL: //mayor igual que un valor min
					if (numero < maximini){
						System.out.println("¡ERROR! Numero debe ser mayor o igual que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MENOR_IGUAL: //menor o igual que un valor max
					if (numero > maximini){
						System.out.println("¡ERROR! Numero debe ser menor o igual que"+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MAYOR: //mayor que un valor min
					if (numero<=maximini){
						System.out.println("¡ERROR! Numero debe ser mayor que "+maximini+".");
						bucle=true;
					} else bucle=false;
					break;
				
				case MENOR: //menor que un valor min
					if (numero>=maximini){
						System.out.println("¡ERROR! Numero debe ser menor que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
				}
			
				//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//LONG
	public static long numeroLong (String mensaje, int maximini, Limite opcion){
		long numero=0;
		boolean bucle=true;
		
		do {
			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();				

				switch(opcion){
				
				case MAYOR_IGUAL: //mayor igual que un valor min
					if (numero < maximini){
						System.out.println("¡ERROR! Numero debe ser mayor o igual que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MENOR_IGUAL: //menor o igual que un valor max
					if (numero > maximini){
						System.out.println("¡ERROR! Numero debe ser menor o igual que"+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MAYOR: //mayor que un valor min
					if (numero<=maximini){
						System.out.println("¡ERROR! Numero debe ser mayor que "+maximini+".");
						bucle=true;
					} else bucle=false;
					break;
				
				case MENOR: //menor que un valor min
					if (numero>=maximini){
						System.out.println("¡ERROR! Numero debe ser menor que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
				}
			
				//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//FLOAT
	public static float numerofloat (String mensaje, int maximini, Limite opcion){
		float numero=0;
		boolean bucle=true;
		
		do {
			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();				

				switch(opcion){
				
				case MAYOR_IGUAL: //mayor igual que un valor min
					if (numero < maximini){
						System.out.println("¡ERROR! Numero debe ser mayor o igual que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MENOR_IGUAL: //menor o igual que un valor max
					if (numero > maximini){
						System.out.println("¡ERROR! Numero debe ser menor o igual que"+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MAYOR: //mayor que un valor min
					if (numero<=maximini){
						System.out.println("¡ERROR! Numero debe ser mayor que "+maximini+".");
						bucle=true;
					} else bucle=false;
					break;
				
				case MENOR: //menor que un valor min
					if (numero>=maximini){
						System.out.println("¡ERROR! Numero debe ser menor que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
				}
			
				//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//DOUBLE
	public static double numeroDouble (String mensaje, int maximini, Limite opcion){
		double numero=0;
		boolean bucle=true;
		
		do {
			try{
				/**PEDIMOS NUMERO**/
				System.out.println(mensaje);
				numero=teclado.nextByte();				

				switch(opcion){
				
				case MAYOR_IGUAL: //mayor igual que un valor min
					if (numero < maximini){
						System.out.println("¡ERROR! Numero debe ser mayor o igual que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MENOR_IGUAL: //menor o igual que un valor max
					if (numero > maximini){
						System.out.println("¡ERROR! Numero debe ser menor o igual que"+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
					
				case MAYOR: //mayor que un valor min
					if (numero<=maximini){
						System.out.println("¡ERROR! Numero debe ser mayor que "+maximini+".");
						bucle=true;
					} else bucle=false;
					break;
				
				case MENOR: //menor que un valor min
					if (numero>=maximini){
						System.out.println("¡ERROR! Numero debe ser menor que "+maximini+". ");
						bucle=true;
					} else bucle=false;
					break;
				}
			
				//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
			}catch(InputMismatchException e){
				System.out.println("¡CARACTER NO RECONOCIDO!");
				teclado.nextLine(); //LIMPIAMOS EL BUFFERT
				bucle=true;
			}
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	/**LECTURA DE UN NUMERO QUE DEBE ESTAR ENTRE UN VALOR MINIMO Y UN VALOR MAXIMO ADMISIBLES, 
	 * QUE SE LE PASARAN COMO PARAMETROS. EL VALOR MINIMO Y EL VALOR MAXIMO PUEDEN SER IGUALES. 
	 * AÑADIR UN PARAMETRO MAS PARA INDICAR**/
	//BYTE
	public static byte numeroByte (String mensaje, int min, int max, Rango opcion){
		
		/**VARIABLES**/
		byte numero=0;
		boolean bucle=true;
			
		//CONTROLAMOS QUE EL MIN NO SEA MAYOR O IGUAL QUE EL MAX

			do {
				try{
					if(min>max)throw new IllegalArgumentException("¡EL MINIMO DEBE SER MENOR QUE EL MAXIMO!.");
					else{
						/**PEDIMOS NUMERO**/
						System.out.println(mensaje);
						numero=teclado.nextByte();
						
						switch(opcion){
						case INCLUIDO_MIN_MAX: //min y max incluidos
							if ( !(numero>=min && numero<=max) ){
								System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos incluidos). ");
								bucle=true;
							} else bucle=false;
							break;
						case EXCLUIDO_MIN_MAX: //min y max excluidos
							if ( !(numero>min && numero<max) ){
								System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos excluidos). ");
								bucle=true;
							} else bucle=false;
							break;
						case MIN_INCLUIDO_MAX_EXCLUIDO: //min incluido y max exclido
							if ( !(numero>=min && numero<max) ){
								System.out.println("¡ERROR! El numero debe estar entre "+min+" (incluido) y "+max+" (excluido). ");
								bucle=true;
							} else bucle=false;
							break;
						case MIN_EXCLUIDO_MAX_INCLUIDO: //min excluido y max incluido
							if ( !(numero>min && numero<=max) ){
								System.out.println("¡ERROR! El numero debe estar entre "+min+" (excluido)  y "+max+" (incluido). ");
								bucle=true;
							} else bucle=false;
							break;
						}
					}
						
						//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
					}catch(InputMismatchException e){
						System.out.println("CARACER NO RECONOCIDO");
						teclado.nextLine();//LIMPIAMOS EL BUFFERT
						bucle=true;
					}	
		} while (bucle);
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//SHORT
	public static short numeroShort (String mensaje, int min, int max, Rango opcion){
		
		/**VARIABLES**/
		short numero=0;
		boolean bucle=true;
			
		//CONTROLAMOS QUE EL MIN NO SEA MAYOR O IGUAL QUE EL MAX
		if (min>max) throw new IllegalArgumentException("¡EL MINIMO DEBE SER MENOR QUE EL MAXIMO!.");
		else{
			do {	
				try{
					/**PEDIMOS NUMERO**/
					System.out.println(mensaje);
					numero=teclado.nextByte();
					
					switch(opcion){
					case INCLUIDO_MIN_MAX: //min y max incluidos
						if ( !(numero>=min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos incluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case EXCLUIDO_MIN_MAX: //min y max excluidos
						if ( !(numero>min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos excluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_INCLUIDO_MAX_EXCLUIDO: //min incluido y max exclido
						if ( !(numero>=min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (incluido) y "+max+" (excluido). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_EXCLUIDO_MAX_INCLUIDO: //min excluido y max incluido
						if ( !(numero>min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (excluido)  y "+max+" (incluido). ");
							bucle=true;
						} else bucle=false;
						break;
					}
					
					//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
				}catch(InputMismatchException e){
					System.out.println("CARACER NO RECONOCIDO");
					teclado.nextLine();//LIMPIAMOS EL BUFFERT
					bucle=true;
				}
			} while (bucle);
		}
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//INT
	public static int numeroInt (String mensaje, int min, int max, Rango opcion){
		
		/**VARIABLES**/
		int numero=0;
		boolean bucle=true;
			
		//CONTROLAMOS QUE EL MIN NO SEA MAYOR O IGUAL QUE EL MAX
		if (min>max) throw new IllegalArgumentException("¡EL MINIMO DEBE SER MENOR QUE EL MAXIMO!.");
		else{
			do {
				try{
					/**PEDIMOS NUMERO**/
					System.out.println(mensaje);
					numero=teclado.nextByte();
					
					switch(opcion){
					case INCLUIDO_MIN_MAX: //min y max incluidos
						if ( !(numero>=min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos incluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case EXCLUIDO_MIN_MAX: //min y max excluidos
						if ( !(numero>min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos excluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_INCLUIDO_MAX_EXCLUIDO: //min incluido y max exclido
						if ( !(numero>=min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (incluido) y "+max+" (excluido). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_EXCLUIDO_MAX_INCLUIDO: //min excluido y max incluido
						if ( !(numero>min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (excluido)  y "+max+" (incluido). ");
							bucle=true;
						} else bucle=false;
						break;
					}
					
					//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
				}catch(InputMismatchException e){
					System.out.println("CARACER NO RECONOCIDO");
					teclado.nextLine();//LIMPIAMOS EL BUFFERT
					bucle=true;
				}
			} while (bucle);
		}
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//LONG
	public static long numeroLong (String mensaje, int min, int max, Rango opcion){
		
		/**VARIABLES**/
		long numero=0;
		boolean bucle=true;
			
		//CONTROLAMOS QUE EL MIN NO SEA MAYOR O IGUAL QUE EL MAX
		if (min>max) throw new IllegalArgumentException("¡EL MINIMO DEBE SER MENOR QUE EL MAXIMO!.");
		else{
			do {
				try{
					/**PEDIMOS NUMERO**/
					System.out.println(mensaje);
					numero=teclado.nextByte();
					
					switch(opcion){
					case INCLUIDO_MIN_MAX: //min y max incluidos
						if ( !(numero>=min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos incluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case EXCLUIDO_MIN_MAX: //min y max excluidos
						if ( !(numero>min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos excluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_INCLUIDO_MAX_EXCLUIDO: //min incluido y max exclido
						if ( !(numero>=min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (incluido) y "+max+" (excluido). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_EXCLUIDO_MAX_INCLUIDO: //min excluido y max incluido
						if ( !(numero>min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (excluido)  y "+max+" (incluido). ");
							bucle=true;
						} else bucle=false;
						break;
					}
					
					//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
				}catch(InputMismatchException e){
					System.out.println("CARACER NO RECONOCIDO");
					teclado.nextLine();//LIMPIAMOS EL BUFFERT
					bucle=true;
				}
			} while (bucle);
		}
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//FLOAT
	public static float numeroFloat (String mensaje, int min, int max, Rango opcion){
		
		/**VARIABLES**/
		float numero=0;
		boolean bucle=true;
			
		//CONTROLAMOS QUE EL MIN NO SEA MAYOR O IGUAL QUE EL MAX
		if (min>max) throw new IllegalArgumentException("¡EL MINIMO DEBE SER MENOR QUE EL MAXIMO!.");
		else{
			do {
				
				try{
					/**PEDIMOS NUMERO**/
					System.out.println(mensaje);
					numero=teclado.nextByte();
					
					switch(opcion){
					case INCLUIDO_MIN_MAX: //min y max incluidos
						if ( !(numero>=min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos incluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case EXCLUIDO_MIN_MAX: //min y max excluidos
						if ( !(numero>min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos excluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_INCLUIDO_MAX_EXCLUIDO: //min incluido y max exclido
						if ( !(numero>=min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (incluido) y "+max+" (excluido). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_EXCLUIDO_MAX_INCLUIDO: //min excluido y max incluido
						if ( !(numero>min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (excluido)  y "+max+" (incluido). ");
							bucle=true;
						} else bucle=false;
						break;
					}
					
					//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
				}catch(InputMismatchException e){
					System.out.println("CARACER NO RECONOCIDO");
					teclado.nextLine();//LIMPIAMOS EL BUFFERT
					bucle=true;
				}
			} while (bucle);
		}
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	//DOUBLE
	public static double numeroDouble (String mensaje, int min, int max, Rango opcion){
		
		/**VARIABLES**/
		double numero=0;
		boolean bucle=true;
			
		//CONTROLAMOS QUE EL MIN NO SEA MAYOR O IGUAL QUE EL MAX
		if (min>max) throw new IllegalArgumentException("¡EL MINIMO DEBE SER MENOR QUE EL MAXIMO!.");
		else{
			do {
				try{
					/**PEDIMOS NUMERO**/
					System.out.println(mensaje);
					numero=teclado.nextByte();
					
					switch(opcion){
					case INCLUIDO_MIN_MAX: //min y max incluidos
						if ( !(numero>=min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos incluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case EXCLUIDO_MIN_MAX: //min y max excluidos
						if ( !(numero>min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" y "+max+" (Ambos excluidos). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_INCLUIDO_MAX_EXCLUIDO: //min incluido y max exclido
						if ( !(numero>=min && numero<max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (incluido) y "+max+" (excluido). ");
							bucle=true;
						} else bucle=false;
						break;
					case MIN_EXCLUIDO_MAX_INCLUIDO: //min excluido y max incluido
						if ( !(numero>min && numero<=max) ){
							System.out.println("¡ERROR! El numero debe estar entre "+min+" (excluido)  y "+max+" (incluido). ");
							bucle=true;
						} else bucle=false;
						break;
					}
					
					//CONTROLAMOS QUE INTRODUZCA UN NUMERO BYTE
				}catch(InputMismatchException e){
					System.out.println("CARACER NO RECONOCIDO");
					teclado.nextLine();//LIMPIAMOS EL BUFFERT
					bucle=true;
				}
			} while (bucle);
		}
		teclado.nextLine(); //LIMPIAMOS EL BUFFERT
		return numero; //DEVOLVEMOS EL NUMERO
	}
	
	public static void cerrar(){
		teclado.close();
	}
	
}