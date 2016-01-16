package task6.properties_to_map;

import task5.universal_properties.PropertiesFileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Elizaveta Kapitonova on 16.01.16.
 */
public class PropertiesToMapReader {
    private Properties property;
    private Map<String, String> propertyMap;

    public PropertiesToMapReader(String path)  {
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
    public Map<String, String > getProperties() {
        propertyMap = new HashMap<>(property.size());
        for (String keys : property.stringPropertyNames()) {
            propertyMap.put(keys, property.getProperty(keys));

        }
        return propertyMap;
    }

    // what happens if we add duplicate key to map?
    // old value of the key will be replaced with the new one
    public void duplicateAdd() {
        String duplicate_key = "";
        Map<String, String> duplMap = new HashMap<>();
        for (String keys : property.stringPropertyNames()) {
            duplMap.put(keys, property.getProperty(keys));
            duplicate_key = keys;
        }
        System.out.println();
        System.out.println(duplicate_key + " - duplicate key");
        duplMap.put(duplicate_key, "some value");
        for (String k : duplMap.keySet()) {
            System.out.println(k + " " + duplMap.get(k));
        }
    }

    public static void main(String[] args) {
        final String PATH_ONE = "task5_properties/one.properties";
        final String PATH_THREE_WRONG = "task5_properties/thre.properties";
        PropertiesToMapReader propertiesToMapReader = new PropertiesToMapReader(PATH_ONE);
        Map<String, String> map = propertiesToMapReader.getProperties();
        for (String k : map.keySet()) {
            System.out.println(k + " " + map.get(k));
        }
        propertiesToMapReader.duplicateAdd();

//        PropertiesToMapReader ptmr = new PropertiesToMapReader(PATH_THREE_WRONG);
//        Map<String, String> map_wrong = propertiesToMapReader.getProperties();
    }


}
