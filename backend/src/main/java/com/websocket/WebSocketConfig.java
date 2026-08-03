package com.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(new DoctorUserWebSocketHandler(), "/consultation")
                .setAllowedOrigins("*"); // 允许跨域请求
        registry.addHandler(new LetterWebSocketHandler(), "/letter")
                .setAllowedOrigins("*"); // 允许跨域请求
    }
}