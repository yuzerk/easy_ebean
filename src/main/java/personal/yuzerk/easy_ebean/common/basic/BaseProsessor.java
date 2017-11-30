package personal.yuzerk.easy_ebean.common.basic;

import org.springframework.validation.BindingResult;
import personal.yuzerk.easy_ebean.exception.BadRequestException;
import personal.yuzerk.easy_ebean.util.ValidateUtil;

/**
 * @author yuzk
 * @date 2017/11/22
 */
public class BaseProsessor {

    /**
     * 空
     *
     * @param value
     * @return
     */
    public static boolean isEmpty(Object value) {

        return ValidateUtil.isEmpty(value);
    }

    /**
     * 非空
     *
     * @param value
     * @return
     */
    public static boolean isNotEmpty(Object value) {

        return ValidateUtil.isNotEmpty(value);
    }


    /**
     * 参数校验
     *
     * @param object
     */
    public void validateArgs(Object object) {

        if (object == null) {
            return;
        }

        if (object instanceof BindingResult) {

            BindingResult bindingResult = (BindingResult) object;

            if (bindingResult.hasErrors()) {
                throwBadRequestException(bindingResult.getFieldError().getField(),bindingResult.getFieldError().getDefaultMessage());
            }

            return;
        }
    }

    private void throwBadRequestException(String field, String message) {

        throw new BadRequestException(field,message);
    }
}
