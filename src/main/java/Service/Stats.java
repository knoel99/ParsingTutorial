package Service;

import Model.User;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Stats {

    private User[] userList;
    private User youngest;
    private User youngestStream;
    private User oldest;
    private User oldestStream;
    private float averageAge;
    private float averageAgeStream;
    private int largestAgeGap;
    private int largestAgeGapStream;

    public Stats(User[] userList) {
        this.userList = userList ;
    }

    public User computeYoungest(){
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

    public User computeYoungestStream(){
        return Arrays.stream(this.userList)
                .min(Comparator.comparing(User::getAge))
                .get();
    }

    public User computeOldest(){
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

    public User computeOldestStream(){
        return Arrays.stream(this.userList)
                .max(Comparator.comparing(User::getAge))
                .get();
    }

    public float computeAverageAge(){
        int averageAge = 0;
        try {
            for (User user: this.userList){
                averageAge += user.getAge();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return (float) averageAge/this.userList.length;
    }

    public float computeAverageAgeStream(){
        return (float) Arrays.stream(this.userList)
                .mapToDouble(User::getAge)
                .average()
                .getAsDouble();
    }

    public int computeLargestAgeGap(){
        int gap = 0;
        try {
            gap = this.userList[1].getAge() - this.userList[0].getAge();
            for (int i=1; i < userList.length-1; i++){
                if (gap < this.userList[i+1].getAge() - this.userList[i].getAge()){
                    gap = this.userList[i+1].getAge() - this.userList[i].getAge();
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return gap;
    }

    public int computeLargestAgeGapStream(){
        return IntStream
                .range(0, this.userList.length -1)
                .map(i -> this.userList[i+1].getAge()-this.userList[i].getAge())
                .max()
                .getAsInt();
    }

    public void compute(){
        this.setYoungest(this.computeYoungest());
        this.setYoungestStream(this.computeYoungestStream());
        this.setOldest(this.computeOldest());
        this.setOldestStream(this.computeOldestStream());
        this.setAverageAge(this.computeAverageAge());
        this.setAverageAgeStream(this.computeAverageAgeStream());
        this.setLargestAgeGap(this.computeLargestAgeGap());
        this.setLargestAgeGapStream(this.computeLargestAgeGapStream());
    }

    /***
     * getter and setters
     */

    public User[] getUserList() {
        return userList;
    }
    public void setUserList(User[] userList) {
        this.userList = userList;
    }

    public User getYoungest() {
        return youngest;
    }
    public void setYoungest(User youngest) {
        this.youngest = youngest;
    }

    public User getYoungestStream() {
        return youngestStream;
    }
    public void setYoungestStream(User youngestStream) {
        this.youngestStream = youngestStream;
    }

    public User getOldest() {
        return oldest;
    }
    public void setOldest(User oldest) {
        this.oldest = oldest;
    }

    public User getOldestStream() {
        return oldestStream;
    }
    public void setOldestStream(User oldestStream) {
        this.oldestStream = oldestStream;
    }

    public float getAverageAge() {
        return averageAge;
    }
    public void setAverageAge(float averageAge) {
        this.averageAge = averageAge;
    }

    public float getAverageAgeStream() {
        return averageAgeStream;
    }
    public void setAverageAgeStream(float averageAgeStream) {
        this.averageAgeStream = averageAgeStream;
    }

    public int getLargestAgeGap() {
        return largestAgeGap;
    }
    public void setLargestAgeGap(int largestAgeGap) {
        this.largestAgeGap = largestAgeGap;
    }

    public int getLargestAgeGapStream() {
        return largestAgeGapStream;
    }
    public void setLargestAgeGapStream(int largestAgeGapStream) {
        this.largestAgeGapStream = largestAgeGapStream;
    }

    public String toString(){
        return "YoungestUser: " + this.getYoungest() + "\n"+
                "YoungestUserStream: " + this.getYoungestStream() + "\n"+
                "\n"+
                "OldestUser: " + this.getOldest()+ "\n"+
                "OldestUserStream: " + this.getOldestStream()+ "\n"+
                "\n"+
                "AverageAge: " + this.getAverageAge()+"\n"+
                "AverageAgeStream: " + this.getAverageAgeStream()+"\n"+
                "\n"+
                "LargestAgeGap: " + this.getLargestAgeGap()+"\n"+
                "LargestAgeGapStream: " + this.getLargestAgeGapStream();
    }
}
