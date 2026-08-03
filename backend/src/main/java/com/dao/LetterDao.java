package com.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.entity.LetterEntity;

import java.util.List;

public interface LetterDao extends BaseMapper<LetterEntity> {

    /**
     * 查询某个人的最新私信列表
     * @param receiver
     * @return
     */
    List<LetterEntity> selectLetterList(Long receiver);
}
