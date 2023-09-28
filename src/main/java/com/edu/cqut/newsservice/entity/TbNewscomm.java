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
 * @since 2023-09-27
 */
@TableName("tb_newscomm")
public class TbNewscomm implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 评论id
     */
    @TableId(value = "comm_id", type = IdType.AUTO)
    private Integer commId;

    /**
     * 评论内容
     */
    private String commContent;

    /**
     * 评论时间
     */
    private LocalDateTime createDate;

    /**
     * 新闻编号
     */
    private Integer newsfreId;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 发布状态(1为已发布,-1为禁看)
     */
    private Integer commStatus;

    public Integer getCommId() {
        return commId;
    }

    public void setCommId(Integer commId) {
        this.commId = commId;
    }

    public String getCommContent() {
        return commContent;
    }

    public void setCommContent(String commContent) {
        this.commContent = commContent;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getNewsfreId() {
        return newsfreId;
    }

    public void setNewsfreId(Integer newsfreId) {
        this.newsfreId = newsfreId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCommStatus() {
        return commStatus;
    }

    public void setCommStatus(Integer commStatus) {
        this.commStatus = commStatus;
    }

    @Override
    public String toString() {
        return "TbNewscomm{" +
        "commId = " + commId +
        ", commContent = " + commContent +
        ", createDate = " + createDate +
        ", newsfreId = " + newsfreId +
        ", userId = " + userId +
        ", commStatus = " + commStatus +
        "}";
    }
}
