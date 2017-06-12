import java.sql.Date;

/**
 * Created by Kekko on 11/06/2017.
 */
class Libro {
    int isbn;
    String titulo;
    int numPaginas;
    String portada;
    String editorial;
    int autores;
    String tematica;
    Date fechaBaja;

    Libro(int isbn, String titulo, int numPaginas, String portada, String editorial, int autores, String tematica, Date fechaBaja) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.numPaginas = numPaginas;
        this.portada = portada;
        this.editorial = editorial;
        this.autores = autores;
        this.tematica = tematica;
        this.fechaBaja = fechaBaja;
    }
}