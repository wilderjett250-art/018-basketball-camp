package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XunlianxiangmuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XunlianxiangmuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XunlianxiangmuView;


/**
 * 训练项目
 */
public interface XunlianxiangmuService extends IService<XunlianxiangmuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<XunlianxiangmuVO> selectListVO(Wrapper<XunlianxiangmuEntity> wrapper);

    XunlianxiangmuVO selectVO(@Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);

    List<XunlianxiangmuView> selectListView(Wrapper<XunlianxiangmuEntity> wrapper);

    XunlianxiangmuView selectView(@Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<XunlianxiangmuEntity> wrapper);


}

