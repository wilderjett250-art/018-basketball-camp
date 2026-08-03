package com.entity.vo;

import com.entity.XunlianyingxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 训练营信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class XunlianyingxinxiVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 训练营名称 */
                                                                                                private String xunlianyingmingcheng;

                                /** 训练营图片 */
                                                                                                private String xunlianyingtupian;

                                /** 招收人数 */
                                                                                                private String zhaoshourenshu;

                                /** 详情 */
                                                                                                private String xiangqing;

                                /** 开放时间 */
                                                                            @JsonFormat(pattern = "yyyy-MM-dd")
                                    private Date kaifangshijian;

                                /** 赞 */
                                                                                                private Long thumbsupnum;

                                /** 踩 */
                                                                                                private Long crazilynum;

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
                                                        public void setZhaoshourenshu(String zhaoshourenshu)
            {
                this.zhaoshourenshu = zhaoshourenshu;
            }

            public String getZhaoshourenshu()
            {
                return zhaoshourenshu;
            }
                                                        public void setXiangqing(String xiangqing)
            {
                this.xiangqing = xiangqing;
            }

            public String getXiangqing()
            {
                return xiangqing;
            }
                                                        public void setKaifangshijian(Date kaifangshijian)
            {
                this.kaifangshijian = kaifangshijian;
            }

            public Date getKaifangshijian()
            {
                return kaifangshijian;
            }
                                                        public void setThumbsupnum(Long thumbsupnum)
            {
                this.thumbsupnum = thumbsupnum;
            }

            public Long getThumbsupnum()
            {
                return thumbsupnum;
            }
                                                        public void setCrazilynum(Long crazilynum)
            {
                this.crazilynum = crazilynum;
            }

            public Long getCrazilynum()
            {
                return crazilynum;
            }
            
    }
