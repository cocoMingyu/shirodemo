package com.example.shirodemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author kn
 * @ Description
 * @ Date 2019/7/22 19:38
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseBean<T> {
    public Integer code;
    public String message;
    public T data;

    public static ResponseBean successed() {
        return new ResponseBean(200, "success", null);
    }

    public static ResponseBean successed(String message,Object obj) {
        return new ResponseBean(200, message, obj);
    }

    public static ResponseBean successed(Object obj) {
        return new ResponseBean(200, "success", obj);
    }

    public static ResponseBean failed(int code, String message) {
        return new ResponseBean(code, message, null);
    }
}
