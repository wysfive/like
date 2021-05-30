package com.yasa.like.handle;

import com.yasa.like.exception.UserException;
import com.yasa.like.utils.ResultVOUtils;
import com.yasa.like.vo.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @ResponseBody
    @ExceptionHandler(value = UserException.class)
    public ResultVO handle(Exception e){
        if (e instanceof UserException){
            UserException userException = (UserException) e;
            return ResultVOUtils.error(userException.getCode(), userException.getMessage());
        }
        return null;
    }
}
