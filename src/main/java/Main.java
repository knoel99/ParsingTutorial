import Model.User;
import Service.ImportJSON;
import Service.ParseJSON;
import Service.Stats;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.List;

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
        List<User> userList = parseJSON.parser(fileContent);
        System.out.println(Arrays.toString(userList.toArray()));

        /**
         * Do some stats on the data
         */
        Stats stats = new Stats(userList);
        User youngestUser = stats.getYoungest();
        //User youngestUser = mapper.convertValue(stats.getYoungest2(), User.class);

        //System.out.println(youngestUser);
    }
}
