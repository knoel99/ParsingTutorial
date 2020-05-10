package Service;

import Model.User;
import java.util.List;

public class Stats {

    private List<User> userList;

    public Stats(List<User> userList) {
        for (User user: userList) {
            this.userList.add(user);
        }
    }

    public Stats() {}

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getYoungest(){
        User youngestUser = new User();
        try {
            youngestUser = (User) this.userList.get(0);
            for (int i=0; i<this.userList.size(); i++){
                System.out.println(this.userList.get(i));
                if (youngestUser.getAge() < this.userList.get(i).getAge()) {
                    youngestUser = (User) this.userList.get(i);
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return youngestUser;
    }

}
