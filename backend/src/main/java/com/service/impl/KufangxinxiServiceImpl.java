package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.KufangxinxiDao;
import com.entity.KufangxinxiEntity;
import com.service.KufangxinxiService;
import com.entity.vo.KufangxinxiVO;
import com.entity.view.KufangxinxiView;

@Service("kufangxinxiService")
public class KufangxinxiServiceImpl extends ServiceImpl<KufangxinxiDao, KufangxinxiEntity> implements KufangxinxiService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<KufangxinxiEntity> page = this.selectPage(
                new Query<KufangxinxiEntity>(params).getPage(),
                new EntityWrapper<KufangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<KufangxinxiEntity> wrapper) {
		  Page<KufangxinxiView> page =new Query<KufangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<KufangxinxiVO> selectListVO(Wrapper<KufangxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public KufangxinxiVO selectVO(Wrapper<KufangxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<KufangxinxiView> selectListView(Wrapper<KufangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public KufangxinxiView selectView(Wrapper<KufangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
