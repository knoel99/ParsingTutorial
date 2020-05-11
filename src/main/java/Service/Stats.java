package Service;

import Model.User;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Stats {

    private ArrayList<User> userList;

    public Stats(ArrayList<User> userList) {
        this.userList = new ArrayList<User>(userList) ;
    }

    public Stats() {}

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    public User getYoungest(){
        User youngestUser = new User();
        try {
            youngestUser = new User(this.userList.get(0));
            for (int i=0; i<this.userList.size(); i++){
                if (youngestUser.getAge() > this.userList.get(i).getAge()) {
                    youngestUser = new User(this.userList.get(i));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return youngestUser;
    }

    public User getYoungestStream(){
        return this.userList.stream()
                .min(Comparator.comparing(User::getAge))
                .get();
    }

    public User getOldest(){
        User oldestUser = new User();
        try {
            oldestUser = new User(this.userList.get(0));
            for (int i=0; i<this.userList.size(); i++){
                if (oldestUser.getAge() < this.userList.get(i).getAge()) {
                    oldestUser = new User(this.userList.get(i));
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return oldestUser;
    }

    public User getOldestStream(){
        return this.userList.stream()
                .max(Comparator.comparing(User::getAge))
                .get();
    }

}
