package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.CrkDao;
import com.entity.CrkEntity;
import com.service.CrkService;
import com.entity.vo.CrkVO;
import com.entity.view.CrkView;

@Service("crkService")
public class CrkServiceImpl extends ServiceImpl<CrkDao, CrkEntity> implements CrkService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CrkEntity> page = this.selectPage(
                new Query<CrkEntity>(params).getPage(),
                new EntityWrapper<CrkEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<CrkEntity> wrapper) {
        Page<CrkView> page = new Query<CrkView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<CrkVO> selectListVO(Wrapper<CrkEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public CrkVO selectVO(Wrapper<CrkEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<CrkView> selectListView(Wrapper<CrkEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public CrkView selectView(Wrapper<CrkEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
