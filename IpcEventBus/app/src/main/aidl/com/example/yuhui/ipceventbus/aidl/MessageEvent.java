package com.example.yuhui.ipceventbus.aidl;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yuhui on 2017-3-8.
 */
public class MessageEvent implements Parcelable {
    String MessageId;
    String MessageContent;

    public MessageEvent(String messageId, String messageContent) {
        MessageId = messageId;
        MessageContent = messageContent;
    }

    public static final Creator<MessageEvent> CREATOR = new Creator<MessageEvent>() {
        @Override
        public MessageEvent createFromParcel(Parcel in) {
            return new MessageEvent(in);
        }

        @Override
        public MessageEvent[] newArray(int size) {
            return new MessageEvent[size];
        }
    };

    @Override
    public String toString() {
        return "MessageId : " + MessageId + " MessageContent : " + MessageContent;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    protected MessageEvent(Parcel in) {
        MessageId = in.readString();
        MessageContent = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(MessageId);
        dest.writeString(MessageContent);
    }
}
