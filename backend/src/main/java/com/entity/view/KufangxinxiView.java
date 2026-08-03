package com.entity.view;

import com.entity.KufangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 库房信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-09-23 16:09:29
 */
@TableName("kufangxinxi")
public class KufangxinxiView  extends KufangxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public KufangxinxiView(){
	}
 
 	public KufangxinxiView(KufangxinxiEntity kufangxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, kufangxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
