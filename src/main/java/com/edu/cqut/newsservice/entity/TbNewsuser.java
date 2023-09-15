package com.edu.cqut.newsservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Haibara
 * @since 2023-09-15
 */
@TableName("tb_newsuser")
public class TbNewsuser implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String userPwd;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 年龄
     */
    private Integer userAge;

    /**
     * F币数量
     */
    private Integer userCoin;

    /**
     * 发布状态(1为可正常登录,-1为禁止)
     */
    private Integer userStatus;

    /**
     * 新闻用户为0,申请新闻发布方为1,通过为2
     */
    private Integer publishRight;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 用户简介
     */
    private String userIntro;

    /**
     * 审核文件
     */
    private String userTxt;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public Integer getUserCoin() {
        return userCoin;
    }

    public void setUserCoin(Integer userCoin) {
        this.userCoin = userCoin;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public Integer getPublishRight() {
        return publishRight;
    }

    public void setPublishRight(Integer publishRight) {
        this.publishRight = publishRight;
    }

    public String getUserAvatar() {
        return userAvatar;
    }

    public void setUserAvatar(String userAvatar) {
        this.userAvatar = userAvatar;
    }

    public String getUserIntro() {
        return userIntro;
    }

    public void setUserIntro(String userIntro) {
        this.userIntro = userIntro;
    }

    public String getUserTxt() {
        return userTxt;
    }

    public void setUserTxt(String userTxt) {
        this.userTxt = userTxt;
    }

    @Override
    public String toString() {
        return "TbNewsuser{" +
        "userId = " + userId +
        ", userName = " + userName +
        ", userPwd = " + userPwd +
        ", userPhone = " + userPhone +
        ", userAge = " + userAge +
        ", userCoin = " + userCoin +
        ", userStatus = " + userStatus +
        ", publishRight = " + publishRight +
        ", userAvatar = " + userAvatar +
        ", userIntro = " + userIntro +
        ", userTxt = " + userTxt +
        "}";
    }
}
