package com.edu.cqut.newsservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Haibara
 * @since 2023-09-15
 */
@TableName("tb_newsmanager")
public class TbNewsmanager implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "manager_id", type = IdType.AUTO)
    private Integer managerId;

    /**
     * 管理员名字
     */
    private String managerName;

    /**
     * 密码
     */
    private String managerPwd;

    /**
     * 权限
     */
    private Integer managerRole;

    /**
     * 邮箱
     */
    private String managerMail;

    /**
     * 电话
     */
    private String managerPhone;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public String getManagerPwd() {
        return managerPwd;
    }

    public void setManagerPwd(String managerPwd) {
        this.managerPwd = managerPwd;
    }

    public Integer getManagerRole() {
        return managerRole;
    }

    public void setManagerRole(Integer managerRole) {
        this.managerRole = managerRole;
    }

    public String getManagerMail() {
        return managerMail;
    }

    public void setManagerMail(String managerMail) {
        this.managerMail = managerMail;
    }

    public String getManagerPhone() {
        return managerPhone;
    }

    public void setManagerPhone(String managerPhone) {
        this.managerPhone = managerPhone;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "TbNewsmanager{" +
        "managerId = " + managerId +
        ", managerName = " + managerName +
        ", managerPwd = " + managerPwd +
        ", managerRole = " + managerRole +
        ", managerMail = " + managerMail +
        ", managerPhone = " + managerPhone +
        ", createDate = " + createDate +
        "}";
    }
}
