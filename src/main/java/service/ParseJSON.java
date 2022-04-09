package service;

import model.User;
import com.jayway.jsonpath.JsonPath;

public class ParseJSON {

    private String jsonString;

    public User[] parser(String jsonString){
        return JsonPath.parse(jsonString).read("$.users[*]", User[].class);
    }
}
