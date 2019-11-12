/**
 * Copyright 2019 China Mobile Communications Group Co.,Ltd.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.websocketdemo.intecepter;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HttpHandShakeInterceptor implements HandshakeInterceptor {

    /**
     * Execute the method before the handshake, continue the handshake to return true, the interrupt handshake returns false.
     * Set the properties of the WebSocketSession through the attributes parameter.
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request,
                                   ServerHttpResponse response, WebSocketHandler wsHandler,
                                   Map<String, Object> attributes) throws Exception {

        log.info("HttpHandShakeInterceptor->beforeHandshake");

        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession();
            log.info("HttpHandShakeInterceptor->beforeHandshake sessionId=" + session.getId());
//            attributes.put("sessionId", sessionId);
        }

        return true;
    }


    /**
     * Execute the method after the handshake.
     * Indicates the response status code and the corresponding header whether or not the handshake is successful.
     */
    @Override
    public void afterHandshake(ServerHttpRequest request,
                               ServerHttpResponse response, WebSocketHandler wsHandler,
                               Exception exception) {
        log.info("HttpHandShakeInterceptor->afterHandshake");
        if (request instanceof ServletServerHttpRequest) {
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession();
            log.info("HttpHandShakeInterceptor->afterHandshake sessionId=" + session.getId());
        }
    }
}
