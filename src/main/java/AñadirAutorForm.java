import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Javi on 12/06/2017.
 */
public class AñadirAutorForm {
    private JPanel añadirAutorPanel;
    private JTextField autorApellidosText;
    private JTextField autorNombreText;
    private JTextField autorAliasText;
    private JComboBox autorAño;
    private JButton añadirButton;
    private JButton cancelarButton;
    private JComboBox autorDia;
    private JComboBox autorMes;
    private JTextField autorNacionalidadText;

    public AñadirAutorForm() {
        fillComboBox();
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataBase.dataBase.añadirAutor(autorAliasText.getText(),autorNombreText.getText(), autorApellidosText.getText(),
                            (Integer) autorAño.getSelectedItem(), (Integer)autorMes.getSelectedIndex()+1,(Integer) autorDia.getSelectedItem(),
                            autorNacionalidadText.getText());
                    JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir al socio");
                    ex.printStackTrace();
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

    public JPanel getAñadirAutorPanel() {
        return añadirAutorPanel;
    }

    private void fillComboBox() {
        for (int i = 2017; i > 1899; i--) {
            this.autorAño.addItem(i);
        }

        String[] meses =  {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
        for (int i = 0; i < 12; i++) {
            this.autorMes.addItem(meses[i]);
        }

        for (int i = 1; i < 32; i++) {
            this.autorDia.addItem(i);
        }
    }
}
