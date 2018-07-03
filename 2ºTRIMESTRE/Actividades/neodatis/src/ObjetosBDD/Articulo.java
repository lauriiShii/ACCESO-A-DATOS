package ObjetosBDD;

public class Articulo {
	private int codArticulo;
	private String descripcion;
	private int stock;
	private float precio;

	public Articulo(int codArticulo, String descripcion, int stock, float precio) {
		super();
		this.codArticulo = codArticulo;
		this.descripcion = descripcion;
		this.stock = stock;
		this.precio = precio;
	}

	public int getCodArticulo() {
		return codArticulo;
	}

	public void setCodArticulo(int codArticulo) {
		this.codArticulo = codArticulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Articulo [codArticulo=" + codArticulo + ", descripcion=" + descripcion + ", stock=" + stock
				+ ", precio=" + precio + "]";
	}

}
