package Config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static Properties loadProperties(String resourceFileName) throws IOException {
        Properties configuration = new Properties();
        InputStream inputStream = Config.class
                .getClassLoader()
                .getResourceAsStream(resourceFileName);
        configuration.load(inputStream);
        inputStream.close();
        return configuration;
    }
}
