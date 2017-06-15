import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 14/06/2017.
 */
public class BuscarLibroForm {
    private JComboBox buscarLibroCBox;
    private JTextField buscarLibroInfo;
    private JTable mostrarLibrosBusqueda;
    private JButton buscarButton;
    private JPanel buscarLibroPanel;
    private JButton atrasButton;

    public BuscarLibroForm() {
        fillComboBox();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeLibroTableSpecific(getBusquedaLibro(buscarLibroCBox.getSelectedIndex()),buscarLibroInfo.getText());
            }
        });

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(), "inicioPanel");
                Main.configSimple(Main.frame, "Inicio");
            }
        });
    }

    public JPanel getBuscarLibroPanel() {
        return buscarLibroPanel;
    }

    private String getBusquedaLibro(int seleccionado) {
        switch (seleccionado) {
            case 0:
                return "*";
            case 1:
                return "FK_TEMATICA";
            case 2:
                return "TITULO";
            case 3:
                return "ISBN";
            case 4:
                return "EDITORIAL";
            default:
                return "";
        }
    }

    private void fillComboBox() {
        this.buscarLibroCBox.addItem("Todos");
        this.buscarLibroCBox.addItem("Tematica");
        this.buscarLibroCBox.addItem("Titulo");
        this.buscarLibroCBox.addItem("ISBN");
        this.buscarLibroCBox.addItem("Editorial");
    }

    public void makeLibroTableSpecific(String busqueda, String value) {
        ModelTableLibro modelTableLibro = new ModelTableLibro(new DataBase().getLibrosEspecificos(busqueda,value));
        mostrarLibrosBusqueda.setModel(modelTableLibro);
    }
}
