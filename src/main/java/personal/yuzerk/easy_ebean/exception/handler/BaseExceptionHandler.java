package personal.yuzerk.easy_ebean.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import personal.yuzerk.easy_ebean.exception.BadRequestException;
import personal.yuzerk.easy_ebean.result.Result;
import personal.yuzerk.easy_ebean.result.Error;

/**
 * @author yuzk
 * @date 2017/11/22
 */
@ControllerAdvice
public class BaseExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Object> handlerBadRequestException(BadRequestException e) {

        return new ResponseEntity<Object>(generateExceptionResult(e, ""), HttpStatus.OK);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handlerProtocolMatch(Exception e) {

        return new ResponseEntity<Object>(generateExceptionResult(e, "500"), HttpStatus.OK);
    }

    private Result generateExceptionResult(Exception e, String code) {
        return new Result().setRet(-1).setError(new Error().setMessage(e.getMessage()));
    }
}
