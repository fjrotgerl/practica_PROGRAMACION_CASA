import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 14/06/2017.
 */
public class ModificarPrestamosForm {
    private JTable sancionPrestamoTable;
    private JButton prórrogaButton;
    private JButton cancelarButton;
    private JButton sancionarButton;
    private JPanel sancionPanel;

    public ModificarPrestamosForm() {
        sancionarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (sancionPrestamoTable.isCellSelected(sancionPrestamoTable.getSelectedRow(),sancionPrestamoTable.getSelectedColumn())) {
                    CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                    cl.show(Main.frame.getContentPane(), "añadirSancionPanel");
                    Main.configSimple(Main.frame, "Añadir sancion");
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún préstamo");
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"inicioPanel");
                Main.configSimple(Main.frame,"Inicio");
            }
        });

    }

    public JPanel getSancionPanel() {
        return sancionPanel;
    }

    public JTable getSancionPrestamoTable() {
        return sancionPrestamoTable;
    }

    public void makePrestamoInPrestamoMod() {
        ModelTablePrestamo modelTablePrestamo = new ModelTablePrestamo(new DataBase().getPrestamos());
        sancionPrestamoTable.setModel(modelTablePrestamo);
    }

}
