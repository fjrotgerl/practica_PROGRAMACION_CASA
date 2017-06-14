import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTableSancion extends AbstractTableModel{
    private List<Sancion> listSancion;

    public ModelTableSancion(List<Sancion> sanciones) {
        this.listSancion = sanciones;
    }

    @Override
    public int getRowCount() {
        return listSancion.size();
    }

    public Sancion getSancionAt(int row) {
        return listSancion.get(row);
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Tipo";
            case 1:
                return "Descripcion";
            case 2:
                return "Fecha inicio";
            case 3:
                return "Fecha final";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sancion sancion = listSancion.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return sancion.tipo;
            case 1:
                return sancion.descripcion;
            case 2:
                return sancion.fechaInicio;
            case 3:
                return sancion.fechaFinal;
        }
        throw new RuntimeException("Impossible");
    }
}
