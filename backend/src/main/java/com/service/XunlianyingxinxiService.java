package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XunlianyingxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XunlianyingxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XunlianyingxinxiView;


/**
 * 训练营信息
 */
public interface XunlianyingxinxiService extends IService<XunlianyingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<XunlianyingxinxiVO> selectListVO(Wrapper<XunlianyingxinxiEntity> wrapper);

    XunlianyingxinxiVO selectVO(@Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);

    List<XunlianyingxinxiView> selectListView(Wrapper<XunlianyingxinxiEntity> wrapper);

    XunlianyingxinxiView selectView(@Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<XunlianyingxinxiEntity> wrapper);


    Map<String, Double> recommend(Long userId, Integer num);
}

