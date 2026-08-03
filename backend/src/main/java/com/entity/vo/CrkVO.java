package com.entity.vo;

import com.entity.CrkEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 出入库
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class CrkVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 关联表id */
                                                                                                private Long refid;

                                /** 出入库物品名称 */
                                                                                                private String name;

                                /** 出入库数量 */
                                                                                                private Long sl;

                                /** 出入库状态 */
                                                                                                private String crkzt;

                                                                public void setId(Long id)
            {
                this.id = id;
            }

            public Long getId()
            {
                return id;
            }
                                                        public void setAddtime(Timestamp addtime)
            {
                this.addtime = addtime;
            }

            public Timestamp getAddtime()
            {
                return addtime;
            }
                                                        public void setRefid(Long refid)
            {
                this.refid = refid;
            }

            public Long getRefid()
            {
                return refid;
            }
                                                        public void setName(String name)
            {
                this.name = name;
            }

            public String getName()
            {
                return name;
            }
                                                        public void setSl(Long sl)
            {
                this.sl = sl;
            }

            public Long getSl()
            {
                return sl;
            }
                                                        public void setCrkzt(String crkzt)
            {
                this.crkzt = crkzt;
            }

            public String getCrkzt()
            {
                return crkzt;
            }
            
    }
