package com.dao;

import com.entity.DiscussbisaiguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussbisaiguanliVO;
import com.entity.view.DiscussbisaiguanliView;


/**
 * 比赛管理评论
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface DiscussbisaiguanliDao extends BaseMapper<DiscussbisaiguanliEntity> {

    List<DiscussbisaiguanliVO> selectListVO(@Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);

        DiscussbisaiguanliVO selectVO(@Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);

    List<DiscussbisaiguanliView> selectListView(@Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);

    List<DiscussbisaiguanliView> selectListView(Pagination page, @Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);

        DiscussbisaiguanliView selectView(@Param("ew") Wrapper<DiscussbisaiguanliEntity> wrapper);
}
