package com.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.ConsultationDao;
import com.entity.ConsultationEntity;
import com.service.ConsultationService;
import org.springframework.stereotype.Service;

@Service("consultationService")
public class ConsultationServiceImpl extends ServiceImpl<ConsultationDao, ConsultationEntity> implements ConsultationService {
}
