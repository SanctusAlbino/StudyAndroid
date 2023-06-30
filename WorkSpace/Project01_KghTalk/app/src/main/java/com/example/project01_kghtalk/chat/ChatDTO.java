package com.example.project01_kghtalk.chat;

public class ChatDTO {
    private int chatImgId;
    private String chat_name, chat_msg;

    public int getChatImgId() {
        return chatImgId;
    }

    public void setChatImgId(int chatImgId) {
        this.chatImgId = chatImgId;
    }

    public String getChat_name() {
        return chat_name;
    }

    public void setChat_name(String chat_name) {
        this.chat_name = chat_name;
    }

    public String getChat_msg() {
        return chat_msg;
    }

    public void setChat_msg(String chat_msg) {
        this.chat_msg = chat_msg;
    }

    public ChatDTO(int chatImgId, String chat_name, String chat_msg) {
        this.chatImgId = chatImgId;
        this.chat_name = chat_name;
        this.chat_msg = chat_msg;
    }
}
