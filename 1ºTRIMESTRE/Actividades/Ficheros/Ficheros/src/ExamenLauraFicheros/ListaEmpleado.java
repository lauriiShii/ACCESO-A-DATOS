package ExamenLauraFicheros;

import java.util.LinkedList;

public class ListaEmpleado {
	
	private LinkedList<Empleado> lista = new LinkedList<Empleado>();
	
	public void agregarEmpleado(Empleado e){
		lista.add(e);
	}
	public LinkedList<Empleado> getLista(){
		return lista;
	}
}