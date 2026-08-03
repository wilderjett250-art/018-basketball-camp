package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussbisaiguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussbisaiguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussbisaiguanliView;


/**
 * 比赛管理评论
 */
public interface DiscussbisaiguanliService extends IService<DiscussbisaiguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<DiscussbisaiguanliVO> selectListVO(Wrapper<DiscussbisaiguanliEntity> wrapper);

    DiscussbisaiguanliVO selectVO(@Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);

    List<DiscussbisaiguanliView> selectListView(Wrapper<DiscussbisaiguanliEntity> wrapper);

    DiscussbisaiguanliView selectView(@Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussbisaiguanliEntity> wrapper);


}

