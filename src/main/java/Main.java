import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

/**
 * Created by Kekko on 23/05/2017.
 */
public class Main {

    static JFrame frame = new JFrame();
    static JMenuBar jmb = new JMenuBar();

    static LoginForm loginForm = new LoginForm();
    static InicioForm inicioForm = new InicioForm();
    static AñadirSocioForm añadirSocioForm = new AñadirSocioForm();
    static AñadirLibroForm añadirLibroForm = new AñadirLibroForm();
    static AñadirTematicaForm añadirTematicaForm = new AñadirTematicaForm();
    static AñadirAutorForm añadirAutorForm = new AñadirAutorForm();
    static AñadirPrestamoForm añadirPrestamoForm = new AñadirPrestamoForm();
    static AñadirSancionForm añadirSancionForm = new AñadirSancionForm();
    static BajaAltaSocioForm bajaAltaSocioForm = new BajaAltaSocioForm();
    static BajarAltaLibroForm bajarAltaLibroForm = new BajarAltaLibroForm();
    static AñadirEstanteriaForm añadirEstanteriaForm = new AñadirEstanteriaForm();
    static ModificarPrestamosForm modificarPrestamosForm = new ModificarPrestamosForm();
    static BuscarLibroForm buscarLibroForm = new BuscarLibroForm();
    static BuscarAutorForm buscarAutorForm = new BuscarAutorForm();
    static VerSanciones verSanciones = new VerSanciones();
    static DataBase db = new DataBase();

    public static void main(String[] args) throws Exception {
        JPanel panel = new JPanel();

        panel.setLayout(new CardLayout());
        panel.add(loginForm.getLoginPanel(), "loginPanel");
        panel.add(inicioForm.getInicioPanel(), "inicioPanel");
        panel.add(añadirTematicaForm.getTematicaPanel(), "añadirTematicaPanel");
        panel.add(añadirSocioForm.getAñadirSociPanel(), "añadirSociPanel");
        panel.add(añadirAutorForm.getAñadirAutorPanel(), "añadirAutorPanel");
        panel.add(añadirLibroForm.getAñadirLibroPanel(), "añadirLibroPanel");
        panel.add(añadirSancionForm.getSancionPanel(),"añadirSancionPanel");
        panel.add(añadirEstanteriaForm.getAñadirEstanteriaPanel(), "añadirEstanteriaPanel");
        panel.add(añadirPrestamoForm.getAñadirPrestamoPanel(), "añadirPrestamoPanel");
        panel.add(bajaAltaSocioForm.getEliminarSocioPanel(), "eliminarSociPanel");
        panel.add(bajarAltaLibroForm.getMirarLibroPanel(), "altaBajaLibroPanel");
        panel.add(modificarPrestamosForm.getSancionPanel(), "modificarPrestamoPanel");
        panel.add(verSanciones.getVerSanctionPanel(), "verSancionPanel");
        panel.add(buscarLibroForm.getBuscarLibroPanel(), "buscarLibroPanel");
        panel.add(buscarAutorForm.getBuscarAutorPanel(), "buscarAutorPanel");

        // Em torna un objecte de tipus Layout
        // Hi ha que fer un cast a castLayout
        CardLayout cl = (CardLayout) panel.getLayout();
        cl.show(panel,"loginPanel");
        frame.setTitle("Login");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setContentPane(panel);
        centreWindow(frame);

    }

    // Cream la barra superior
    public static void initMenu(final JFrame frame) {
        frame.setJMenuBar(jmb);

        JMenu mLibros = new JMenu("Libros");
        jmb.add(mLibros);
        JMenuItem mLibroAñadir = new JMenuItem("Añadir un libro...");
        JMenuItem mLibroBorrar = new JMenuItem("Borrar un libro existente...");
        JMenuItem mLibroBuscar = new JMenuItem("Buscar un libro existente...");
        JMenuItem mTematicaAñadir = new JMenuItem("Añadir una temática nueva...");
        JMenuItem mAutorAñadir = new JMenuItem("Añadir un autor...");
        JMenuItem mAutorBuscar = new JMenuItem("Buscar un autor...");
        JMenuItem mEstanteriaAñadir = new JMenuItem("Añadir una estanteria...");
        mLibros.add(mLibroAñadir);
        mLibros.add(mLibroBorrar);
        mLibros.add(mLibroBuscar);
        mLibros.addSeparator();
        mLibros.add(mTematicaAñadir);
        mLibros.addSeparator();
        mLibros.add(mAutorAñadir);
        mLibros.add(mAutorBuscar);
        mLibros.addSeparator();
        mLibros.add(mEstanteriaAñadir);

        mLibroAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirLibroForm.makeAutorTable();
                añadirLibroForm.makeTematicaTable();
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirLibroPanel");
                Main.configSimple(Main.frame,"Añadir libro");
            }
        });

        mLibroBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bajarAltaLibroForm.makeLibroTable();
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"altaBajaLibroPanel");
                Main.configSimple(Main.frame,"Dar de baja/alta libro");
            }
        });

        mLibroBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"buscarLibroPanel");
                Main.configSimple(Main.frame,"Buscar un libro");
            }
        });

        mTematicaAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirTematicaPanel");
                Main.configSimple(Main.frame,"Añadir temática");
            }
        });

        mAutorAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirAutorPanel");
                Main.configSimple(Main.frame,"Añadir autor");
            }
        });

        mAutorBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"buscarAutorPanel");
                Main.configSimple(Main.frame,"Buscar un autor");
            }
        });

        mEstanteriaAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                añadirEstanteriaForm.makeTematicaTableInEstanteria();
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirEstanteriaPanel");
                Main.configSimple(Main.frame,"Añadir estanteria");
            }
        });


        JMenu mSocios = new JMenu("Socios");
        jmb.add(mSocios);
        JMenuItem miSocioAñadir = new JMenuItem("Añadir un socio nuevo...");
        JMenuItem miSocioBajaAlta = new JMenuItem("Dar de baja/alta un socio existente...");
        mSocios.add(miSocioAñadir);
        mSocios.add(miSocioBajaAlta);

        miSocioAñadir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirSociPanel");
                Main.configSimple(Main.frame,"Añadir socio");

            }
        });

        miSocioBajaAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bajaAltaSocioForm.makeSocioTable();
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"eliminarSociPanel");
                Main.configSimple(Main.frame,"Eliminar socio");

            }
        });

        JMenu mPrestamos = new JMenu("Prestamos");
        jmb.add(mPrestamos);
        JMenuItem mPrestamoAñadir = new JMenuItem("Hacer un prestamo...");
        JMenuItem mPrestamoModificar = new JMenuItem("Modificar un prestamo...");
        mPrestamos.add(mPrestamoAñadir);
        mPrestamos.add(mPrestamoModificar);

        mPrestamoAñadir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"añadirPrestamoPanel");
                Main.configSimple(Main.frame,"Añadir prestamo");
                añadirPrestamoForm.makeLibroTableInPrestamo();
                añadirPrestamoForm.makeSocioTableInPrestamo();
            }
        });

        mPrestamoModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"modificarPrestamoPanel");
                Main.configSimple(Main.frame,"Modificar prestamo");
                modificarPrestamosForm.makePrestamoInPrestamoMod();
            }
        });


        JMenu mOpciones = new JMenu("Opciones");
        jmb.add(mOpciones);
        JMenuItem mOpcionCerrarSesion = new JMenuItem("Salir");
        JMenuItem mOpcionCambiarUsuario = new JMenuItem("Cambiar de usuario");
        mOpciones.add(mOpcionCambiarUsuario);
        mOpciones.add(mOpcionCerrarSesion);

        mOpcionCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispatchEvent(new WindowEvent(Main.frame, WindowEvent.WINDOW_CLOSING));
            }
        });

        mOpcionCambiarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) Main.frame.getContentPane().getLayout();
                cl.show(Main.frame.getContentPane(),"loginPanel");
                Main.configSimple(Main.frame,"Login");
                Main.frame.setSize(300, 150);
                Main.centreWindow(Main.frame);
                Main.frame.getJMenuBar().removeAll();
            }
        });

        jmb.setVisible(true);
    }

    // Centram la finestra
    public static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }

    public static void configSimple(JFrame frame, String titol) {
        frame.setTitle(titol);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
