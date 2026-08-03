package com.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.ConsultationEntity;
import com.entity.LetterEntity;
import com.service.ConsultationService;
import com.service.LetterService;
import com.utils.SpringContextUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 私信websocket处理器
 */
public class LetterWebSocketHandler extends TextWebSocketHandler {
    public static final Map<ChatUser, WebSocketSession> sessionMap = new ConcurrentHashMap<>();
    private LetterService letterService = (LetterService) SpringContextUtils.getBean("letterService");

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String encodingUri = session.getUri().toString();
        String uri = URLDecoder.decode(encodingUri, "utf-8");
        String params = uri.split("\\?")[1];
        String[] paramsArray = params.split("&");
        Long userId = Long.parseLong(paramsArray[0].split("=")[1]);
        String nicheng = String.valueOf(paramsArray[1].split("=")[1]);
        sessionMap.put(new ChatUser(userId, nicheng), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Thread.sleep(1000);
        String payload = message.getPayload();
        JSONObject jsonObject = JSON.parseObject(payload);
        String type = (String) jsonObject.get("type");
        if (type.equals("JOIN")) {

        } else if(type.equals("MESSAGE")) {
            String srcUserIdStr = String.valueOf(jsonObject.get("srcUserId"));
            synchronized (srcUserIdStr.intern()) {
                String srcUserNichengStr = String.valueOf(jsonObject.get("srcUserNicheng"));
                String targetUserIdStr = String.valueOf(jsonObject.get("targetUserId"));
                String msg = (String)jsonObject.get("msg");
                Long userId = Long.parseLong(targetUserIdStr);
                if(targetUserIdStr != null && !targetUserIdStr.trim().equals("")) { //单发
                    try {
                        //将聊天记录保存数据库
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date sendTime = new Date(System.currentTimeMillis());
                        LetterEntity<Object> letter = new LetterEntity<>();
                        letter.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
                        letter.setSender(Long.parseLong(srcUserIdStr));
                        letter.setSenderName(srcUserNichengStr);
                        letter.setReceiver(userId);
                        letter.setMsg(msg);
                        letter.setSendTime(sendTime);
                        letter.setReadStatus(0); //未读
                        letterService.insert(letter);

                        Set<ChatUser> chatUsers = sessionMap.keySet();
                        for (ChatUser chatUser: chatUsers) {
                            if(chatUser.getUserId().equals(userId)) {
                                //发送消息
                                WebSocketSession webSocketSession = sessionMap.get(chatUser);
                                webSocketSession.sendMessage(new TextMessage("{\"type\": \"MESSAGE\", " +
                                        "\"srcUserIdStr\": " + srcUserIdStr + ", \"srcUserNichengStr\": \"" +
                                        srcUserNichengStr + "\", \"msg\": \"" + msg + "\", \"sendTime\": \"" + sdf.format(sendTime) + "\"}"));
                                break;
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Set<ChatUser> chatUsers = sessionMap.keySet();
        for (ChatUser chatUser : chatUsers) {
            if (sessionMap.get(chatUser).getId().equals(session.getId())) {
                sessionMap.remove(chatUser, session);
                break;
            }
        }
    }

    public static class ChatUser {
        private Long userId;
        private String nickname;

        public ChatUser(Long userId, String nickname) {
            this.userId = userId;
            this.nickname = nickname;
        }

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }
    }
}
