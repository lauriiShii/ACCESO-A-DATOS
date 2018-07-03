package ObjetosBDD;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Venta {
	private int codVenta;
	private Cliente cliente;
	private Articulo articulo;
	private int unidades;
	private Date fecha;
	private static SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy, HH:mm");

	public Venta(int codVenta, Cliente cliente, Articulo articulo, int unidades) {
		super();
		this.codVenta = codVenta;
		this.cliente = cliente;
		this.articulo = articulo;
		this.unidades = unidades;
		this.fecha = new Date();
	}

	public int getCodVenta() {
		return codVenta;
	}

	public void setCodVenta(int codVenta) {
		this.codVenta = codVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	 public String dameFecha(){
		  return formato.format(fecha);
		 }

	@Override
	public String toString() {
		return "Venta [codVenta=" + codVenta + ", cliente=" + cliente + ", articulo=" + articulo + ", unidades="
				+ unidades + ", fecha=" + formato.format(fecha) + "]";
	}

}