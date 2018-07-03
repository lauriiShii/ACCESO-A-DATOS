package ExamenLauraFicheros;

import java.io.*;
import com.thoughtworks.xstream.XStream;

public class Ejercicio01 {

    public static void main(String[] args) throws IOException {

        ListaEmpleado lista = new ListaEmpleado();
        XStream xstream = new XStream();

        Empleado e1 = new Empleado ("RJ1", "Rafael Jimenez Perez", 40, 1789.45f);
        Empleado e2 = new Empleado ("PM2", "Paco Marquez Romero", 38, 1900.34f);
        Empleado e3 = new Empleado ("AG3", "Ana Gonzalez Martin", 45, 1467.23f);
        Empleado e4 = new Empleado ("TV4", "Tomas Vera Gutierrez", 39, 1780.36f);

        lista.agregarEmpleado(e1);
        lista.agregarEmpleado(e2);
        lista.agregarEmpleado(e3);
        lista.agregarEmpleado(e4);

        xstream.alias("Empleados", ListaEmpleado.class);
        xstream.alias("Empleado", Empleado.class);
        xstream.addImplicitCollection(ListaEmpleado.class, "lista");
        xstream.toXML(lista, new FileOutputStream("Empleados.xml"));

    }

}