/**
 * Created by lenovo on 2018/1/12.
 */
import java.util.*;
public class Students {

    //1. 公有的类
    //2. 提供公有的不带参数的默认的构造方法
    //3. 属性私有
    //4. 属性setter/getter封装
    private int sid;
    private String name;
    private String gender;
    private Date birthday;
    private String address;

    public Students(int sid, String name, String gender, Date birthday, String address) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", address='" + address + '\'' +
                '}';
    }
}
