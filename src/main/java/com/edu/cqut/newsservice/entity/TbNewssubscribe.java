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
 * @since 2023-09-30
 */
@TableName("tb_newssubscribe")
public class TbNewssubscribe implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻专栏订阅Id
     */
    @TableId(value = "nts_id", type = IdType.AUTO)
    private Integer ntsId;

    /**
     * 新闻用户Id
     */
    private Integer userId;

    /**
     * 新闻类别Id
     */
    private Integer typeId;

    public Integer getNtsId() {
        return ntsId;
    }

    public void setNtsId(Integer ntsId) {
        this.ntsId = ntsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "TbNewssubscribe{" +
        "ntsId = " + ntsId +
        ", userId = " + userId +
        ", typeId = " + typeId +
        "}";
    }
}
