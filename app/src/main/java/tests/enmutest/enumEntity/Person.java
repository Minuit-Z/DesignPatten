package tests.enmutest.enumEntity;

import android.support.annotation.NonNull;

/**
 * Created by Administrator on 2018/2/26 0026.
 */


public enum Person {
    Li("Lili",12),Zi("Lili",12),Br("Lili",12),Dv("Lili",12);

    private String name;
    private int age;

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    // get set 方法
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //从姓名来查找Person
    public Person getPerson(@NonNull String name){
        for (Person p:Person.values()){
            if (p.name.equals(name)){
                return p;
            }
        }
        return null;
    }
}