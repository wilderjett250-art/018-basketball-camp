package com.dao;

import com.entity.DiscussxunlianyingxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxunlianyingxinxiVO;
import com.entity.view.DiscussxunlianyingxinxiView;


/**
 * 训练营信息评论
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface DiscussxunlianyingxinxiDao extends BaseMapper<DiscussxunlianyingxinxiEntity> {

    List<DiscussxunlianyingxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

        DiscussxunlianyingxinxiVO selectVO(@Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

    List<DiscussxunlianyingxinxiView> selectListView(@Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

    List<DiscussxunlianyingxinxiView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

        DiscussxunlianyingxinxiView selectView(@Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);
}
