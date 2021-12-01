package com.falcon.application;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


public class ResponseBuilder<T> {

    HttpHeaders headers;

    public ResponseBuilder<T> setHeaders(MultiValueMap<String, String> headersMap) {
        HttpHeaders headers = new HttpHeaders();
        headers.putAll(headersMap);
        this.headers = headers;
        return this;
    }

    public ResponseEntity<ResponseMessage<T>> buildForPostSuccess(T data) {
        ResponseMessage<T> responseMessageBody = new ResponseMessage<>(data);
        return new ResponseEntity<>(responseMessageBody, headers, HttpStatus.CREATED);
    }

    public ResponseEntity<ResponseMessage<T>> buildForGetSuccess(T data) {
        ResponseMessage<T> responseMessageBody = new ResponseMessage<>(data);
        return new ResponseEntity<>(responseMessageBody, headers, HttpStatus.OK);
    }


    public ResponseEntity<ResponseMessage<T>> buildForFail(T data, String errorCode, String errorMessage) {
        ResponseMessage<T> responseMessageBody = new ResponseMessage<>(data, errorCode, errorMessage);
        return new ResponseEntity<>(responseMessageBody, headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
