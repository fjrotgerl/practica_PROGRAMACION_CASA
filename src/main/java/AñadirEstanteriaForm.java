import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 12/06/2017.
 */
public class AñadirEstanteriaForm {
    private JTable estanteriaTematicaTable;
    private JButton añadirButton;
    private JTextField estanteriaUbicacionText;
    private JPanel añadirEstanteriaPanel;
    private JButton cancelButton;

    public AñadirEstanteriaForm() {
        añadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataBase.dataBase.añadirEstanteria((String) getEstanteriaTematicaTable().getValueAt(0,0),
                            getEstanteriaUbicacionText().getText());
                    JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir la estanteria");
                    ex.printStackTrace();
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

    public void makeTematicaTableInEstanteria() {
        ModelTableTematica mtTematica = new ModelTableTematica(new DataBase().getTematicas());
        estanteriaTematicaTable.setModel(mtTematica);
    }

    public JTable getEstanteriaTematicaTable() {
        return estanteriaTematicaTable;
    }

    public JButton getAñadirButton() {
        return añadirButton;
    }

    public JTextField getEstanteriaUbicacionText() {
        return estanteriaUbicacionText;
    }

    public JPanel getAñadirEstanteriaPanel() {
        return añadirEstanteriaPanel;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}
