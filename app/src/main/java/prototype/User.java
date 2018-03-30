package prototype;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/10/31 0031.
 */

public class User implements Cloneable{

    //基本类型
    private String name;
    private String age;
    //引用类型
    private ArrayList<Integer> scores;

    @Override
    protected User clone() throws CloneNotSupportedException {
        User user= (User) super.clone();
        user.age=this.age;
        user.name=this.name;
//        user.scores= (ArrayList<Integer>) this.scores.clone();
        user.scores=this.scores;
        return user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }
}
