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


import com.dao.DiscussxunlianyingxinxiDao;
import com.entity.DiscussxunlianyingxinxiEntity;
import com.service.DiscussxunlianyingxinxiService;
import com.entity.vo.DiscussxunlianyingxinxiVO;
import com.entity.view.DiscussxunlianyingxinxiView;

@Service("discussxunlianyingxinxiService")
public class DiscussxunlianyingxinxiServiceImpl extends ServiceImpl<DiscussxunlianyingxinxiDao, DiscussxunlianyingxinxiEntity> implements DiscussxunlianyingxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxunlianyingxinxiEntity> page = this.selectPage(
                new Query<DiscussxunlianyingxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussxunlianyingxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxunlianyingxinxiEntity> wrapper) {
        Page<DiscussxunlianyingxinxiView> page = new Query<DiscussxunlianyingxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<DiscussxunlianyingxinxiVO> selectListVO(Wrapper<DiscussxunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public DiscussxunlianyingxinxiVO selectVO(Wrapper<DiscussxunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<DiscussxunlianyingxinxiView> selectListView(Wrapper<DiscussxunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public DiscussxunlianyingxinxiView selectView(Wrapper<DiscussxunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
