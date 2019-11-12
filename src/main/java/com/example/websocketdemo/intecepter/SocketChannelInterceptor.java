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

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SocketChannelInterceptor extends ChannelInterceptorAdapter {
    /**
     * Called after the completion of the send,
     * regardless of whether an exception occurs, generally used for resource cleanup
     */
    @Override
    public void afterSendCompletion(Message<?> message, MessageChannel channel,
                                    boolean sent, Exception ex) {
        log.info("SocketChannelInterceptor->afterSendCompletion");
        super.afterSendCompletion(message, channel, sent, ex);
    }


    /**
     * Called before the message is actually sent to the channel
     */
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        log.info("SocketChannelInterceptor->preSend");
        return super.preSend(message, channel);
    }

    /**
     * Called immediately after sending a message call
     */
    @Override
    public void postSend(Message<?> message, MessageChannel channel,
                         boolean sent) {
        log.info("SocketChannelInterceptor->postSend");

        /**
         * Header accessor
         */
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);

        /**
         * Avoid non-stomp message types, such as heartbeat detection
         */
        if (headerAccessor.getCommand() == null) return;

        String sessionId = headerAccessor.getSessionId();
        System.out.println("SocketChannelInterceptor -> sessionId = " + sessionId);

        switch (headerAccessor.getCommand()) {
            case CONNECT:
                connect(sessionId);
                break;
            case DISCONNECT:
                disconnect(sessionId);
                break;
            case SUBSCRIBE:
                break;

            case UNSUBSCRIBE:
                break;
            default:
                break;
        }
    }

    /**
     * Connection succeeded
     */
    private void connect(String sessionId) {
        log.info("connect sessionId=" + sessionId);
    }

    /**
     * Disconnect
     */
    private void disconnect(String sessionId) {
        log.info("disconnect sessionId=" + sessionId);
    }
}
