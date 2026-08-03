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
 * 预约管理
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("yuyueguanli")
public class YuyueguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public YuyueguanliEntity() {

    }

    public YuyueguanliEntity(T t) {
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

 /** 训练营名称 */
    private String xunlianyingmingcheng;

 /** 训练营图片 */
    private String xunlianyingtupian;

 /** 预约人 */
    private String yuyueren;

 /** 预约人电话 */
    private String yuyuerendianhua;

 /** 预约人年龄 */
    private String yuyuerennianling;

 /** 预约人性别 */
    private String yuyuerenxingbie;

 /** 预约时间 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp yuyueshijian;

 /** 用户id */
    private Long userid;

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
    public void setXunlianyingmingcheng(String xunlianyingmingcheng)
    {
        this.xunlianyingmingcheng = xunlianyingmingcheng;
    }
    public String getXunlianyingmingcheng()
    {
        return xunlianyingmingcheng;
    }
    public void setXunlianyingtupian(String xunlianyingtupian)
    {
        this.xunlianyingtupian = xunlianyingtupian;
    }
    public String getXunlianyingtupian()
    {
        return xunlianyingtupian;
    }
    public void setYuyueren(String yuyueren)
    {
        this.yuyueren = yuyueren;
    }
    public String getYuyueren()
    {
        return yuyueren;
    }
    public void setYuyuerendianhua(String yuyuerendianhua)
    {
        this.yuyuerendianhua = yuyuerendianhua;
    }
    public String getYuyuerendianhua()
    {
        return yuyuerendianhua;
    }
    public void setYuyuerennianling(String yuyuerennianling)
    {
        this.yuyuerennianling = yuyuerennianling;
    }
    public String getYuyuerennianling()
    {
        return yuyuerennianling;
    }
    public void setYuyuerenxingbie(String yuyuerenxingbie)
    {
        this.yuyuerenxingbie = yuyuerenxingbie;
    }
    public String getYuyuerenxingbie()
    {
        return yuyuerenxingbie;
    }
    public void setYuyueshijian(Timestamp yuyueshijian)
    {
        this.yuyueshijian = yuyueshijian;
    }
    public Timestamp getYuyueshijian()
    {
        return yuyueshijian;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }
    public Long getUserid()
    {
        return userid;
    }

}
