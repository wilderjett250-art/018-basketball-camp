package com.entity.vo;

import com.entity.XunlianxiangmuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 训练项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class XunlianxiangmuVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 项目名称 */
                                                                                                private String xiangmumingcheng;

                                /** 项目图片 */
                                                                                                private String xiangmutupian;

                                /** 教练姓名 */
                                                                                                private String jiaolianxingming;

                                /** 教练电话 */
                                                                                                private String jiaoliandianhua;

                                /** 训练人数 */
                                                                                                private String xunlianrenshu;

                                /** 训练时间 */
                                                                                                private Timestamp xunlianshijian;

                                /** 用户id */
                                                                                                private Long userid;

                                /** 是否审核 */
                                                                                                private String sfsh;

                                /** 审核回复 */
                                                                                                private String shhf;

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
                                                        public void setXiangmumingcheng(String xiangmumingcheng)
            {
                this.xiangmumingcheng = xiangmumingcheng;
            }

            public String getXiangmumingcheng()
            {
                return xiangmumingcheng;
            }
                                                        public void setXiangmutupian(String xiangmutupian)
            {
                this.xiangmutupian = xiangmutupian;
            }

            public String getXiangmutupian()
            {
                return xiangmutupian;
            }
                                                        public void setJiaolianxingming(String jiaolianxingming)
            {
                this.jiaolianxingming = jiaolianxingming;
            }

            public String getJiaolianxingming()
            {
                return jiaolianxingming;
            }
                                                        public void setJiaoliandianhua(String jiaoliandianhua)
            {
                this.jiaoliandianhua = jiaoliandianhua;
            }

            public String getJiaoliandianhua()
            {
                return jiaoliandianhua;
            }
                                                        public void setXunlianrenshu(String xunlianrenshu)
            {
                this.xunlianrenshu = xunlianrenshu;
            }

            public String getXunlianrenshu()
            {
                return xunlianrenshu;
            }
                                                        public void setXunlianshijian(Timestamp xunlianshijian)
            {
                this.xunlianshijian = xunlianshijian;
            }

            public Timestamp getXunlianshijian()
            {
                return xunlianshijian;
            }
                                                        public void setUserid(Long userid)
            {
                this.userid = userid;
            }

            public Long getUserid()
            {
                return userid;
            }
                                                        public void setSfsh(String sfsh)
            {
                this.sfsh = sfsh;
            }

            public String getSfsh()
            {
                return sfsh;
            }
                                                        public void setShhf(String shhf)
            {
                this.shhf = shhf;
            }

            public String getShhf()
            {
                return shhf;
            }
            
    }
