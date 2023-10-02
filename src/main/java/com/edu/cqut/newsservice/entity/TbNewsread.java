package com.edu.cqut.newsservice.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2023-10-01
 */
@TableName("tb_newsread")
public class TbNewsread implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 阅读id
     */
    @TableId(value = "read_id", type = IdType.AUTO)
    private Integer readId;

    /**
     * 新闻编号
     */
    private Integer newsfreId;

    /**
     * 用户编号
     */
    private Integer userId;

    @TableField(exist = false)
    private TbNewsinfofresh news;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    public TbNewsinfofresh getNews() {
        return news;
    }

    public void setNews(TbNewsinfofresh news) {
        this.news = news;
    }

    public Integer getReadId() {
        return readId;
    }

    public void setReadId(Integer readId) {
        this.readId = readId;
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

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "TbNewsread{" +
                "readId=" + readId +
                ", newsfreId=" + newsfreId +
                ", userId=" + userId +
                ", news=" + news +
                ", createDate=" + createDate +
                '}';
    }
}
