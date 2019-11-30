package com.imooc.girl.handle;


import com.imooc.girl.domain.Result;
import com.imooc.girl.utils.ResultUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author panshao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public Result handle(Exception e) {
        return ResultUtil.fail(e.getMessage());
    }
}
