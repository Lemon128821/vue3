package com.pojo;

import lombok.Data;

@Data
public class Response<T> {
    private Integer code;
    private String message;
    private ResponseData<T> responseData;

    public Response() {
    }

    public Response(Integer code, String message, ResponseData<T> responseData) {
        this.code = code;
        this.message = message;
        this.responseData = responseData;
    }
}
