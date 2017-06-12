import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Javi on 12/06/2017.
 */
public class BajarAltaLibroForm {
    private JButton libroBorrarButton;
    private JButton libroCancelarButton;
    private JButton libroActualizarButton;
    private JButton libroAltaButton;
    private JTable libroMostrarTable;
    private JPanel mirarLibroPanel;

    public BajarAltaLibroForm() {
        libroCancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"inicioPanel");
                Main.configSimple(Main.frame,"Inicio");
            }
        });

        libroActualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeLibroTable();
            }

        });

        libroBorrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.db.deleteLibro(Main.db.getLibro(libroMostrarTable));
                    JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                    ex.printStackTrace();
                }
            }
        });

        libroAltaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.db.darAltaLibro(Main.db.getLibro(libroMostrarTable));
                    JOptionPane.showMessageDialog(null, "Se ha dado de alta correctamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                    System.out.println("Fallo al dar de alta al libro");
                }
            }
        });
    }

    public JPanel getMirarLibroPanel() {
        return mirarLibroPanel;
    }

    public void makeLibroTable() {
        ModelTableLibro modelTableLibro = new ModelTableLibro(new DataBase().getLibros());
        libroMostrarTable.setModel(modelTableLibro);
    }
}
