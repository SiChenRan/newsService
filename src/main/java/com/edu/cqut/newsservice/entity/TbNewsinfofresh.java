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
@TableName("tb_newsinfofresh")
public class TbNewsinfofresh implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻id
     */
    @TableId(value = "newsfre_id", type = IdType.AUTO)
    private Integer newsfreId;

    /**
     * 新闻标题
     */
    private String newsTitle;

    /**
     * 新闻内容
     */
    private String newsContent;

    /**
     * 封面
     */
    private String newsCover;

    /**
     * 发布时间
     */
    private LocalDateTime createDate;

    /**
     * 类别id(外键)
     */
    private Integer typeId;

    /**
     * 新闻方id(外键)
     */
    private Integer userId;

    /**
     * 发布状态(0为待审核,1为已发布,-1为禁看,2为草稿)
     */
    private Integer newsStatus;

    public Integer getNewsfreId() {
        return newsfreId;
    }

    public void setNewsfreId(Integer newsfreId) {
        this.newsfreId = newsfreId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsCover() {
        return newsCover;
    }

    public void setNewsCover(String newsCover) {
        this.newsCover = newsCover;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNewsStatus() {
        return newsStatus;
    }

    public void setNewsStatus(Integer newsStatus) {
        this.newsStatus = newsStatus;
    }

    @Override
    public String toString() {
        return "TbNewsinfofresh{" +
        "newsfreId = " + newsfreId +
        ", newsTitle = " + newsTitle +
        ", newsContent = " + newsContent +
        ", newsCover = " + newsCover +
        ", createDate = " + createDate +
        ", typeId = " + typeId +
        ", userId = " + userId +
        ", newsStatus = " + newsStatus +
        "}";
    }
}
