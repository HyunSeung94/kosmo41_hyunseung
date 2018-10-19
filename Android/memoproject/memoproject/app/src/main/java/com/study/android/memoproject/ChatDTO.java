package com.study.android.memoproject;

public class ChatDTO {
    //Message data Set(message,user)
    private String userName;
    private String message;
    private String time;



    public ChatDTO() {}

    public ChatDTO(String userName, String message, String time) {
        this.userName = userName;
        this.message = message;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserName() {
        return userName;
    }

    public String getMessage() {
        return message;
    }
}
