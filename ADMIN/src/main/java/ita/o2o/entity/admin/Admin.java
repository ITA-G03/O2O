package ita.o2o.entity.admin;

import javax.persistence.*;

/**
 * @author Jason Cui
 * @version 2015-08-25
 */
@Entity
@Table(name="ADMIN_USER")
public class Admin {
    @Id
    @SequenceGenerator(sequenceName="SEQ_ADMIN_USER",name="adminSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="adminSequence")
    @Column(name="ADMIN_ID",nullable = false)
    private int adminId;


    @Basic
    @Column(name="ADMIN_NAME")
    private String name;


    @Basic
    @Column(name="ENCRYPTED_PASSWORD")
    private String encryptedPassword;


    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }
}
