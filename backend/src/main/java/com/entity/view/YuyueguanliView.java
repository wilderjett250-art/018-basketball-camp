package com.entity.view;

import com.entity.YuyueguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 预约管理
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2021-01-07 10:40:53
 */
@TableName("yuyueguanli")
public class YuyueguanliView  extends YuyueguanliEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public YuyueguanliView(){
    }

    public YuyueguanliView(YuyueguanliEntity yuyueguanliEntity){
        try {
            BeanUtils.copyProperties(this, yuyueguanliEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
