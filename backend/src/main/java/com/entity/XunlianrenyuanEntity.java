package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;
import java.math.BigDecimal;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 训练人员
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("xunlianrenyuan")
public class XunlianrenyuanEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public XunlianrenyuanEntity() {

    }

    public XunlianrenyuanEntity(T t) {
        try {
            BeanUtils.copyProperties(this, t);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 /** 主键 */
    private Long id;

 /** 创建时间 */
@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
@DateTimeFormat
    private Timestamp addtime;

 /** 账号 */
    private String zhanghao;

 /** 密码 */
    private String mima;

 /** 手机号 */
    private String shoujihao;

    public void setId(Long id)
    {
        this.id = id;
    }
    public Long getId()
    {
        return id;
    }
    public void setAddtime(Timestamp addtime)
    {
        this.addtime = addtime;
    }
    public Timestamp getAddtime()
    {
        return addtime;
    }
    public void setZhanghao(String zhanghao)
    {
        this.zhanghao = zhanghao;
    }
    public String getZhanghao()
    {
        return zhanghao;
    }
    public void setMima(String mima)
    {
        this.mima = mima;
    }
    public String getMima()
    {
        return mima;
    }
    public void setShoujihao(String shoujihao)
    {
        this.shoujihao = shoujihao;
    }
    public String getShoujihao()
    {
        return shoujihao;
    }

}
