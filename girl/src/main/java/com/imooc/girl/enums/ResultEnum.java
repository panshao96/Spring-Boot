package com.imooc.girl.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author panshao
 */

@AllArgsConstructor
@Getter
public enum ResultEnum {
    /**
     * 抛出类型
     */
    UNKNOWN_ERROR(-1, "未知错误"),
    SUCCESSFUL(0, "成功"),
    JUNIOR(100, "小学生"),
    MIDDLE_STUDENT(101, "中学生"),
    ADULT(102, "成年人"),
    ;

    private Integer code;
    private String msg;



}
