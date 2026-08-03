package com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.service.StoreupService;
import com.utils.UserBasedCollaborativeFiltering;
import java.util.*;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.XunlianyingxinxiDao;
import com.entity.XunlianyingxinxiEntity;
import com.service.XunlianyingxinxiService;
import com.entity.vo.XunlianyingxinxiVO;
import com.entity.view.XunlianyingxinxiView;

@Service("xunlianyingxinxiService")
public class XunlianyingxinxiServiceImpl extends ServiceImpl<XunlianyingxinxiDao, XunlianyingxinxiEntity> implements XunlianyingxinxiService {

    @Autowired
    private StoreupService storeupService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XunlianyingxinxiEntity> page = this.selectPage(
                new Query<XunlianyingxinxiEntity>(params).getPage(),
                new EntityWrapper<XunlianyingxinxiEntity>()
        );
        return new PageUtils(page);
    }

    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<XunlianyingxinxiEntity> wrapper) {
        Page<XunlianyingxinxiView> page = new Query<XunlianyingxinxiView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page, wrapper));
        PageUtils pageUtil = new PageUtils(page);
        return pageUtil;
    }

    @Override
    public List<XunlianyingxinxiVO> selectListVO(Wrapper<XunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectListVO(wrapper);
    }

    @Override
    public XunlianyingxinxiVO selectVO(Wrapper<XunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectVO(wrapper);
    }

    @Override
    public List<XunlianyingxinxiView> selectListView(Wrapper<XunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectListView(wrapper);
    }

    @Override
    public XunlianyingxinxiView selectView(Wrapper<XunlianyingxinxiEntity> wrapper) {
        return baseMapper.selectView(wrapper);
    }

    @Override
    public Map<String, Double> recommend(Long userId, Integer num) {
        // 创建用户-物品收藏矩阵
        Map<String, Set<String>> userItemCollections = new HashMap<>();
        List<Map<String, String>> maps = storeupService.getCollected();
        for (Map<String, String> map : maps) {
            userItemCollections.put(String.valueOf(map.get("userid")), new HashSet<>(Arrays.asList(map.get("items").split(","))));
        }
        UserBasedCollaborativeFiltering cf = new UserBasedCollaborativeFiltering(userItemCollections);
        // 为目标用户推荐物品
        Map<String, Double> recommendations = cf.recommendItems(String.valueOf(userId), num);
        // 输出推荐结果
        System.err.println("基于用户收藏的推荐 用户ID:" + userId);
        for (Map.Entry<String, Double> entry : recommendations.entrySet()) {
            System.err.println("商品ID: " + entry.getKey() + ", 分数: " + entry.getValue());
        }
        return recommendations;
    }
}
