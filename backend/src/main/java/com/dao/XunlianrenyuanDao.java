package com.dao;

import com.entity.XunlianrenyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XunlianrenyuanVO;
import com.entity.view.XunlianrenyuanView;


/**
 * 训练人员
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface XunlianrenyuanDao extends BaseMapper<XunlianrenyuanEntity> {

    List<XunlianrenyuanVO> selectListVO(@Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);

        XunlianrenyuanVO selectVO(@Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);

    List<XunlianrenyuanView> selectListView(@Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);

    List<XunlianrenyuanView> selectListView(Pagination page, @Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);

        XunlianrenyuanView selectView(@Param("ew") Wrapper<XunlianrenyuanEntity> wrapper);
}
