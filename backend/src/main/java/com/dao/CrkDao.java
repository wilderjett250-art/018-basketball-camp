package com.dao;

import com.entity.CrkEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.CrkVO;
import com.entity.view.CrkView;


/**
 * 出入库
 *
 * @author
 * @email
 * @date 2021-03-02 11:45:35
 */
public interface CrkDao extends BaseMapper<CrkEntity> {

    List<CrkVO> selectListVO(@Param("ew") Wrapper<CrkEntity> wrapper);

        CrkVO selectVO(@Param("ew") Wrapper<CrkEntity> wrapper);

    List<CrkView> selectListView(@Param("ew") Wrapper<CrkEntity> wrapper);

    List<CrkView> selectListView(Pagination page, @Param("ew") Wrapper<CrkEntity> wrapper);

        CrkView selectView(@Param("ew") Wrapper<CrkEntity> wrapper);
}
