package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.KufangxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.KufangxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.KufangxinxiView;


/**
 * 库房信息
 *
 * @author 
 * @email 
 * @date 2021-09-23 16:09:29
 */
public interface KufangxinxiService extends IService<KufangxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<KufangxinxiVO> selectListVO(Wrapper<KufangxinxiEntity> wrapper);
   	
   	KufangxinxiVO selectVO(@Param("ew") Wrapper<KufangxinxiEntity> wrapper);
   	
   	List<KufangxinxiView> selectListView(Wrapper<KufangxinxiEntity> wrapper);
   	
   	KufangxinxiView selectView(@Param("ew") Wrapper<KufangxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<KufangxinxiEntity> wrapper);
   	
}

