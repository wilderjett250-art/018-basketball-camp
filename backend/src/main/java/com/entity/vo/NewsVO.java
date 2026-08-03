package com.entity.vo;

import com.entity.NewsEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 系统公告
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class NewsVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 标题 */
                                                                                                private String title;

                                /** 简介 */
                                                                                                private String introduction;

                                /** 系统公告图片 */
                                                                                                private String picture;

                                /** 内容 */
                                                                                                private String content;

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
                                                        public void setTitle(String title)
            {
                this.title = title;
            }

            public String getTitle()
            {
                return title;
            }
                                                        public void setIntroduction(String introduction)
            {
                this.introduction = introduction;
            }

            public String getIntroduction()
            {
                return introduction;
            }
                                                        public void setPicture(String picture)
            {
                this.picture = picture;
            }

            public String getPicture()
            {
                return picture;
            }
                                                        public void setContent(String content)
            {
                this.content = content;
            }

            public String getContent()
            {
                return content;
            }
            
    }
