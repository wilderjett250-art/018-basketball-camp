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


import com.dao.QicaiguanliDao;
import com.entity.QicaiguanliEntity;
import com.service.QicaiguanliService;
import com.entity.vo.QicaiguanliVO;
import com.entity.view.QicaiguanliView;

@Service("qicaiguanliService")
public class QicaiguanliServiceImpl extends ServiceImpl<QicaiguanliDao, QicaiguanliEntity> implements QicaiguanliService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QicaiguanliEntity> page = this.selectPage(
                new Query<QicaiguanliEntity>(params).getPage(),
                new EntityWrapper<QicaiguanliEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<QicaiguanliEntity> wrapper) {
        Page<QicaiguanliView> page = new Query<QicaiguanliView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<QicaiguanliVO> selectListVO(Wrapper<QicaiguanliEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public QicaiguanliVO selectVO(Wrapper<QicaiguanliEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<QicaiguanliView> selectListView(Wrapper<QicaiguanliEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public QicaiguanliView selectView(Wrapper<QicaiguanliEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

}
