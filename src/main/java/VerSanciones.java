import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 14/06/2017.
 */
public class VerSanciones {
    private JTable verSancionesTable;
    private JButton atrasButton;
    private JPanel verSanctionPanel;

    public VerSanciones() {
        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(), "añadirSancionPanel");
                Main.configSimple(Main.frame, "Añadir sancion");
            }
        });
    }

    public JPanel getVerSanctionPanel() {
        return verSanctionPanel;
    }

    public void makeVerSancion() {
        ModelTableSancion modelTableSancion = new ModelTableSancion(new DataBase().getSanciones());
        verSancionesTable.setModel(modelTableSancion);
    }
}
