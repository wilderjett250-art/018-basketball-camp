package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.CrkEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.CrkVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.CrkView;


/**
 * 出入库
 */
public interface CrkService extends IService<CrkEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<CrkVO> selectListVO(Wrapper<CrkEntity> wrapper);

    CrkVO selectVO(@Param("ew") Wrapper<CrkEntity> wrapper);

    List<CrkView> selectListView(Wrapper<CrkEntity> wrapper);

    CrkView selectView(@Param("ew") Wrapper<CrkEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<CrkEntity> wrapper);


}

