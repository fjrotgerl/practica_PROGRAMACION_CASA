import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 14/06/2017.
 */
public class BuscarAutorForm {
    private JPanel buscarAutorPanel;
    private JComboBox buscarAutorCBox;
    private JTextField buscarAutorInfo;
    private JTable mostrarAutorBusqueda;
    private JButton buscarButton;
    private JButton atrasButton;


    public BuscarAutorForm() {
        fillComboBox();

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                makeAutorTableSpecific(getBusquedaAutor(buscarAutorCBox.getSelectedIndex()),buscarAutorInfo.getText());
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

    public JPanel getBuscarAutorPanel() {
        return buscarAutorPanel;
    }

    private String getBusquedaAutor(int seleccionado) {
        switch (seleccionado) {
            case 0:
                return "*";
            case 1:
                return "ALIAS";
            case 2:
                return "NOMBRE";
            case 3:
                return "APELLIDOS";
            case 4:
                return "FECHA_NACIMIENTO";
            case 5:
                return "NACIONALIDAD";
            default:
                return "";
        }
    }

    private void fillComboBox() {
        this.buscarAutorCBox.addItem("Todos");
        this.buscarAutorCBox.addItem("Alias");
        this.buscarAutorCBox.addItem("Nombre");
        this.buscarAutorCBox.addItem("Apellidos");
        this.buscarAutorCBox.addItem("Fecha de nacimiento");
        this.buscarAutorCBox.addItem("Nacionalidad");
    }

    public void makeAutorTableSpecific(String busqueda, String value) {
        ModelTableAutor modelTableAutor = new ModelTableAutor(new DataBase().getAutoresEspecificos(busqueda,value));
        mostrarAutorBusqueda.setModel(modelTableAutor);
    }
}
