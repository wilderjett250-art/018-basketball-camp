package com.entity.vo;

import com.entity.YuyueguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 预约管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class YuyueguanliVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 训练营名称 */
                                                                                                private String xunlianyingmingcheng;

                                /** 训练营图片 */
                                                                                                private String xunlianyingtupian;

                                /** 预约人 */
                                                                                                private String yuyueren;

                                /** 预约人电话 */
                                                                                                private String yuyuerendianhua;

                                /** 预约人年龄 */
                                                                                                private String yuyuerennianling;

                                /** 预约人性别 */
                                                                                                private String yuyuerenxingbie;

                                /** 预约时间 */
                                                                                                private Timestamp yuyueshijian;

                                /** 用户id */
                                                                                                private Long userid;

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
                                                        public void setXunlianyingmingcheng(String xunlianyingmingcheng)
            {
                this.xunlianyingmingcheng = xunlianyingmingcheng;
            }

            public String getXunlianyingmingcheng()
            {
                return xunlianyingmingcheng;
            }
                                                        public void setXunlianyingtupian(String xunlianyingtupian)
            {
                this.xunlianyingtupian = xunlianyingtupian;
            }

            public String getXunlianyingtupian()
            {
                return xunlianyingtupian;
            }
                                                        public void setYuyueren(String yuyueren)
            {
                this.yuyueren = yuyueren;
            }

            public String getYuyueren()
            {
                return yuyueren;
            }
                                                        public void setYuyuerendianhua(String yuyuerendianhua)
            {
                this.yuyuerendianhua = yuyuerendianhua;
            }

            public String getYuyuerendianhua()
            {
                return yuyuerendianhua;
            }
                                                        public void setYuyuerennianling(String yuyuerennianling)
            {
                this.yuyuerennianling = yuyuerennianling;
            }

            public String getYuyuerennianling()
            {
                return yuyuerennianling;
            }
                                                        public void setYuyuerenxingbie(String yuyuerenxingbie)
            {
                this.yuyuerenxingbie = yuyuerenxingbie;
            }

            public String getYuyuerenxingbie()
            {
                return yuyuerenxingbie;
            }
                                                        public void setYuyueshijian(Timestamp yuyueshijian)
            {
                this.yuyueshijian = yuyueshijian;
            }

            public Timestamp getYuyueshijian()
            {
                return yuyueshijian;
            }
                                                        public void setUserid(Long userid)
            {
                this.userid = userid;
            }

            public Long getUserid()
            {
                return userid;
            }
            
    }
