package org.tartea.note.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * cos配置
 *
 * @Author: jiawenhao
 * @Date: 2022-06-21  22:16
 */
@TableName("t_cos_config")
public class CosConfig implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    /**
     * json字符串
     */
    private String config;

    /**
     * 已经使用的cos
     */
    private String usedCos;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getUsedCos() {
        return usedCos;
    }

    public void setUsedCos(String usedCos) {
        this.usedCos = usedCos;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
