package com.entity.vo;

import com.entity.XunlianrenyuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 训练人员
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class XunlianrenyuanVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 账号 */
                                                                                                private String zhanghao;

                                /** 密码 */
                                                                                                private String mima;

                                /** 手机号 */
                                                                                                private String shoujihao;

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
                                                        public void setZhanghao(String zhanghao)
            {
                this.zhanghao = zhanghao;
            }

            public String getZhanghao()
            {
                return zhanghao;
            }
                                                        public void setMima(String mima)
            {
                this.mima = mima;
            }

            public String getMima()
            {
                return mima;
            }
                                                        public void setShoujihao(String shoujihao)
            {
                this.shoujihao = shoujihao;
            }

            public String getShoujihao()
            {
                return shoujihao;
            }
            
    }
