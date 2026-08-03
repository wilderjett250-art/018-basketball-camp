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


import com.dao.BisaiguanliDao;
import com.entity.BisaiguanliEntity;
import com.service.BisaiguanliService;
import com.entity.vo.BisaiguanliVO;
import com.entity.view.BisaiguanliView;

@Service("bisaiguanliService")
public class BisaiguanliServiceImpl extends ServiceImpl<BisaiguanliDao, BisaiguanliEntity> implements BisaiguanliService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<BisaiguanliEntity> page = this.selectPage(
                new Query<BisaiguanliEntity>(params).getPage(),
                new EntityWrapper<BisaiguanliEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<BisaiguanliEntity> wrapper) {
        Page<BisaiguanliView> page = new Query<BisaiguanliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<BisaiguanliVO> selectListVO(Wrapper<BisaiguanliEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public BisaiguanliVO selectVO(Wrapper<BisaiguanliEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<BisaiguanliView> selectListView(Wrapper<BisaiguanliEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public BisaiguanliView selectView(Wrapper<BisaiguanliEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
