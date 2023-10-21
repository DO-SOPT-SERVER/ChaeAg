package com.server.dosopt.seminar.domain;

public enum MessageEnum {
    UPDATE("성공적으로 수정됨."),
    DELETE("성공적으로 삭제됨."),
    CRETAE("성공적으로 생성됨.");

    private final String message;

    MessageEnum(String message){
        this.message = message;
    }
    public String message() {
        return message;
    }
}
