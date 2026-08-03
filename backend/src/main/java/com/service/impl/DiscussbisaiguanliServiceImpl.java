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


import com.dao.DiscussbisaiguanliDao;
import com.entity.DiscussbisaiguanliEntity;
import com.service.DiscussbisaiguanliService;
import com.entity.vo.DiscussbisaiguanliVO;
import com.entity.view.DiscussbisaiguanliView;

@Service("discussbisaiguanliService")
public class DiscussbisaiguanliServiceImpl extends ServiceImpl<DiscussbisaiguanliDao, DiscussbisaiguanliEntity> implements DiscussbisaiguanliService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussbisaiguanliEntity> page = this.selectPage(
                new Query<DiscussbisaiguanliEntity>(params).getPage(),
                new EntityWrapper<DiscussbisaiguanliEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussbisaiguanliEntity> wrapper) {
        Page<DiscussbisaiguanliView> page = new Query<DiscussbisaiguanliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<DiscussbisaiguanliVO> selectListVO(Wrapper<DiscussbisaiguanliEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public DiscussbisaiguanliVO selectVO(Wrapper<DiscussbisaiguanliEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<DiscussbisaiguanliView> selectListView(Wrapper<DiscussbisaiguanliEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public DiscussbisaiguanliView selectView(Wrapper<DiscussbisaiguanliEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
