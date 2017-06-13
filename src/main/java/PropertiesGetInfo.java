import java.io.*;
import java.util.Properties;

/**
 * Created by Kekko on 13/06/2017.
 */
public class PropertiesGetInfo {

    public PropertiesGetInfo() {

    }

    public String getInfo(String campo) {
        Properties prop = new Properties();
        InputStream input;
        try {
            input = new FileInputStream("src/main/resources/application.properties");
            prop.load(input);
            if (campo.equals("server")) return prop.getProperty("server");
            if (campo.equals("user")) return prop.getProperty("user");
            if (campo.equals("pass")) return prop.getProperty("pass");
            if (campo.equals("database")) return prop.getProperty("database");
            return prop.getProperty("server");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
