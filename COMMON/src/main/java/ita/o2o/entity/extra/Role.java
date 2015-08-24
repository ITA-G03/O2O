package ita.o2o.entity.extra;

import javax.persistence.*;

/**
 * @author Aquariuslt
 * @version 15-08-22
 */
@Entity
@Table(name="ROLE")
public class Role {

    @Id
    @SequenceGenerator(sequenceName="SEQ_ROLE",name="roleSequence",allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="roleSequence")
    @Column(name="ROLE_ID",nullable = false)
    private int roleId;

    @Basic
    @Column(name="ROLE_NAME",nullable = false)
    private String roleName;


    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
