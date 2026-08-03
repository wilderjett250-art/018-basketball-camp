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
 * 训练项目
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("xunlianxiangmu")
public class XunlianxiangmuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public XunlianxiangmuEntity() {

    }

    public XunlianxiangmuEntity(T t) {
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

 /** 项目名称 */
    private String xiangmumingcheng;

 /** 项目图片 */
    private String xiangmutupian;

 /** 教练姓名 */
    private String jiaolianxingming;

 /** 教练电话 */
    private String jiaoliandianhua;

 /** 训练人数 */
    private String xunlianrenshu;

 /** 训练时间 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp xunlianshijian;

 /** 用户id */
    private Long userid;

 /** 是否审核 */
    private String sfsh;

 /** 审核回复 */
    private String shhf;

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
    public void setXiangmumingcheng(String xiangmumingcheng)
    {
        this.xiangmumingcheng = xiangmumingcheng;
    }
    public String getXiangmumingcheng()
    {
        return xiangmumingcheng;
    }
    public void setXiangmutupian(String xiangmutupian)
    {
        this.xiangmutupian = xiangmutupian;
    }
    public String getXiangmutupian()
    {
        return xiangmutupian;
    }
    public void setJiaolianxingming(String jiaolianxingming)
    {
        this.jiaolianxingming = jiaolianxingming;
    }
    public String getJiaolianxingming()
    {
        return jiaolianxingming;
    }
    public void setJiaoliandianhua(String jiaoliandianhua)
    {
        this.jiaoliandianhua = jiaoliandianhua;
    }
    public String getJiaoliandianhua()
    {
        return jiaoliandianhua;
    }
    public void setXunlianrenshu(String xunlianrenshu)
    {
        this.xunlianrenshu = xunlianrenshu;
    }
    public String getXunlianrenshu()
    {
        return xunlianrenshu;
    }
    public void setXunlianshijian(Timestamp xunlianshijian)
    {
        this.xunlianshijian = xunlianshijian;
    }
    public Timestamp getXunlianshijian()
    {
        return xunlianshijian;
    }
    public void setUserid(Long userid)
    {
        this.userid = userid;
    }
    public Long getUserid()
    {
        return userid;
    }
    public void setSfsh(String sfsh)
    {
        this.sfsh = sfsh;
    }
    public String getSfsh()
    {
        return sfsh;
    }
    public void setShhf(String shhf)
    {
        this.shhf = shhf;
    }
    public String getShhf()
    {
        return shhf;
    }

}
