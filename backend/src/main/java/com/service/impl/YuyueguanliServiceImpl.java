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


import com.dao.YuyueguanliDao;
import com.entity.YuyueguanliEntity;
import com.service.YuyueguanliService;
import com.entity.vo.YuyueguanliVO;
import com.entity.view.YuyueguanliView;

@Service("yuyueguanliService")
public class YuyueguanliServiceImpl extends ServiceImpl<YuyueguanliDao, YuyueguanliEntity> implements YuyueguanliService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YuyueguanliEntity> page = this.selectPage(
                new Query<YuyueguanliEntity>(params).getPage(),
                new EntityWrapper<YuyueguanliEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<YuyueguanliEntity> wrapper) {
        Page<YuyueguanliView> page = new Query<YuyueguanliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<YuyueguanliVO> selectListVO(Wrapper<YuyueguanliEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public YuyueguanliVO selectVO(Wrapper<YuyueguanliEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<YuyueguanliView> selectListView(Wrapper<YuyueguanliEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public YuyueguanliView selectView(Wrapper<YuyueguanliEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
