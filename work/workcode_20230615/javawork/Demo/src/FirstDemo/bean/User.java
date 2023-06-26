package FirstDemo.bean;

/**
 * @BelongsProject: javawork
 * @BelongsPackage: FirstDemo.bean
 * @FileName: User
 * @Author: wude
 * @Date: 2023/6/11-10:43
 * @Version: 1.0
 * @Description:
 */

public class User {

    private String username;
    private String password;


    public User() {

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                //"id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}