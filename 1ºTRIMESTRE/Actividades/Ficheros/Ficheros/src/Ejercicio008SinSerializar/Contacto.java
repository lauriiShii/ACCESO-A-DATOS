package Ejercicio008SinSerializar;

public class Contacto{

	public String direccion, telefono, nombreCont;
	public int codP; public boolean deboMoney; public float cantDeb;
	
	public Contacto(String nomCont, String tel, String dir, int codP, boolean deboMoney, float cantDeb){
		nombreCont = nomCont;
		telefono = tel;
		direccion = dir;
		this.codP = codP;
		this.deboMoney = deboMoney;
		this.cantDeb = cantDeb;
	}
	 
}