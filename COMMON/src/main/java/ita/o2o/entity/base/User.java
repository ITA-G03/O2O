package ita.o2o.entity.base;

import ita.o2o.entity.extra.Role;
import ita.o2o.entity.location.Location;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
public class User {
    private int userId;
    private String nickName;
    private String tel;
    private String encryptedPassword;//加密后的密码
    private Location location;
    private Role role;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
