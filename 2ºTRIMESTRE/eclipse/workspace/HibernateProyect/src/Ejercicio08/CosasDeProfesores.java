package Ejercicio08;

/**
 * Created by Alejandro on 19/01/2017.
 */
public class CosasDeProfesores {
    private String codProf;
    private String nombreProf;
    private long numAsignaturas;
    private long horasSemanales;
    private long numCursos;

    public CosasDeProfesores(String codProf, String nombreProf, long numAsignaturas, long horasSemanales, long numCursos) {
        this.codProf = codProf;
        this.nombreProf = nombreProf;
        this.numAsignaturas = numAsignaturas;
        this.horasSemanales = horasSemanales;
        this.numCursos = numCursos;
    }

    @Override
    public String toString() {
        return String.format("[CodProf: %s] [Nombre: %s] [Asignaturas: %d] [Horas semanales: %d] [Cursos: %d]", codProf, nombreProf, numAsignaturas, horasSemanales, numCursos);
    }
}
