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
 * 比赛管理
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("bisaiguanli")
public class BisaiguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public BisaiguanliEntity() {

    }

    public BisaiguanliEntity(T t) {
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

 /** 场地名称 */
    private String changdimingcheng;

 /** 场地图片 */
    private String changditupian;

 /** 场地大小 */
    private String changdidaxiao;

 /** 场地人数 */
    private String changdirenshu;

 /** 详情 */
    private String xiangqing;

 /** 比赛时间 */
@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp bisaishijian;

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
    public void setChangdimingcheng(String changdimingcheng)
    {
        this.changdimingcheng = changdimingcheng;
    }
    public String getChangdimingcheng()
    {
        return changdimingcheng;
    }
    public void setChangditupian(String changditupian)
    {
        this.changditupian = changditupian;
    }
    public String getChangditupian()
    {
        return changditupian;
    }
    public void setChangdidaxiao(String changdidaxiao)
    {
        this.changdidaxiao = changdidaxiao;
    }
    public String getChangdidaxiao()
    {
        return changdidaxiao;
    }
    public void setChangdirenshu(String changdirenshu)
    {
        this.changdirenshu = changdirenshu;
    }
    public String getChangdirenshu()
    {
        return changdirenshu;
    }
    public void setXiangqing(String xiangqing)
    {
        this.xiangqing = xiangqing;
    }
    public String getXiangqing()
    {
        return xiangqing;
    }
    public void setBisaishijian(Timestamp bisaishijian)
    {
        this.bisaishijian = bisaishijian;
    }
    public Timestamp getBisaishijian()
    {
        return bisaishijian;
    }

}
