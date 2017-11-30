package personal.yuzerk.easy_ebean.result;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class Error {

    private String message;
    private String field;
    private String code;
    public String getMessage() {
        return message;
    }

    public Error setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getField() {
        return field;
    }

    public Error setField(String field) {
        this.field = field;
        return this;
    }

    public String getCode() {
        return code;
    }

    public Error setCode(String code) {
        this.code = code;
        return this;
    }
}
