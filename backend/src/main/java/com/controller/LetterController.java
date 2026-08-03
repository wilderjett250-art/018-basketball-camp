package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.ConsultationEntity;
import com.entity.LetterEntity;
import com.service.LetterService;
import com.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/letter")
public class LetterController {

    @Autowired
    private LetterService letterService;

    /**
     * 查询所有人的私信
     */
    @GetMapping("/queryMsg")
    public R queryMsg(@RequestParam Map<String, Object> params, LetterEntity LetterEntity, HttpServletRequest request){
        Wrapper<LetterEntity> wrapper = new EntityWrapper<LetterEntity>();
        wrapper.eq("receiver", LetterEntity.getReceiver()).or().eq("sender", LetterEntity.getReceiver());
        List list = new ArrayList();
        list.add("send_time");
        wrapper.orderAsc(list);
        List<LetterEntity> letterEntities = letterService.selectList(wrapper);
        return R.ok().put("data", letterEntities);
    }

    /**
     * 查询和某个人的私信
     * @param params
     * @param LetterEntity
     * @param request
     * @return
     */
    @GetMapping("/querySomeBodyMsg")
    public R querySomeBodyMsg(@RequestParam Map<String, Object> params, LetterEntity LetterEntity, HttpServletRequest request) {
        Wrapper<LetterEntity> wrapper = new EntityWrapper<LetterEntity>();
        Long selfId = (Long) request.getSession().getAttribute("userId");
        wrapper.eq("receiver", selfId).eq("sender", LetterEntity.getSender())
                .or()
                .eq("receiver", LetterEntity.getSender()).eq("sender", selfId);
        List list = new ArrayList();
        list.add("send_time");
        wrapper.orderAsc(list);
        List<LetterEntity> letterEntities = letterService.selectList(wrapper);
        return R.ok().put("data", letterEntities);
    }

    /**
     * 更新已读状态
     */
    @PostMapping("/update")
    public R update(@RequestBody LetterEntity LetterEntity, HttpServletRequest request) {
        Long selfId = (Long) request.getSession().getAttribute("userId");
        //根据发送者id更新已读状态
        Wrapper<LetterEntity> wrapper = new EntityWrapper<LetterEntity>();
        wrapper.eq("sender", LetterEntity.getSender());
        wrapper.eq("receiver", selfId);
        wrapper.eq("read_status", 0);
        LetterEntity.setReadStatus(1);
        letterService.update(LetterEntity, wrapper);
        return R.ok();
    }

    /**
     * 查询某人的私信列表
     */
    @GetMapping("/queryLetterList")
    public R queryLetterList(@RequestParam Map<String, Object> params, HttpServletRequest request) {
        Long selfId = (Long) request.getSession().getAttribute("userId");
        List<LetterEntity> letterEntities = letterService.queryLetterList(selfId);
        return R.ok().put("data", letterEntities);
    }


}
