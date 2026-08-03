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
 * 器材管理
 * 数据库通用操作实体类（普通增删改查）
 */
@TableName("qicaiguanli")
public class QicaiguanliEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public QicaiguanliEntity() {

    }

    public QicaiguanliEntity(T t) {
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

 /** 器材名称 */
    private String qicaimingcheng;

 /** 器材图片 */
    private String qicaitupian;

 /** 器材用途 */
    private String qicaiyongtu;

 /** 库存 */
    private Long alllimittimes;

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
    public void setQicaimingcheng(String qicaimingcheng)
    {
        this.qicaimingcheng = qicaimingcheng;
    }
    public String getQicaimingcheng()
    {
        return qicaimingcheng;
    }
    public void setQicaitupian(String qicaitupian)
    {
        this.qicaitupian = qicaitupian;
    }
    public String getQicaitupian()
    {
        return qicaitupian;
    }
    public void setQicaiyongtu(String qicaiyongtu)
    {
        this.qicaiyongtu = qicaiyongtu;
    }
    public String getQicaiyongtu()
    {
        return qicaiyongtu;
    }
    public void setAlllimittimes(Long alllimittimes)
    {
        this.alllimittimes = alllimittimes;
    }
    public Long getAlllimittimes()
    {
        return alllimittimes;
    }

}
