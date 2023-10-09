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
 * @since 2023-10-09
 */
@TableName("tb_newssum")
public class TbNewssum implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻总数id
     */
    @TableId(value = "news_sum_id", type = IdType.AUTO)
    private Integer newsSumId;

    /**
     * 新闻总数
     */
    private Integer newsCount;

    public Integer getNewsSumId() {
        return newsSumId;
    }

    public void setNewsSumId(Integer newsSumId) {
        this.newsSumId = newsSumId;
    }

    public Integer getNewsCount() {
        return newsCount;
    }

    public void setNewsCount(Integer newsCount) {
        this.newsCount = newsCount;
    }

    @Override
    public String toString() {
        return "TbNewssum{" +
        "newsSumId = " + newsSumId +
        ", newsCount = " + newsCount +
        "}";
    }
}
