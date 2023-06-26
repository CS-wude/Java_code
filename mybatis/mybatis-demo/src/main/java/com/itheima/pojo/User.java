package com.itheima.pojo;

/**
 * @BelongsProject: mybatis
 * @BelongsPackage: com.itheima.pojo
 * @FileName: User
 * @Author: wude
 * @Date: 2023/6/26-21:56
 * @Version: 1.0
 * @Description:
 */
public class User {
    //alt 加上鼠标左键可以整列编辑
    private int id;
    private String username;
    private String password;
    private String nickname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
