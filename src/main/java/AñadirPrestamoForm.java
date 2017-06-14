import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 14/06/2017.
 */
public class AñadirPrestamoForm {
    private JTable prestamoSocioTable;
    private JButton hacerPrestamoButton;
    private JPanel prestamoPanel;
    private JButton cancelButton;
    private JTable prestamoLibroTable;

    public AñadirPrestamoForm() {

        hacerPrestamoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataBase.dataBase.añadirPrestamo((String )prestamoSocioTable.getValueAt(prestamoSocioTable.getSelectedRow(),2),
                            (String) prestamoLibroTable.getValueAt(prestamoLibroTable.getSelectedRow(),1),
                            (String) prestamoSocioTable.getValueAt(prestamoSocioTable.getSelectedRow(),3),
                            (String) prestamoSocioTable.getValueAt(prestamoSocioTable.getSelectedRow(),4));
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

    public JPanel getAñadirPrestamoPanel() {
        return prestamoPanel;
    }

    public void makeSocioTableInPrestamo() {
        ModelTableSocio modelTableSocio = new ModelTableSocio(new DataBase().getSocios());
        prestamoSocioTable.setModel(modelTableSocio);
    }

    public void makeLibroTableInPrestamo() {
        ModelTableLibro modelTableLibro = new ModelTableLibro(new DataBase().getLibros());
        prestamoLibroTable.setModel(modelTableLibro);
    }
}
