import com.mysql.fabric.xmlrpc.base.Data;

import java.sql.Date;

/**
 * Created by Kekko on 11/06/2017.
 */
class Prestamo {
    String socio;
    String bibliotecario;
    String libro;
    Date fechaInicio;
    Date fechaFinal;


    Prestamo(String socio, String bibliotecario, String libro, Date fechaInicio, Date fechaFinal) {
        this.socio = socio;
        this.bibliotecario = bibliotecario;
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
    }
}