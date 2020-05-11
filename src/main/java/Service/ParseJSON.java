package Service;

import Model.User;
import com.jayway.jsonpath.JsonPath;
import java.util.ArrayList;
import java.util.List;

public class ParseJSON {

    private String jsonString;

    public ArrayList<User> parser(String jsonString){
        int nbUsers = ((List<User>) JsonPath.parse(jsonString).read("$.users[*]")).size();
        ArrayList<User> userList = new ArrayList<User>();

        for (int i=0; i< nbUsers; i++){
            userList.add(JsonPath.parse(jsonString).read("$.users["+i+"]", User.class));
        }

        return userList;
    }
}
