package com.websocket;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.entity.ConsultationEntity;
import com.service.ConsultationService;
import com.service.impl.ConsultationServiceImpl;
import com.utils.SpringContextUtils;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class DoctorUserWebSocketHandler extends TextWebSocketHandler {

    public static final Map<String, Map<ChatUser, WebSocketSession>> roleSessionMap = new ConcurrentHashMap<>();
    private ConsultationService consultationService = (ConsultationService)SpringContextUtils.getBean("consultationService");

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String encodingUri = session.getUri().toString();
        String uri = URLDecoder.decode(encodingUri, "utf-8");
        String params = uri.split("\\?")[1];
        String[] paramsArray = params.split("&");
        String role = paramsArray[0].split("=")[1];
        Long userId = Long.parseLong(paramsArray[1].split("=")[1]);
        String nicheng = String.valueOf(paramsArray[2].split("=")[1]);
        roleSessionMap.computeIfAbsent(role, k -> new ConcurrentHashMap<>());
        Map<ChatUser, WebSocketSession> userSessionMap = roleSessionMap.get(role);
        userSessionMap.put(new ChatUser(userId, nicheng), session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        Thread.sleep(1000);
        String payload = message.getPayload();
        JSONObject jsonObject = JSON.parseObject(payload);
        String type = (String) jsonObject.get("type");
        if (type.equals("JOIN")) {
//            String toRole = (String) jsonObject.get("toRole");
//            Map<ChatUser, WebSocketSession> userSessionMap = roleSessionMap.get(toRole);
//            Set<ChatUser> chatUsers = userSessionMap.keySet();
//            for (ChatUser chatUser: chatUsers) {
//                try {
//                    WebSocketSession webSocketSession = userSessionMap.get(chatUser);
//                    webSocketSession.sendMessage(new TextMessage(payload));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        } else if(type.equals("MESSAGE")) {
            String srcUserIdStr = String.valueOf(jsonObject.get("srcUserId"));
            synchronized (srcUserIdStr.intern()) {
                String srcUserNichengStr = String.valueOf(jsonObject.get("srcUserNicheng"));
                String toRole = String.valueOf(jsonObject.get("toRole"));
                String targetUserIdStr = String.valueOf(jsonObject.get("targetUserId"));
                String msg = (String)jsonObject.get("msg");
                Long userId = Long.parseLong(targetUserIdStr);

                if(targetUserIdStr != null && !targetUserIdStr.trim().equals("")) { //单发
                    try {
                        if (toRole == null || toRole.equals("null") || toRole.trim().equals("")) {
                            //将聊天记录保存数据库
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date sendTime = new Date(System.currentTimeMillis());
                            ConsultationEntity<Object> consultationEntity = new ConsultationEntity<>();
                            consultationEntity.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
                            consultationEntity.setSender(Long.parseLong(srcUserIdStr));
                            consultationEntity.setSenderName(srcUserNichengStr);
                            consultationEntity.setReceiver(userId);
                            consultationEntity.setMsg(msg);
                            consultationEntity.setSendTime(sendTime);
                            consultationEntity.setReadStatus(0); //未读
                            consultationService.insert(consultationEntity);

                            Collection<Map<ChatUser, WebSocketSession>> userSessionMaps = roleSessionMap.values();
                            out: for (Map<ChatUser, WebSocketSession> userSessionMap : userSessionMaps) {
                                Set<ChatUser> chatUsers = userSessionMap.keySet();
                                for (ChatUser chatUser : chatUsers) {
                                    if(chatUser.getUserId().equals(userId)) {
                                        //发送消息
                                        WebSocketSession webSocketSession = userSessionMap.get(chatUser);
                                        webSocketSession.sendMessage(new TextMessage("{\"type\": \"MESSAGE\", " +
                                                "\"srcUserIdStr\": " + srcUserIdStr + ", \"srcUserNichengStr\": \"" +
                                                srcUserNichengStr + "\", \"msg\": \"" + msg + "\", \"sendTime\": \"" + sdf.format(sendTime) + "\"}"));
                                        break out;
                                    }
                                }
                            }
                        } else {
                            //将聊天记录保存数据库
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                            Date sendTime = new Date(System.currentTimeMillis());
                            ConsultationEntity<Object> consultation = new ConsultationEntity<>();
                            consultation.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
                            consultation.setSender(Long.parseLong(srcUserIdStr));
                            consultation.setSenderName(srcUserNichengStr);
                            consultation.setReceiver(userId);
                            consultation.setMsg(msg);
                            consultation.setSendTime(sendTime);
                            consultation.setReadStatus(0); //未读
                            consultationService.insert(consultation);

                            Map<ChatUser, WebSocketSession> userSessionMap = roleSessionMap.get(toRole);
                            Set<ChatUser> chatUsers = userSessionMap.keySet();
                            for (ChatUser chatUser: chatUsers) {
                                if(chatUser.getUserId().equals(userId)) {
                                    //发送消息
                                    WebSocketSession webSocketSession = userSessionMap.get(chatUser);
                                    webSocketSession.sendMessage(new TextMessage("{\"type\": \"MESSAGE\", " +
                                            "\"srcUserIdStr\": " + srcUserIdStr + ", \"srcUserNichengStr\": \"" +
                                            srcUserNichengStr + "\", \"msg\": \"" + msg + "\", \"sendTime\": \"" + sdf.format(sendTime) + "\"}"));
                                    break;
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                /**
                else {
                    // 群发
                    //将聊天记录保存数据库
                    ConsultationEntity<Object> consultation = new ConsultationEntity<>();
                    consultation.setId(new Date().getTime() + new Double(Math.floor(Math.random() * 1000)).longValue());
                    consultation.setSender(Long.parseLong(srcUserIdStr));
                    consultation.setSenderName(srcUserNichengStr);
                    consultation.setReceiver(0L);  // 0表示发给群里所有人
                    consultation.setMsg(msg);
                    consultation.setSendTime(new Date(System.currentTimeMillis()));
                    consultation.setReadStatus(0); //未读
                    consultationService.insert(consultation);

                    Map<ChatUser, WebSocketSession> userSessionMap = roleSessionMap.get(toRole);
                    Set<ChatUser> chatUsers = userSessionMap.keySet();
                    for (ChatUser chatUser: chatUsers) {
                        WebSocketSession ws = userSessionMap.get(chatUser);
                        ws.sendMessage(new TextMessage("{\"type\": \"MESSAGE\", \"srcUserIdStr\": " + srcUserIdStr + ", \"srcUserNichengStr\": \""
                                + srcUserNichengStr + "\", \"msg\": \"" + msg + "\"}"));
                    }
                }
                 */
            }
        }
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        Set<String> roleSet = roleSessionMap.keySet();
        out: for (String role : roleSet) {
            Map<ChatUser, WebSocketSession> userSessionMap = roleSessionMap.get(role);
            Set<ChatUser> chatUsers = userSessionMap.keySet();
            for (ChatUser chatUser : chatUsers) {
                if (userSessionMap.get(chatUser).getId().equals(session.getId())) {
                    userSessionMap.remove(chatUser, session);
                    break out;
                }
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
