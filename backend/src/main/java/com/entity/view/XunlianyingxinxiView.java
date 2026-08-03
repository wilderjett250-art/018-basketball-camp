package com.entity.view;

import com.entity.XunlianyingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 训练营信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2021-01-07 10:40:53
 */
@TableName("xunlianyingxinxi")
public class XunlianyingxinxiView  extends XunlianyingxinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public XunlianyingxinxiView(){
    }

    public XunlianyingxinxiView(XunlianyingxinxiEntity xunlianyingxinxiEntity){
        try {
            BeanUtils.copyProperties(this, xunlianyingxinxiEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
