package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YuyueguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YuyueguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyueguanliView;


/**
 * 预约管理
 */
public interface YuyueguanliService extends IService<YuyueguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<YuyueguanliVO> selectListVO(Wrapper<YuyueguanliEntity> wrapper);

    YuyueguanliVO selectVO(@Param("ew") Wrapper<YuyueguanliEntity> wrapper);

    List<YuyueguanliView> selectListView(Wrapper<YuyueguanliEntity> wrapper);

    YuyueguanliView selectView(@Param("ew") Wrapper<YuyueguanliEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<YuyueguanliEntity> wrapper);


}

