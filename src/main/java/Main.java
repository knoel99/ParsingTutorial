import Config.Config;
import Model.User;
import Service.ImportJSON;
import Service.ParseJSON;
import Service.ParseXML;
import Service.Stats;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String arg[]) throws IOException {
        //private static log4j
        /**
         * Load configuration
         */
        Properties conf = Config.loadProperties("application.properties");

        String path = Paths.get(".", "src", "main", "resources", conf.getProperty("file.json")).toString();

        /**
         * Read file
         */
        ImportJSON importJSON = new ImportJSON();
        String fileContent = importJSON.readFile(path);

        /**
         * Parse file content into Object
         */
        ParseJSON parseJSON = new ParseJSON();
        User[] userList = parseJSON.parser(fileContent);
        logger.info(Arrays.toString(userList));

        /**
         * Do some stats on the data
         */
        Stats stats = new Stats(userList);
        stats.compute();
        logger.info(stats.toString());

        /**
         * Import and parse XML
         */
        String pathXML = Paths.get(".", "src", "main", "resources", conf.getProperty("file.xml")).toString();
        ParseXML parseXML = new ParseXML();
        parseXML.parseXML(pathXML);
        ArrayList<User> userListXML = parseXML.parseXML(pathXML);

        User[] userList2 = new User[userListXML.size()];
        for (int i=0; i <userListXML.size(); i++){
            userList2[i] = new User(userListXML.get(i).getName(), userListXML.get(i).getAge());
        }
        logger.info("\n" + Arrays.toString(userList2));

        Stats stats2 = new Stats(userList2);
        stats2.compute();
        logger.info(stats2.toString());
    }
}
