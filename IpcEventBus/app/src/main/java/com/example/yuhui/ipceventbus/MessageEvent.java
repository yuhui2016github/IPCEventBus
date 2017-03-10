package com.example.yuhui.ipceventbus;

/**
 * Created by yuhui on 2017-3-8.
 */
public class MessageEvent {
    String MessageId;
    String MessageContent;

    public MessageEvent(String messageId, String messageContent) {
        MessageId = messageId;
        MessageContent = messageContent;
    }

    @Override
    public String toString() {
        return "MessageId : " + MessageId + " MessageContent : " + MessageContent;
    }
}
