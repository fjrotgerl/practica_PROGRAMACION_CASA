import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Created by Kekko on 11/06/2017.
 */
public class ModelTableTematica extends AbstractTableModel{
    private List<Tematica> listTematica;

    public ModelTableTematica(List<Tematica> tematicas) {
        this.listTematica = tematicas;
    }

    @Override
    public int getRowCount() {
        return listTematica.size();
    }

    public Tematica getTematicaAt(int row) {
        return listTematica.get(row);
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public String getColumnName(int column) {
        switch(column) {
            case 0:
                return "Tematica";
        }
        throw new RuntimeException("Impossible");
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tematica tematica = listTematica.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tematica.tematica;
        }
        throw new RuntimeException("Impossible");
    }
}
