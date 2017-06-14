import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTablePrestamo extends AbstractTableModel{
    private List<Prestamo> listPrestamo;

    public ModelTablePrestamo(List<Prestamo> estanterias) {
        this.listPrestamo = estanterias;
    }

    @Override
    public int getRowCount() {
        return listPrestamo.size();
    }

    public Prestamo getPrestamoAt(int row) {
        return listPrestamo.get(row);
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Socio";
            case 1:
                return "Sancion";
            case 2:
                return "Bibliotecario";
            case 3:
                return "Libro";
            case 4:
                return "Fecha Inicio";
            case 5:
                return "Fecha final";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prestamo prestamo = listPrestamo.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return prestamo.socio;
            case 1:
                return prestamo.sancion;
            case 2:
                return prestamo.bibliotecario;
            case 3:
                return prestamo.libro;
            case 4:
                return prestamo.fechaInicio;
            case 5:
                return prestamo.fechaFinal;
        }
        throw new RuntimeException("Impossible");
    }
}
