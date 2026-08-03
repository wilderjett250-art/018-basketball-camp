package com.dao;

import com.entity.QicaiguanliEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QicaiguanliVO;
import com.entity.view.QicaiguanliView;


/**
 * 器材管理
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface QicaiguanliDao extends BaseMapper<QicaiguanliEntity> {

    List<QicaiguanliVO> selectListVO(@Param("ew") Wrapper<QicaiguanliEntity> wrapper);

        QicaiguanliVO selectVO(@Param("ew") Wrapper<QicaiguanliEntity> wrapper);

    List<QicaiguanliView> selectListView(@Param("ew") Wrapper<QicaiguanliEntity> wrapper);

    List<QicaiguanliView> selectListView(Pagination page, @Param("ew") Wrapper<QicaiguanliEntity> wrapper);

        QicaiguanliView selectView(@Param("ew") Wrapper<QicaiguanliEntity> wrapper);
}
