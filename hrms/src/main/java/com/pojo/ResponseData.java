package com.pojo;

import lombok.Data;
import java.util.List;

@Data
public class ResponseData<T> {
    private String token;
    private T object;
    private List<T> list;
    private List listTwo;
    private List listThree;
    private boolean result;
    private String message;
}
