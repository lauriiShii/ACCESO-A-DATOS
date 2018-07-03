package Ejercicio009;

import java.io.Serializable;

public class Contacto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	String direccion, telefono, nombreCont;
	int codP, id; 
	boolean deboDinero; 
	float cantDeb;
	
	public Contacto(int id, String nomCont, String tel, String dir, int codP, boolean deboDinero, float cantDeb){
		nombreCont = nomCont;
		telefono = tel;
		direccion = dir;
		this.codP = codP;
		this.deboDinero = deboDinero;
		this.cantDeb = cantDeb;
		this.id = id;
	}
	public String toString(){
		return String.format("ID: %d - Nombre: %s  Telefono: %s  Dirección: %s  CP: %d  \t¿Debo dinero?: %s %s", id, nombreCont, telefono, 
				direccion, codP, deboDinero?"Si":"No le debo dinero.",  cantDeb == 0?"":" Cantidad debida: " + String.format("%.2f",cantDeb));
	}
	public void setID(int id){
		this.id = id;
	}
}