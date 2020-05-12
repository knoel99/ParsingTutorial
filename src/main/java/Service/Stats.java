package Service;

import Model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Stats {

    private User[] userList;

    public Stats(User[] userList) {
        this.userList = userList ;
    }

    public User[] getUserList() {
        return userList;
    }

    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public User getYoungest(){
        User youngestUser = new User();
        try {
            youngestUser = new User(this.userList[0]);
            for (int i = 0; i< this.userList.length; i++){
                if (youngestUser.getAge() > this.userList[i].getAge()) {
                    youngestUser = new User(this.userList[i]);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return youngestUser;
    }

    public User getYoungestStream(){
        return Arrays.stream(this.userList)
                .min(Comparator.comparing(User::getAge))
                .get();
    }

    public User getOldest(){
        User oldestUser = new User();
        try {
            oldestUser = new User(this.userList[0]);
            for (int i = 0; i< this.userList.length; i++){
                if (oldestUser.getAge() < this.userList[i].getAge()) {
                    oldestUser = new User(this.userList[i]);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return oldestUser;
    }

    public User getOldestStream(){
        return Arrays.stream(this.userList)
                .max(Comparator.comparing(User::getAge))
                .get();
    }

}
