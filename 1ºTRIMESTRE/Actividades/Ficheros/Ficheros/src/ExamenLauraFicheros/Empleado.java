package ExamenLauraFicheros;

import java.io.Serializable;

public class Empleado implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public String nombre, codigo;
	public int edad;
	public float salario;
	
	public Empleado (String codEmp, String nomEmp, int edad, float salario){
		codigo = codEmp;
		nombre = nomEmp;
		this.edad = edad;
		this.salario = salario;
	}
	
	public Empleado(){}
	
	public String toString(){
		return String.format("Codigo: %s | Nombre: %s | Edad: %d | Salario: %f",
				codigo, nombre, edad, salario);
	}
	 
}