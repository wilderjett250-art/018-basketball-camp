package com.dao;

import com.entity.BisaiguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.BisaiguanliVO;
import com.entity.view.BisaiguanliView;


/**
 * 比赛管理
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface BisaiguanliDao extends BaseMapper<BisaiguanliEntity> {

    List<BisaiguanliVO> selectListVO(@Param("ew") Wrapper<BisaiguanliEntity> wrapper);

        BisaiguanliVO selectVO(@Param("ew") Wrapper<BisaiguanliEntity> wrapper);

    List<BisaiguanliView> selectListView(@Param("ew") Wrapper<BisaiguanliEntity> wrapper);

    List<BisaiguanliView> selectListView(Pagination page, @Param("ew") Wrapper<BisaiguanliEntity> wrapper);

        BisaiguanliView selectView(@Param("ew") Wrapper<BisaiguanliEntity> wrapper);
}
