package com.imooc.girl.utils;

import com.imooc.girl.domain.Girl;
import com.imooc.girl.domain.Result;

/**
 * @author panshao
 */
public class ResultUtil {
    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(true);
        result.setMsg("successful");
        result.setData(object);
        return result;
    }

    public static Result success() {
        return success(null);
    }

    public static Result fail(String msg) {
        Result result = new Result();
        result.setCode(false);
        result.setMsg(msg);
        return result;
    }
}
