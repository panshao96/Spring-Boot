package com.imooc.girl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Http请求返回的对象
 * @author panshao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    /**
     * 错误码.
     */
    private Boolean code;

    /**
     * 提示信息.
     */
    private String msg;

    /**
     * 具体内容.
     */
    private T data;
}
