package com.entity.view;

import com.entity.CrkEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;


/**
 * 出入库
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author
 * @email
 * @date 2021-01-07 10:40:53
 */
@TableName("crk")
public class CrkView  extends CrkEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    public CrkView(){
    }

    public CrkView(CrkEntity crkEntity){
        try {
            BeanUtils.copyProperties(this, crkEntity);
        } catch (IllegalAccessException | InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
