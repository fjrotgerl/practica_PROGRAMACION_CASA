import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kekko on 23/05/2017.
 */
public class AñadirLibroForm {
    private JTable libroTematicaTable;
    private JButton libroCancelarButton;
    private JTextField libroISBNText;
    private JTextField libroTituloText;
    private JTextField libroNumPaginasText;
    private JTextField libroPortadaText;
    private JTextField libroEditorialText;
    private JTable libroAutorTable;
    private JButton libroAñadirButton;
    private JPanel añadirLibroPanel;


    public AñadirLibroForm() {
        libroAñadirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DataBase.dataBase.insertLibro(Integer.parseInt(getLibroISBNText().getText()), getLibroTituloText().getText(),
                            Integer.parseInt(getLibroNumPaginasText().getText()), getLibroPortadaText().getText(),
                            getLibroEditorialText().getText(),getLibroAutorTable().getSelectedRow()+1,
                            (String) getLibroTematicaTable().getValueAt(0,0));
                    JOptionPane.showMessageDialog(null, "Se ha añadido correctamente");
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "No se ha podido añadir al socio");
                }

            }
        });

        libroCancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"inicioPanel");
                Main.configSimple(Main.frame,"Inicio");
            }
        });
    }

    public JPanel getAñadirLibroPanel() {
        return añadirLibroPanel;
    }

    public void makeAutorTable() {
        ModelTableAutor mtAutor = new ModelTableAutor(new DataBase().getAutores());
        libroAutorTable.setModel(mtAutor);
    }

    public void makeTematicaTable() {
        ModelTableTematica mtTematica = new ModelTableTematica(new DataBase().getTematicas());
        libroTematicaTable.setModel(mtTematica);
    }

    public JTable getLibroTematicaTable() {
        return libroTematicaTable;
    }

    public JButton getLibroCancelarButton() {
        return libroCancelarButton;
    }

    public JTextField getLibroISBNText() {
        return libroISBNText;
    }

    public JTextField getLibroTituloText() {
        return libroTituloText;
    }

    public JTextField getLibroNumPaginasText() {
        return libroNumPaginasText;
    }

    public JTextField getLibroPortadaText() {
        return libroPortadaText;
    }

    public JTextField getLibroEditorialText() {
        return libroEditorialText;
    }

    public JTable getLibroAutorTable() {
        return libroAutorTable;
    }

    public JButton getLibroAñadirButton() {
        return libroAñadirButton;
    }
}
