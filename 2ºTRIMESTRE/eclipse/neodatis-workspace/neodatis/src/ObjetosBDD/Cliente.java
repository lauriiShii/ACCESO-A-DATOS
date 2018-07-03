package ObjetosBDD;

public class Cliente {
	private int codCliente;
	private String nombre;
	private String poblacion;

	public Cliente(int codCliente, String nombre, String poblacion) {
		super();
		this.codCliente = codCliente;
		this.nombre = nombre;
		this.poblacion = poblacion;
	}

	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	@Override
	public String toString() {
		return "Cliente [codCliente=" + codCliente + ", nombre=" + nombre + ", poblacion=" + poblacion + "]";
	}

}
