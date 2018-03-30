package builder;

/**
 * Created by Administrator on 2017/10/26 0026.
 */

public class UserBean {

    //对象具有多个属性
    private String firstName;
    private String lastName;
    private int age;
    private String phone;
    private String address;

    //私有构造方法, 接收一个内部类对象
    private UserBean(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    //内部Builder类
    public static class UserBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private String phone;
        private String address;

        public UserBuilder() {
        }

        public UserBuilder age(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public UserBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public UserBean build() {
            return new UserBean(this);
        }
    }
}

