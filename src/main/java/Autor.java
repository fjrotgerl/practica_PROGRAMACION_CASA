import java.sql.Date;

/**
 * Created by Kekko on 11/06/2017.
 */
class Autor {
    int idAutor;
    String alias;
    String nombre;
    String apellidos;
    Date fechaNacimiento;
    String nacionalidad;

    Autor(int idAutor, String alias, String nombre, String apellidos, Date fechaNacimiento, String nacionalidad) {
        this.idAutor = idAutor;
        this.alias = alias;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }
}