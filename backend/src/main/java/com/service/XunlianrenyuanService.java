package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XunlianrenyuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XunlianrenyuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XunlianrenyuanView;


/**
 * 训练人员
 */
public interface XunlianrenyuanService extends IService<XunlianrenyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<XunlianrenyuanVO> selectListVO(Wrapper<XunlianrenyuanEntity> wrapper);

    XunlianrenyuanVO selectVO(@Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);

    List<XunlianrenyuanView> selectListView(Wrapper<XunlianrenyuanEntity> wrapper);

    XunlianrenyuanView selectView(@Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<XunlianrenyuanEntity> wrapper);


}

