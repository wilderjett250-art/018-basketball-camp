package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxunlianyingxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxunlianyingxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxunlianyingxinxiView;


/**
 * 训练营信息评论
 */
public interface DiscussxunlianyingxinxiService extends IService<DiscussxunlianyingxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<DiscussxunlianyingxinxiVO> selectListVO(Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

    DiscussxunlianyingxinxiVO selectVO(@Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

    List<DiscussxunlianyingxinxiView> selectListView(Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

    DiscussxunlianyingxinxiView selectView(@Param("ew") Wrapper<DiscussxunlianyingxinxiEntity> wrapper);

    PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxunlianyingxinxiEntity> wrapper);


}

