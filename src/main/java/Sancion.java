import java.sql.Date;

/**
 * Created by Kekko on 11/06/2017.
 */
class Sancion {
    String tipo;
    String descripcion;
    Date fechaInicio;
    Date fechaFinal;

    Sancion(String tipo, String descripcion, Date fechaInicio, Date fechaFinal) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
}