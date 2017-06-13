import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTableEstanteria extends AbstractTableModel{
    private List<Estanteria> listEstanteria;

    public ModelTableEstanteria(List<Estanteria> estanterias) {
        this.listEstanteria = estanterias;
    }

    @Override
    public int getRowCount() {
        return listEstanteria.size();
    }

    public Estanteria getEstanteriaAt(int row) {
        return listEstanteria.get(row);
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "ID";
            case 1:
                return "Tematica";
            case 2:
                return "Ubicacion";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Estanteria estanteria = listEstanteria.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return estanteria.idEstanteria;
            case 1:
                return estanteria.tematica;
            case 2:
                return estanteria.ubicacion;
        }
        throw new RuntimeException("Impossible");
    }
}
