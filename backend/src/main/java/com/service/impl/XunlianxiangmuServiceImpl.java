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


import com.dao.XunlianxiangmuDao;
import com.entity.XunlianxiangmuEntity;
import com.service.XunlianxiangmuService;
import com.entity.vo.XunlianxiangmuVO;
import com.entity.view.XunlianxiangmuView;

@Service("xunlianxiangmuService")
public class XunlianxiangmuServiceImpl extends ServiceImpl<XunlianxiangmuDao, XunlianxiangmuEntity> implements XunlianxiangmuService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XunlianxiangmuEntity> page = this.selectPage(
                new Query<XunlianxiangmuEntity>(params).getPage(),
                new EntityWrapper<XunlianxiangmuEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<XunlianxiangmuEntity> wrapper) {
        Page<XunlianxiangmuView> page = new Query<XunlianxiangmuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<XunlianxiangmuVO> selectListVO(Wrapper<XunlianxiangmuEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public XunlianxiangmuVO selectVO(Wrapper<XunlianxiangmuEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<XunlianxiangmuView> selectListView(Wrapper<XunlianxiangmuEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public XunlianxiangmuView selectView(Wrapper<XunlianxiangmuEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
