package com.entity.vo;

import com.entity.QicaiguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 器材管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class QicaiguanliVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 器材名称 */
                                                                                                private String qicaimingcheng;

                                /** 器材图片 */
                                                                                                private String qicaitupian;

                                /** 器材用途 */
                                                                                                private String qicaiyongtu;

                                /** 库存 */
                                                                                                private Long alllimittimes;

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
                                                        public void setQicaimingcheng(String qicaimingcheng)
            {
                this.qicaimingcheng = qicaimingcheng;
            }

            public String getQicaimingcheng()
            {
                return qicaimingcheng;
            }
                                                        public void setQicaitupian(String qicaitupian)
            {
                this.qicaitupian = qicaitupian;
            }

            public String getQicaitupian()
            {
                return qicaitupian;
            }
                                                        public void setQicaiyongtu(String qicaiyongtu)
            {
                this.qicaiyongtu = qicaiyongtu;
            }

            public String getQicaiyongtu()
            {
                return qicaiyongtu;
            }
                                                        public void setAlllimittimes(Long alllimittimes)
            {
                this.alllimittimes = alllimittimes;
            }

            public Long getAlllimittimes()
            {
                return alllimittimes;
            }
            
    }
