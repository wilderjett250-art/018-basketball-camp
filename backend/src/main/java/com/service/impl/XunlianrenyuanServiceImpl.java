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


import com.dao.XunlianrenyuanDao;
import com.entity.XunlianrenyuanEntity;
import com.service.XunlianrenyuanService;
import com.entity.vo.XunlianrenyuanVO;
import com.entity.view.XunlianrenyuanView;

@Service("xunlianrenyuanService")
public class XunlianrenyuanServiceImpl extends ServiceImpl<XunlianrenyuanDao, XunlianrenyuanEntity> implements XunlianrenyuanService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XunlianrenyuanEntity> page = this.selectPage(
                new Query<XunlianrenyuanEntity>(params).getPage(),
                new EntityWrapper<XunlianrenyuanEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<XunlianrenyuanEntity> wrapper) {
        Page<XunlianrenyuanView> page = new Query<XunlianrenyuanView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<XunlianrenyuanVO> selectListVO(Wrapper<XunlianrenyuanEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public XunlianrenyuanVO selectVO(Wrapper<XunlianrenyuanEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<XunlianrenyuanView> selectListView(Wrapper<XunlianrenyuanEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public XunlianrenyuanView selectView(Wrapper<XunlianrenyuanEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
