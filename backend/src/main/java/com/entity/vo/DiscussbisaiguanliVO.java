package com.entity.vo;

import com.entity.DiscussbisaiguanliEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import java.sql.Timestamp;
import org.springframework.format.annotation.DateTimeFormat;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;


/**
 * 比赛管理评论
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
public class DiscussbisaiguanliVO  implements Serializable {
    private static final long serialVersionUID = 1L;
                        /** 主键 */
                    private Long id;

                                /** 创建时间 */
                                                                                                private Timestamp addtime;

                                /** 关联表id */
                                                                                                private Long refid;

                                /** 用户id */
                                                                                                private Long userid;

                                /** 用户名 */
                                                                                                private String nickname;

                                /** 评论内容 */
                                                                                                private String content;

                                /** 回复内容 */
                                                                                                private String reply;

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
                                                        public void setUserid(Long userid)
            {
                this.userid = userid;
            }

            public Long getUserid()
            {
                return userid;
            }
                                                        public void setNickname(String nickname)
            {
                this.nickname = nickname;
            }

            public String getNickname()
            {
                return nickname;
            }
                                                        public void setContent(String content)
            {
                this.content = content;
            }

            public String getContent()
            {
                return content;
            }
                                                        public void setReply(String reply)
            {
                this.reply = reply;
            }

            public String getReply()
            {
                return reply;
            }
            
    }
