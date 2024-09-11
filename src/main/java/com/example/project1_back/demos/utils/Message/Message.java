package com.example.project1_back.demos.utils.Message;

import lombok.Data;

@Data
public class Message {
    private String code;
    private String message;
    private Object data;


    public Message(String code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public Message() {

    }
}
