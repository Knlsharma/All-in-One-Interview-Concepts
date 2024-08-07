package helper;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author : Kunal Sharma
 * @since : 17/02/23, Friday
 **/
public class PropertyContext {

    private static PropertyContext ourInstance = new PropertyContext();
    private static Properties YAML_PROPERTIES;

    private PropertyContext() {

    }

    private Properties loadPropertyFile(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream in = PropertyContext.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(in);
        } catch (Throwable t) {
//            logger.error("Error in reading properties {} : {}", fileName, t);
        }
        return properties;
    }
}



