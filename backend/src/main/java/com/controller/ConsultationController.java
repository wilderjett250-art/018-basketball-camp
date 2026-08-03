package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ConsultationEntity;
import com.service.ConsultationService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/consultation")
public class ConsultationController {

    @Autowired
    private ConsultationService consultationService;

    /**
     * 问诊医生与所有人的聊天历史
     */
    @GetMapping("/queryMsg")
    public R queryMsg(@RequestParam Map<String, Object> params, ConsultationEntity consultationEntity, HttpServletRequest request){
        Wrapper<ConsultationEntity> wrapper = new EntityWrapper<ConsultationEntity>();
        wrapper.eq("receiver", consultationEntity.getReceiver()).or().eq("sender", consultationEntity.getReceiver());
        List list = new ArrayList();
        list.add("send_time");
        wrapper.orderAsc(list);
        List<ConsultationEntity> consultationEntities = consultationService.selectList(wrapper);
        return R.ok().put("data", consultationEntities);
    }

    /**
     * 查询和某个人的聊天记录
     * @param params
     * @param consultationEntity
     * @param request
     * @return
     */
    @GetMapping("/querySomeBodyMsg")
    public R querySomeBodyMsg(@RequestParam Map<String, Object> params, ConsultationEntity consultationEntity, HttpServletRequest request) {
        Wrapper<ConsultationEntity> wrapper = new EntityWrapper<ConsultationEntity>();
        Long selfId = (Long) request.getSession().getAttribute("userId");
        wrapper.eq("receiver", selfId).eq("sender", consultationEntity.getSender())
                .or()
                .eq("receiver", consultationEntity.getSender()).eq("sender", selfId);
        List list = new ArrayList();
        list.add("send_time");
        wrapper.orderAsc(list);
        List<ConsultationEntity> consultationEntities = consultationService.selectList(wrapper);
        return R.ok().put("data", consultationEntities);
    }

    /**
     * 更新已读状态
     */
    @PostMapping("/update")
    public R update(@RequestBody ConsultationEntity consultationEntity, HttpServletRequest request) {
        Long selfId = (Long) request.getSession().getAttribute("userId");
        //根据发送者id更新已读状态
        Wrapper<ConsultationEntity> wrapper = new EntityWrapper<ConsultationEntity>();
        wrapper.eq("sender", consultationEntity.getSender());
        wrapper.eq("receiver", selfId);
        wrapper.eq("read_status", 0);
        consultationEntity.setReadStatus(1);
        consultationService.update(consultationEntity, wrapper);
        return R.ok();
    }

}
