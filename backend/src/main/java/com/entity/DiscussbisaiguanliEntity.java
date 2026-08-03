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
 * 比赛管理评论
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("discussbisaiguanli")
public class DiscussbisaiguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public DiscussbisaiguanliEntity() {

    }

    public DiscussbisaiguanliEntity(T t) {
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

 /** 关联表id */
    private Long refid;

 /** 用户id */
    private Long userid;

 /** 用户名 */
    private String nickname;

 /** 评论内容 */
    private String content;

 /** 回复内容 */
    private String reply;

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
    public void setRefid(Long refid)
    {
        this.refid = refid;
    }
    public Long getRefid()
    {
        return refid;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }
    public Long getUserid()
    {
        return userid;
    }
    public void setNickname(String nickname)
    {
        this.nickname = nickname;
    }
    public String getNickname()
    {
        return nickname;
    }
    public void setContent(String content)
    {
        this.content = content;
    }
    public String getContent()
    {
        return content;
    }
    public void setReply(String reply)
    {
        this.reply = reply;
    }
    public String getReply()
    {
        return reply;
    }

}
