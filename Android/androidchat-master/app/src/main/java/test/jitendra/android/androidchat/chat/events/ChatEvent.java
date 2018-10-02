package test.jitendra.android.androidchat.chat.events;

import test.jitendra.android.androidchat.chat.entities.ChatMessage;


public class ChatEvent {
    ChatMessage msg;

    public ChatEvent(ChatMessage msg) {
        this.msg = msg;
    }

    public ChatMessage getMessage() {
        return msg;
    }
}
