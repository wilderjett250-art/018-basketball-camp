package com.entity.vo;

import com.entity.KufangxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
 

/**
 * 库房信息
 * 手机端接口返回实体辅助类 
 * （主要作用去除一些不必要的字段）
 * @author 
 * @email 
 * @date 2021-09-23 16:09:29
 */
public class KufangxinxiVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 总计
	 */
	
	private String zongji;
		
	/**
	 * 数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 进库时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jinkushijian;
				
	
	/**
	 * 设置：总计
	 */
	 
	public void setZongji(String zongji) {
		this.zongji = zongji;
	}
	
	/**
	 * 获取：总计
	 */
	public String getZongji() {
		return zongji;
	}
				
	
	/**
	 * 设置：数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：进库时间
	 */
	 
	public void setJinkushijian(Date jinkushijian) {
		this.jinkushijian = jinkushijian;
	}
	
	/**
	 * 获取：进库时间
	 */
	public Date getJinkushijian() {
		return jinkushijian;
	}
			
}
