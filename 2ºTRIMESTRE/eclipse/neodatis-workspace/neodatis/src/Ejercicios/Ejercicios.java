package Ejercicios;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import ObjetosBDD.*;

public class Ejercicios {

	public static void ejercicioUno() {

		ODB odb = ODBFactory.open("VENTAS.dat");

		Objects<Venta> ventas = odb.getObjects(Venta.class);

		System.out.printf("%s%15s%15s%13s%18s%35s%24s%11s\n", "CODVENTA", "CODARTIC", "DESCRIP", "NUMCLI", "NOMBRE",
				"FECHA", "UNIDSDES", "IMPORTE");
		Venta venta;

		while (ventas.hasNext()) {
			venta = ventas.next();
			System.out.printf("%4s%15s%20s%10s%30s%30s%15s%15s\n", venta.getCodVenta(),
					venta.getArticulo().getCodArticulo(), venta.getArticulo().getDescripcion(),
					venta.getCliente().getCodCliente(), venta.getCliente().getNombre(), venta.dameFecha(),
					venta.getUnidades(), venta.getArticulo().getPrecio() * venta.getUnidades());
		}

		odb.close();
	}

	public static void ejercicioDos() {
		ODB odb = ODBFactory.open("VENTAS.dat");

		Objects<Articulo> articulos = odb.getObjects(Articulo.class);
		Objects<Venta> ventas = odb.getObjects(Venta.class);
		Articulo articulo;
		Venta venta;
		int sumaVend = 0, sumaVent = 0;
		float sumaImp = 0;
		
		System.out.printf("%15s%30s%15s%15s%15s%15s%15s\n", "CODARTIC", "DESCRIP", "STOCK", "PRECIO", "SUMA VEND",
				"SUMA IMP", "SUMA VENT");

		while (articulos.hasNext()) {
			articulo = articulos.next();

			while (ventas.hasNext()) {
				venta = ventas.next();

				if (venta.getArticulo().getCodArticulo() == articulo.getCodArticulo()) {
					sumaVend += venta.getUnidades();
					sumaVent++;
					sumaImp += venta.getUnidades() * articulo.getPrecio();
				}

			}

			System.out.printf("%15s%30s%15s%15s%15d%15d%15f\n", articulo.getCodArticulo(), articulo.getDescripcion(),
					articulo.getStock(), articulo.getPrecio(), sumaVend, sumaVent, sumaImp);

			sumaVend = 0;
			sumaVent = 0;
			sumaImp = 0;
			ventas = odb.getObjects(Venta.class);
		}

		odb.close();
	}

	public static void ejercicioTres() {
		ODB odb = ODBFactory.open("VENTAS.dat");

		Objects<Cliente> clientes = odb.getObjects(Cliente.class);
		Objects<Venta> ventas = odb.getObjects(Venta.class);

		System.out.printf("%15s%30s%15s%15s%15s\n", "NUMCLIENTE", "NOMBRE", "POBLACION", "TOTAL IMPORTE",
				"TOTAL VENTAS");

		Cliente cliente;
		Venta venta;
		int totalImporte = 0, numVentas = 0;

		while (clientes.hasNext()) {
			cliente = clientes.next();

			while (ventas.hasNext()) {
				venta = ventas.next();

				if (venta.getCliente().getCodCliente() == cliente.getCodCliente()) {
					totalImporte += venta.getUnidades() * venta.getArticulo().getPrecio();
					numVentas++;
				}
			}

			System.out.printf("%15s%30s%15s%15s%15s\n", cliente.getCodCliente(), cliente.getNombre(),
					cliente.getPoblacion(), totalImporte, numVentas);

			totalImporte = 0;
			numVentas = 0;
			ventas = odb.getObjects(Venta.class);
		}

		odb.close();
	}

	public static void ejercicioCuatro() {
		dameArtMasVendido();
		dameMedias();
		clienteMasGastado();
		clienteConMasVentas();
	}
	
	public static void clienteMasGastado(){
		ODB odb = ODBFactory.open("VENTAS.dat");

		Objects<Venta> ventas = odb.getObjects(Venta.class);
		Objects<Cliente> clientes = odb.getObjects(Cliente.class);
		int numVentas, maxVentas = 0, numImporte, sumImporte, maxImporte = 0;
		Cliente cliente, clienteMasHaGastado = new Cliente(-1, "", null);
		Venta venta;
		
		while (clientes.hasNext()) {
			numVentas = 0;
			sumImporte = 0;

			cliente = clientes.next();
			ventas = odb.getObjects(Venta.class);

			while (ventas.hasNext()) {

				venta = ventas.next();

				if (venta.getCliente().getCodCliente() == cliente.getCodCliente()) {
					sumImporte += venta.getUnidades() * venta.getArticulo().getPrecio();
					numVentas++;
				}
			}

			if (sumImporte >= maxImporte) {
				maxImporte = sumImporte;
				clienteMasHaGastado = cliente;
			}

		}
		System.out.println("Nombre del cliente que mas ha gastado: " + clienteMasHaGastado.getNombre());

		odb.close();
	}
	
	public static void clienteConMasVentas(){
		ODB odb = ODBFactory.open("VENTAS.dat");

		Objects<Venta> ventas = odb.getObjects(Venta.class);
		Objects<Cliente> clientes = odb.getObjects(Cliente.class);
		Venta venta;
		int numVentas, maxVentas = 0, sumImporte, numImporte;
		Cliente cliente,  clienteMasVentas = new Cliente(-1, "", null);

		while (clientes.hasNext()) {

			numVentas = 0;
			sumImporte = 0;

			cliente = clientes.next();
			ventas = odb.getObjects(Venta.class);

			while (ventas.hasNext()) {

				venta = ventas.next();

				if (venta.getCliente().getCodCliente() == cliente.getCodCliente()) {
					sumImporte += venta.getUnidades() * venta.getArticulo().getPrecio();
					numVentas++;
				}
			}

			if (numVentas >= maxVentas) {
				maxVentas = numVentas;
				clienteMasVentas = cliente;
			}

		}
		
		System.out.println("Nombre del cliente con mas ventas: " + clienteMasVentas.getNombre());

		odb.close();
	}
	
	public static void dameMedias(){
		ODB odb = ODBFactory.open("VENTAS.dat");
		
		Objects<Venta> ventas = odb.getObjects(Venta.class);
		Objects<Articulo> articulos = odb.getObjects(Articulo.class);
		Venta venta;
		Articulo articulo;
		int  sumImporte, numImporte;

		while (articulos.hasNext()) {

			numImporte = 0;
			sumImporte = 0;

			articulo = articulos.next();
			ventas = odb.getObjects(Venta.class);

			while (ventas.hasNext()) {
				venta = ventas.next();

				if (venta.getArticulo().getCodArticulo() == articulo.getCodArticulo()) {
					numImporte++;
					sumImporte += venta.getUnidades() * venta.getArticulo().getPrecio();
				}
			}
			
			System.out.println("Media de importe de ventas de " + articulo.getDescripcion() + ": "
					+ (sumImporte == 0 || numImporte == 0 ? 0 : (sumImporte / numImporte) + "�"));

		}
		odb.close();
	}
	
	public static void dameArtMasVendido(){
		ODB odb = ODBFactory.open("VENTAS.dat");

		Objects<Articulo> articulos = odb.getObjects(Articulo.class);
		Articulo articulo, articuloMasVendido = null;
		int numVentas, maxVentas = 0;

		while (articulos.hasNext()) {
			numVentas = 0;
			articulo = articulos.next();

			if (numVentas >= maxVentas) {
				maxVentas = numVentas;
				articuloMasVendido = articulo;
			}
		}
		
		System.out.println("Nombre del articulo mas vendido: " + articuloMasVendido.getDescripcion());
		
		odb.close();
	}

}