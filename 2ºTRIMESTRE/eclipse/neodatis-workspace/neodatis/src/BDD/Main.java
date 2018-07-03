package BDD;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

import ObjetosBDD.*;

public class Main {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("VENTAS.dat");

		Articulo articulo []= {
				new Articulo(1, "new 3DS XL", 25, 190.25f),
				new Articulo(2, "new 3DS", 20, 160.25f),
				new Articulo(3, "PS4", 5, 500.95f),
				new Articulo(4, "XBox one", 2, 220.25f),
				new Articulo(5, "XBox 360", 25, 199.25f)
				};
		Cliente cliente []= {
				new Cliente(1, "Soledad Trujillo", "Madrid"),
				new Cliente(2, "Antonio Carlos Ordoñes", "Paris"),
				new Cliente(3, "Julio Marquez Rodriguez", "Barcelona"),
				new Cliente(4, "Laura Calvente Dominguez", "Valencia"),
				new Cliente(5, "Tamzin Otero Merrikin", ""),
				};
		Venta venta [] = {
				new Venta(1, cliente[1], articulo[0], 5),
				new Venta(1, cliente[0], articulo[3], 1),
				new Venta(1, cliente[0], articulo[3], 2),
				new Venta(1, cliente[3], articulo[1], 1)
				};

		// Almacenamos objetos
		for (int i = 0; i < articulo.length; i++)
			odb.store(articulo[i]);
		for (int i = 0; i < cliente.length; i++)
			odb.store(cliente[i]);
		for (int i = 0; i < venta.length; i++)
			odb.store(venta[i]);

		// Recuperamos todos los datos
		Objects<Articulo> articulos = odb.getObjects(Articulo.class);
		Objects<Cliente> clientes = odb.getObjects(Cliente.class);
		Objects<Venta> ventas = odb.getObjects(Venta.class);
		
		System.out.printf("Articulos: %s\nClientes: %s\nVentas: %s\n", articulos.size() ,clientes.size(), ventas.size());
		
		// Visualizar los objetos
		while (articulos.hasNext())
			System.out.println(articulos.next().toString());
		
		while (clientes.hasNext())
			System.out.println(clientes.next().toString());
		
		while (ventas.hasNext())
			System.out.println(ventas.next().toString());
		
		odb.close();
		
		

	}

}