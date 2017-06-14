import com.mysql.fabric.xmlrpc.base.Data;

import javax.swing.*;
import javax.xml.soap.SAAJMetaFactory;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 14/06/2017.
 */
public class AñadirSancionForm {
    private JComboBox sancionTipo;
    private JTextArea sancionDescripcion;
    private JButton guardarButton;
    private JPanel sancionPanel;
    private JButton cancelButton;

    public AñadirSancionForm() {
        fillComboBox();

        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.db.añadirSancion((String) sancionTipo.getSelectedItem(),sancionDescripcion.getText());
                    Main.db.añadirSancionAPrestamo((String) Main.modificarPrestamosForm.getSancionPrestamoTable().getValueAt
                            (Main.modificarPrestamosForm.getSancionPrestamoTable().getSelectedRow(), 2));
                    JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir al socio");
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
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

    private void fillComboBox() {
        sancionTipo.addItem("LEVE");
        sancionTipo.addItem("GRAVE");
        sancionTipo.addItem("SUSPENSION");
    }
}
