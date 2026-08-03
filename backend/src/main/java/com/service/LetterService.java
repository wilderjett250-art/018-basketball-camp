package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.entity.LetterEntity;

import java.util.List;

public interface LetterService extends IService<LetterEntity> {

    /**
     * 查询某个人的最新私信列表
     * @param receiver
     * @return
     */
    List<LetterEntity> queryLetterList(Long receiver);
}
