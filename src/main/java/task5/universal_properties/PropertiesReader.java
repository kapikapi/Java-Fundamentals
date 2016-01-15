package task5.universal_properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by Elizaveta Kapitonova on 15.01.16.
 */
public class PropertiesReader {

    private Properties property;

    public PropertiesReader(String path)  {
        property = new Properties();
        try(InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
            if (inputStream!=null) {
                property.load(inputStream);
            } else {
                System.err.format("Properties file %s not found%n", path);
                throw new PropertiesFileNotFoundException();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPropertyByKey(String key) {
        try{
            if (property.containsKey(key)) {
                return property.getProperty(key);
            } else {
                System.err.format("No such key : %s%n", key);
                return null;
            }
        } catch (NullPointerException e) {
            // never happens as checked before
            throw new InternalError(e);
        }
    }


    public static void main(String[] args) {
        final String WRONG_PATH = "/gggg.properties";
        final String PATH_ONE = "task5_properties/one.properties";

        try {
            PropertiesReader propertiesReader = new PropertiesReader(WRONG_PATH);
            propertiesReader.getPropertyByKey("a");
        } catch (PropertiesFileNotFoundException e) {
            System.out.println("File not found");
        }

        PropertiesReader propertiesReader1 = new PropertiesReader(PATH_ONE);
        propertiesReader1.getPropertyByKey("b");
        propertiesReader1.getPropertyByKey("z");
    }
}
