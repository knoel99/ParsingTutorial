package Service;

import Model.User;
import com.jayway.jsonpath.JsonPath;

import java.util.List;

public class ParseJSON {

    private String jsonString;

    public List<User> parser(String jsonString){
        return JsonPath.read(jsonString, "$.users[*]");
    }
}
