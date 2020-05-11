import Model.User;
import Service.ImportJSON;
import Service.ParseJSON;
import Service.Stats;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String arg[])  {

        /**
         * Read file
         */
        String path = "src\\main\\resources\\liste_noms_age.json";
        ImportJSON importJSON = new ImportJSON();
        String fileContent = importJSON.readFile(path);
        //System.out.println(fileContent);

        /**
         * Parse file content into Object
         */
        ParseJSON parseJSON = new ParseJSON();
        ArrayList<User> userList = parseJSON.parser(fileContent);
        System.out.println(Arrays.toString(userList.toArray()));

        /**
         * Do some stats on the data
         */
        Stats stats = new Stats(userList);
        System.out.println("YoungestUser: " + stats.getYoungest());
        System.out.println("YoungestUserStream: " + stats.getYoungestStream());
        System.out.println();
        System.out.println("OldestUser: " + stats.getOldest());
        System.out.println("OldestUserStream: " + stats.getOldestStream());
        System.out.println();

    }
}
