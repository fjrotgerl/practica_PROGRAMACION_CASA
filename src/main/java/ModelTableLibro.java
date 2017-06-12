import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTableLibro extends AbstractTableModel{
    private List<Libro> listLibro;

    public ModelTableLibro(List<Libro> libros) {
        this.listLibro = libros;
    }

    @Override
    public int getRowCount() {
        return listLibro.size();
    }

    public Libro getLibroAt(int row) {
        return listLibro.get(row);
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "ISBN";
            case 1:
                return "Titulo";
            case 2:
                return "Núm. de páginas";
            case 3:
                return "Portada";
            case 4:
                return "Editorial";
            case 5:
                return "Autores";
            case 6:
                return "Temática";
            case 7:
                return "Fecha de la baja";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Libro libro = listLibro.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return libro.isbn;
            case 1:
                return libro.titulo;
            case 2:
                return libro.numPaginas;
            case 3:
                return libro.portada;
            case 4:
                return libro.editorial;
            case 5:
                return libro.autores;
            case 6:
                return libro.tematica;
            case 7:
                return libro.fechaBaja;
        }
        throw new RuntimeException("Impossible");
    }
}
