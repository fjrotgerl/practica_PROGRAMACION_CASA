import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTableAutor extends AbstractTableModel{
    private List<Autor> listAutor;

    public ModelTableAutor(List<Autor> autores) {
        this.listAutor = autores;
    }

    @Override
    public int getRowCount() {
        return listAutor.size();
    }

    public Autor getAutorAt(int row) {
        return listAutor.get(row);
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Alias";
            case 1:
                return "Nombre";
            case 2:
                return "Apellidos";
            case 3:
                return "Fecha de nacimiento";
            case 4:
                return "Nacionalidad";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Autor autor = listAutor.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return autor.alias;
            case 1:
                return autor.nombre;
            case 2:
                return autor.apellidos;
            case 3:
                return autor.fechaNacimiento;
            case 4:
                return autor.nacionalidad;
        }
        throw new RuntimeException("Impossible");
    }
}
