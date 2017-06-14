import javax.swing.*;

/**
 * Created by Kekko on 14/06/2017.
 */
public class ModificarPrestamosForm {
    private JTable sancionPrestamoTable;
    private JButton prórrogaButton;
    private JButton cancelarButton;
    private JButton sancionarButton;
    private JPanel sancionPanel;

    public JPanel getSancionPanel() {
        return sancionPanel;
    }

    public void makePrestamoInPrestamoMod() {
        ModelTablePrestamo modelTablePrestamo = new ModelTablePrestamo(new DataBase().getPrestamos());
        sancionPrestamoTable.setModel(modelTablePrestamo);
    }

}
