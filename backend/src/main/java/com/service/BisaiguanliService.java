package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.BisaiguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.BisaiguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.BisaiguanliView;


/**
 * 比赛管理
 */
public interface BisaiguanliService extends IService<BisaiguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<BisaiguanliVO> selectListVO(Wrapper<BisaiguanliEntity> wrapper);

    BisaiguanliVO selectVO(@Param("ew") Wrapper<BisaiguanliEntity> wrapper);

    List<BisaiguanliView> selectListView(Wrapper<BisaiguanliEntity> wrapper);

    BisaiguanliView selectView(@Param("ew") Wrapper<BisaiguanliEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<BisaiguanliEntity> wrapper);


}

