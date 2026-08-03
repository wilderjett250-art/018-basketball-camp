package com.dao;

import com.entity.KufangxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.KufangxinxiVO;
import com.entity.view.KufangxinxiView;


/**
 * 库房信息
 * 
 * @author 
 * @email 
 * @date 2021-09-23 16:09:29
 */
public interface KufangxinxiDao extends BaseMapper<KufangxinxiEntity> {
	
	List<KufangxinxiVO> selectListVO(@Param("ew") Wrapper<KufangxinxiEntity> wrapper);
	
	KufangxinxiVO selectVO(@Param("ew") Wrapper<KufangxinxiEntity> wrapper);
	
	List<KufangxinxiView> selectListView(@Param("ew") Wrapper<KufangxinxiEntity> wrapper);

	List<KufangxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<KufangxinxiEntity> wrapper);
	
	KufangxinxiView selectView(@Param("ew") Wrapper<KufangxinxiEntity> wrapper);
	
}
