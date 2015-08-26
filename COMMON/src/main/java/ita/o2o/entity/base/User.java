package ita.o2o.entity.base;

import ita.o2o.entity.extra.Role;
import ita.o2o.entity.location.Location;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="O2O_USER")//因为USER 不能作为一个数据表
public class User {

    @Id
    @SequenceGenerator(sequenceName="SEQ_O2O_USER",name="o2oUserSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="o2oUserSequence")
    @Column(name="USER_ID",nullable = false)
    private int userId;

    @Basic
    @Column(name="NICKNAME")
    private String nickName;

    @Basic
    @Column(name = "TEL",nullable = false)
    private String tel;

    @Basic
    @Column(name= "ENCRYPTED_PASSWORD",nullable = false)
    private String encryptedPassword;//加密后的密码


    @OneToOne
    @JoinColumn(name="LOCATION_ID")
    private Location location;

    @OneToOne
    @JoinColumn(name="ROLE_ID")
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
