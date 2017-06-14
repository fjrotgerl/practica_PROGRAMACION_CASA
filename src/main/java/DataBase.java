import com.mysql.fabric.xmlrpc.base.Data;

import javax.swing.*;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Kekko on 23/05/2017.
 */
public class DataBase {

    static DataBase dataBase = new DataBase();
    private PropertiesGetInfo propertiesFile = new PropertiesGetInfo();
    private String usuarioActual;

    public DataBase() {
    }

    // Verificamos si el usuario y la contraseña existen en la base de datos
    public boolean checkLogin(String user, String password) throws Exception {
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));

        Statement s = c.createStatement();
        usuarioActual = user;
        try {
            ResultSet rs = s.executeQuery("SELECT COUNT(USUARIO),COUNT(CONTRASEÑA) FROM BIBLIOTECARIO WHERE USUARIO = '" + user + "' AND CONTRASEÑA = MD5('" + password + "');");
            while (rs.next()) {
                if (rs.getInt(1) == 1) {
                    return true;
                }
            }
            c.close();

        } catch (Exception e) {
            System.out.println("Fallo en el usuario y/o contraseña");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
        return false;
    }

      /////////////
     // SOCIOS  //
    /////////////

    List getSocios(){
        try {
            List<Socio> socios = new LinkedList<Socio>();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                            + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                    propertiesFile.getInfo("pass"));
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM SOCIO");
            while (rs.next()) {
                int id = rs.getInt(1);
                String dni = rs.getString(2);
                String nombre = rs.getString(3);
                String primerApellido = rs.getString(4);
                String segundoApellido = rs.getString(5);
                Date fechaNacimiento = rs.getDate(6);
                String genero = rs.getString(7);
                String direccion = rs.getString(8);
                int cp = rs.getInt(9);
                String provincia = rs.getString(10);
                String pais = rs.getString(11);
                int tel1 = rs.getInt(12);
                int tel2 = rs.getInt(13);
                String email = rs.getString(14);
                Date fechaBaja = rs.getDate(15);
                socios.add(new Socio(id,dni,nombre,primerApellido,segundoApellido,fechaNacimiento,genero,direccion,cp,provincia,pais,tel1,tel2,email,fechaBaja));
            }
            return socios;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Sacamos los socios
    public Socio getSocio(JTable table) {
        ModelTableSocio modeloSocio = (ModelTableSocio) table.getModel();
        return modeloSocio.getSocioAt(table.getSelectedRow());
    }

    // Hacemos un insert de socio
    public void insertSocio(String dni, String nombre, String apellido1, String apellido2, int año, int mes, int dia, String genero, String direccion, int cp, String provincia, String pais, int tel1, int tel2, String email) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO SOCIO VALUES (NULL,'" + dni +
                        "','" + nombre +
                        "','" + apellido1 +
                        "','" + apellido2 +
                        "','" + año + "-" + mes + "-" + dia +
                        "','" + genero + "','"
                        + direccion +
                        "','" + cp +
                        "','" + provincia +
                        "','" + pais +
                        "','" + tel1 +
                        "','"+ tel2 +
                        "','" + email +
                        "', NULL);");
                psInsertar.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    // Añadimos fecha de baja al socio
    public void deleteSocio(Socio socio) throws Exception {
        PreparedStatement psDelete = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));

        Statement s = c.createStatement();
        try {
            if (psDelete == null) {
                psDelete = c.prepareStatement("UPDATE SOCIO SET FECHA_BAJA = NOW() WHERE NUM_SOCIO = " + socio.numSocio + ";");
                psDelete.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al borrar el socio");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    // Eliminamos fecha de baja al socio
    public void darAltaSocio(Socio socio) throws Exception {
        PreparedStatement psDelete = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));
        Statement s = c.createStatement();
        try {
            if (psDelete == null) {
                psDelete = c.prepareStatement("UPDATE SOCIO SET FECHA_BAJA = NULL WHERE NUM_SOCIO = " + socio.numSocio + ";");
                psDelete.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al borrar el socio");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

      //////////////
     // TEMATICA //
    //////////////

    List getTematicas(){
        try {
            List<Tematica> tematicas = new LinkedList<Tematica>();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                            + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                    propertiesFile.getInfo("pass"));            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM TEMATICA");
            while (rs.next()) {
                String tematica = rs.getString(1);
                tematicas.add(new Tematica(tematica));
            }
            return tematicas;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Sacamos las tematicas
    public Tematica getTematica(JTable table) {
        ModelTableTematica modelTematica = (ModelTableTematica) table.getModel();
        return modelTematica.getTematicaAt(table.getSelectedRow());
    }

    // Añadimos tematica
    public void añadirTematica(String tematica) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));
        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO TEMATICA VALUES('" + tematica + "');");
                psInsertar.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al añadir la tematica");
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

      /////////////
     // AUTORES //
    /////////////

    List getAutores(){
        try {
            List<Autor> autores = new LinkedList<Autor>();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                            + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                    propertiesFile.getInfo("pass"));            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM AUTOR");
            while (rs.next()) {
                String alias = rs.getString(2);
                String nombre = rs.getString(3);
                String apellidos = rs.getString(4);
                Date fechaNacimiento = rs.getDate(5);
                String nacionalidad = rs.getString(6);
                autores.add(new Autor(alias,nombre,apellidos,fechaNacimiento,nacionalidad));
            }
            return autores;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Sacamos los autores
    public Autor getAutor(JTable table) {
        ModelTableAutor modelAutor = (ModelTableAutor) table.getModel();
        return modelAutor.getAutorAt(table.getSelectedRow());
    }

    // Añadimos autor
    public void añadirAutor(String alias, String nombre, String apellidos, int año, int mes, int dia, String nacionalidad) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));
        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO AUTOR VALUES(DEFAULT,'" + alias +
                        "','" + nombre +
                        "','" + apellidos +
                        "','" + año + "-" + mes + "-" + dia +
                        "','" + nacionalidad + "');");
                psInsertar.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al añadir el autor");
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

      ////////////
     // LIBROS //
    ////////////

    List getLibros(){
        try {
            List<Libro> libros = new LinkedList<Libro>();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                            + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                    propertiesFile.getInfo("pass"));
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM LIBRO");
            while (rs.next()) {
                int isbn = rs.getInt(1);
                String titulo = rs.getString(2);
                int numPaginas = rs.getInt(3);
                String portada = rs.getString(4);
                String editorial = rs.getString(5);
                int autores = rs.getInt(6);
                String tematica = rs.getString(7);
                Date fechaBaja = rs.getDate(8);
                libros.add(new Libro(isbn,titulo,numPaginas,portada,editorial,autores,tematica,fechaBaja));
            }
            return libros;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Sacamos los libros
    public Libro getLibro(JTable table) {
        ModelTableLibro modelLibro = (ModelTableLibro) table.getModel();
        return modelLibro.getLibroAt(table.getSelectedRow());
    }

    // Hacemos un insert de libro
    public void insertLibro(int isbn, String titulo, int numPaginas, String portada, String editorial, int autores, String tematica) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));
        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO LIBRO VALUES ('" + isbn +
                        "','" + titulo +
                        "','" + numPaginas +
                        "','" + portada +
                        "','" + editorial +
                        "',(SELECT ID_AUTOR FROM AUTOR WHERE ID_AUTOR='" + autores + "')" +
                        ",(SELECT TIPO FROM TEMATICA WHERE TIPO='" + tematica + "'),NULL);");
                psInsertar.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    // Añadimos fecha de baja al libro
    public void deleteLibro(Libro libro) throws Exception {
        PreparedStatement psDelete = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));

        Statement s = c.createStatement();
        try {
            if (psDelete == null) {
                psDelete = c.prepareStatement("UPDATE LIBRO SET FECHA_BAJA = NOW() WHERE ISBN = " + libro.isbn + ";");
                psDelete.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al borrar el libro");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

    // Eliminamos fecha de baja al libro
    public void darAltaLibro(Libro libro) throws Exception {
        PreparedStatement psDelete = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));
        Statement s = c.createStatement();
        try {
            if (psDelete == null) {
                psDelete = c.prepareStatement("UPDATE LIBRO SET FECHA_BAJA = NULL WHERE ISBN = " + libro.isbn + ";");
                psDelete.execute();
            }
        } catch (Exception e) {
            System.out.println("Fallo al borrar el libro");
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

      /////////////////
     // ESTANTERIAS //
    /////////////////

    List getEstanterias(){
        try {
            List<Estanteria> estanterias = new LinkedList<Estanteria>();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                            + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                    propertiesFile.getInfo("pass"));
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM ESTANTERIA");
            while (rs.next()) {
                int id = rs.getInt(1);
                String tematica = rs.getString(2);
                String ubicacion = rs.getString(3);
                estanterias.add(new Estanteria(id,tematica,ubicacion));
            }
            return estanterias;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Sacamos los libros
    public Estanteria getEstanteria(JTable table) {
        ModelTableEstanteria modelTableEstanteria = (ModelTableEstanteria) table.getModel();
        return modelTableEstanteria.getEstanteriaAt(table.getSelectedRow());
    }

    public void añadirEstanteria(String tematica, String ubicacion) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));        Statement s = c.createStatement();
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO ESTANTERIA VALUES (DEFAULT,'" + tematica + "','" +
                         ubicacion + "');");
                psInsertar.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }

      ///////////////
     // PRESTAMOS //
    ///////////////

    List getPrestamos(){
        try {
            List<Prestamo> prestamos = new LinkedList<Prestamo>();
            Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                            + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                    propertiesFile.getInfo("pass"));
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM PRESTAMO");
            Statement s2 = c.createStatement();
            ResultSet rs2 = s2.executeQuery("SELECT CONCAT(S.NOMBRE,' ',S.PRIMER_APELLIDO,' ',S.SEGUNDO_APELLIDO)" +
                    " FROM SOCIO S, PRESTAMO P WHERE P.FK_SOCIO=S.NUM_SOCIO");
            while (rs.next() && rs2.next()) {
                String socio = rs2.getString(1);
                String sancion = rs.getString(3);
                String bibliotecario = rs.getString(4);
                String libro = rs.getString(5);
                Date fechaInicio = rs.getDate(6);
                Date fechaFinal = rs.getDate(7);
                prestamos.add(new Prestamo(socio,sancion,bibliotecario,libro,fechaInicio,fechaFinal));
            }
            return prestamos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Prestamo getPrestamo(JTable table) {
        ModelTablePrestamo modelTablePrestamo = (ModelTablePrestamo) table.getModel();
        return modelTablePrestamo.getPrestamoAt(table.getSelectedRow());
    }

    public void añadirPrestamo(String socio, String libro, String primerApellido, String segundoApellido) throws Exception {
        PreparedStatement psInsertar = null;
        Connection c = DriverManager.getConnection("jdbc:mysql://" + propertiesFile.getInfo("server")
                        + "/" + propertiesFile.getInfo("database"), propertiesFile.getInfo("user"),
                propertiesFile.getInfo("pass"));        Statement s = c.createStatement();
        String selectSocio = "SELECT NUM_SOCIO FROM SOCIO WHERE NOMBRE='" + socio + "' " +
                "AND PRIMER_APELLIDO='" + primerApellido + "' AND SEGUNDO_APELLIDO='" + segundoApellido + "'";
        String selectBibliotecario = "SELECT DNI FROM BIBLIOTECARIO WHERE USUARIO='" + usuarioActual + "'";
        String selectLibro = "SELECT ISBN FROM LIBRO WHERE TITULO='" + libro + "'";
        try {
            // Insert into
            if (null == psInsertar) {
                psInsertar = c.prepareStatement("INSERT INTO PRESTAMO VALUES (DEFAULT,(" + selectSocio +
                                "), NULL, (" + selectBibliotecario +
                                "),(" + selectLibro +"), NOW(), NULL);");
                psInsertar.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            if(c != null) c.close();
            if(s != null)  s.close();
        }
    }
}
