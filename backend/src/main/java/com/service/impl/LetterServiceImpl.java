package com.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.LetterDao;
import com.entity.LetterEntity;
import com.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("letterService")
public class LetterServiceImpl extends ServiceImpl<LetterDao, LetterEntity> implements LetterService {
    @Autowired
    private LetterDao letterDao;

    @Override
    public List<LetterEntity> queryLetterList(Long receiver) {
        return letterDao.selectLetterList(receiver);
    }
}
