package com.entity.view;

import com.entity.XunlianxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 训练项目
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2021-01-07 10:40:53
 */
@TableName("xunlianxiangmu")
public class XunlianxiangmuView  extends XunlianxiangmuEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public XunlianxiangmuView(){
    }

    public XunlianxiangmuView(XunlianxiangmuEntity xunlianxiangmuEntity){
        try {
            BeanUtils.copyProperties(this, xunlianxiangmuEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
