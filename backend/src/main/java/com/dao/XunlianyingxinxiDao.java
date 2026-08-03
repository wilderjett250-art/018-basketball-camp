package com.dao;

import com.entity.XunlianyingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XunlianyingxinxiVO;
import com.entity.view.XunlianyingxinxiView;


/**
 * 训练营信息
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface XunlianyingxinxiDao extends BaseMapper<XunlianyingxinxiEntity> {

    List<XunlianyingxinxiVO> selectListVO(@Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);

        XunlianyingxinxiVO selectVO(@Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);

    List<XunlianyingxinxiView> selectListView(@Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);

    List<XunlianyingxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);

        XunlianyingxinxiView selectView(@Param("ew") Wrapper<XunlianyingxinxiEntity> wrapper);
}
