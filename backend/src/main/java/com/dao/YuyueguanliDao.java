package com.dao;

import com.entity.YuyueguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YuyueguanliVO;
import com.entity.view.YuyueguanliView;


/**
 * 预约管理
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface YuyueguanliDao extends BaseMapper<YuyueguanliEntity> {

    List<YuyueguanliVO> selectListVO(@Param("ew") Wrapper<YuyueguanliEntity> wrapper);

        YuyueguanliVO selectVO(@Param("ew") Wrapper<YuyueguanliEntity> wrapper);

    List<YuyueguanliView> selectListView(@Param("ew") Wrapper<YuyueguanliEntity> wrapper);

    List<YuyueguanliView> selectListView(Pagination page, @Param("ew") Wrapper<YuyueguanliEntity> wrapper);

        YuyueguanliView selectView(@Param("ew") Wrapper<YuyueguanliEntity> wrapper);
}
