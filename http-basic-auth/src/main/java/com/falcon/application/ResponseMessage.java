package com.falcon.application;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseMessage<T> {
    private T data;
    private String errorCode;
    private String errorMessage;

    public ResponseMessage(T data) {
        this.data = data;
    }
}
