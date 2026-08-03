package com.entity.vo;

import com.entity.BisaiguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 比赛管理
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class BisaiguanliVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 场地名称 */
                                                                                                private String changdimingcheng;

                                /** 场地图片 */
                                                                                                private String changditupian;

                                /** 场地大小 */
                                                                                                private String changdidaxiao;

                                /** 场地人数 */
                                                                                                private String changdirenshu;

                                /** 详情 */
                                                                                                private String xiangqing;

                                /** 比赛时间 */
                                                                                                private Timestamp bisaishijian;

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
                                                        public void setChangdimingcheng(String changdimingcheng)
            {
                this.changdimingcheng = changdimingcheng;
            }

            public String getChangdimingcheng()
            {
                return changdimingcheng;
            }
                                                        public void setChangditupian(String changditupian)
            {
                this.changditupian = changditupian;
            }

            public String getChangditupian()
            {
                return changditupian;
            }
                                                        public void setChangdidaxiao(String changdidaxiao)
            {
                this.changdidaxiao = changdidaxiao;
            }

            public String getChangdidaxiao()
            {
                return changdidaxiao;
            }
                                                        public void setChangdirenshu(String changdirenshu)
            {
                this.changdirenshu = changdirenshu;
            }

            public String getChangdirenshu()
            {
                return changdirenshu;
            }
                                                        public void setXiangqing(String xiangqing)
            {
                this.xiangqing = xiangqing;
            }

            public String getXiangqing()
            {
                return xiangqing;
            }
                                                        public void setBisaishijian(Timestamp bisaishijian)
            {
                this.bisaishijian = bisaishijian;
            }

            public Timestamp getBisaishijian()
            {
                return bisaishijian;
            }
            
    }
