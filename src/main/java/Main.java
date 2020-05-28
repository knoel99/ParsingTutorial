import Model.User;
import Service.ImportJSON;
import Service.ParseJSON;
import Service.ParseXML;
import Service.Stats;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String arg[])  {
        String path = Paths.get(".", "src", "main", "resources", "liste_noms_age.json").toString();

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
        System.out.println(Arrays.toString(userList));

        /**
         * Do some stats on the data
         */
        Stats stats = new Stats(userList);
        stats.compute();
        System.out.println(stats.toString());

        /**
         * Import and parse XML
         */
        String pathXML = Paths.get(".", "src", "main", "resources", "liste_noms_age.XML").toString();
        ParseXML parseXML = new ParseXML();
        parseXML.parseXML(pathXML);
        ArrayList<User> userListXML = parseXML.parseXML(pathXML);

        User[] userList2 = new User[userListXML.size()];
        for (int i=0; i <userListXML.size(); i++){
            userList2[i] = new User(userListXML.get(i).getName(), userListXML.get(i).getAge());
        }
        System.out.println("\n" + Arrays.toString(userList2));

        Stats stats2 = new Stats(userList2);
        stats2.compute();
        System.out.println(stats2.toString());
    }
}
