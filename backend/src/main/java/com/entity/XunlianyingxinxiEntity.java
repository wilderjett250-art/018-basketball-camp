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
 * 训练营信息
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("xunlianyingxinxi")
public class XunlianyingxinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public XunlianyingxinxiEntity() {

    }

    public XunlianyingxinxiEntity(T t) {
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

 /** 招收人数 */
    private String zhaoshourenshu;

 /** 详情 */
    private String xiangqing;

 /** 开放时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date kaifangshijian;

 /** 赞 */
    private Long thumbsupnum;

 /** 踩 */
    private Long crazilynum;

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
    public void setZhaoshourenshu(String zhaoshourenshu)
    {
        this.zhaoshourenshu = zhaoshourenshu;
    }
    public String getZhaoshourenshu()
    {
        return zhaoshourenshu;
    }
    public void setXiangqing(String xiangqing)
    {
        this.xiangqing = xiangqing;
    }
    public String getXiangqing()
    {
        return xiangqing;
    }
    public void setKaifangshijian(Date kaifangshijian)
    {
        this.kaifangshijian = kaifangshijian;
    }
    public Date getKaifangshijian()
    {
        return kaifangshijian;
    }
    public void setThumbsupnum(Long thumbsupnum)
    {
        this.thumbsupnum = thumbsupnum;
    }
    public Long getThumbsupnum()
    {
        return thumbsupnum;
    }
    public void setCrazilynum(Long crazilynum)
    {
        this.crazilynum = crazilynum;
    }
    public Long getCrazilynum()
    {
        return crazilynum;
    }

}
