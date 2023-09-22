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
 * @since 2023-09-22
 */
@TableName("tb_newscollect")
public class TbNewscollect implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 收藏id
     */
    @TableId(value = "collect_id", type = IdType.AUTO)
    private Integer collectId;

    /**
     * 新闻编号
     */
    private Integer newsId;

    /**
     * 用户编号
     */
    private Integer userId;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    public Integer getCollectId() {
        return collectId;
    }

    public void setCollectId(Integer collectId) {
        this.collectId = collectId;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
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
        return "TbNewscollect{" +
        "collectId = " + collectId +
        ", newsId = " + newsId +
        ", userId = " + userId +
        ", createDate = " + createDate +
        "}";
    }
}
