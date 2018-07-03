package Ejercicio11;

import datos.Curso;
import datos.Ofertaeducativa;
import datos.Profesor;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Alejandro on 21/01/2017.
 */
public class CursoCompleto {

    private String codOe;
    private String nombre;
    private String descripcion;
    private String tipo;
    private Date fechaLey;

    private String codCurso;
    private Profesor tutor;

    public CursoCompleto(Ofertaeducativa ofertaeducativa, Curso curso) {
        codOe = ofertaeducativa.getCodOe();
        nombre = ofertaeducativa.getNombre();
        descripcion = ofertaeducativa.getDescripcion();
        tipo = ofertaeducativa.getTipo();
        fechaLey = ofertaeducativa.getFechaLey();

        if (curso != null) {
            codCurso = curso.getId().getCodCurso();
            tutor = curso.getProfesor();
        }
    }

    public CursoCompleto(String codOe, String nombre, String descripcion, String tipo, Date fechaLey, String codCurso, Profesor tutor) {
        this.codOe = codOe;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaLey = fechaLey;
        this.codCurso = codCurso;
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
        String resultado = String.format("[Oferta educativa: %s] [Nombre: %s] [Descripción: %s] [Tipo: %s] [Fecha de la ley: %s] ", codOe, nombre, descripcion, tipo, formato.format(fechaLey));

        if (codCurso != null)
            resultado += String.format("[Curso: %s] [Tutor: %s]", codCurso, tutor.getCodProf());
        else
            resultado += "[Esta oferta educativa no tiene cursos]";

        return resultado;
    }
}
