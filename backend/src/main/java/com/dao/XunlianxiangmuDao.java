package com.dao;

import com.entity.XunlianxiangmuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XunlianxiangmuVO;
import com.entity.view.XunlianxiangmuView;


/**
 * 训练项目
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface XunlianxiangmuDao extends BaseMapper<XunlianxiangmuEntity> {

    List<XunlianxiangmuVO> selectListVO(@Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);

        XunlianxiangmuVO selectVO(@Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);

    List<XunlianxiangmuView> selectListView(@Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);

    List<XunlianxiangmuView> selectListView(Pagination page, @Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);

        XunlianxiangmuView selectView(@Param("ew") Wrapper<XunlianxiangmuEntity> wrapper);
}
