package task7.properties_reader;

import task5.universal_properties.PropertiesFileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Elizaveta Kapitonova on 24.01.16.
 */
public class PropertiesSynchReader {
    private Properties property;
    private static final Object lock = new Object();

    public PropertiesSynchReader(String path)  {
        property = new Properties();
        synchronized (lock) {
            try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path)) {
                if (inputStream != null) {
                    property.load(inputStream);
                } else {
                    System.err.format("Properties file %s not found%n", path);
                    throw new PropertiesFileNotFoundException();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized String getPropertyByKey(String key) {
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
}
