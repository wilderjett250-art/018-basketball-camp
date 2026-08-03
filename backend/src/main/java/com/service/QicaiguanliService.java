package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QicaiguanliEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QicaiguanliVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QicaiguanliView;


/**
 * 器材管理
 */
public interface QicaiguanliService extends IService<QicaiguanliEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<QicaiguanliVO> selectListVO(Wrapper<QicaiguanliEntity> wrapper);

    QicaiguanliVO selectVO(@Param("ew") Wrapper<QicaiguanliEntity> wrapper);

    List<QicaiguanliView> selectListView(Wrapper<QicaiguanliEntity> wrapper);

    QicaiguanliView selectView(@Param("ew") Wrapper<QicaiguanliEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<QicaiguanliEntity> wrapper);


}

