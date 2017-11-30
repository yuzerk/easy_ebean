package personal.yuzerk.easy_ebean.common.ebeanServer;


import io.ebean.config.IdGenerator;
import org.springframework.stereotype.Component;
import personal.yuzerk.easy_ebean.util.UuidUtil;

/**
 * @author yuzk
 * @date 2017/11/22
 */
@Component
public class UuidGenerator implements IdGenerator{
    @Override
    public Object nextValue() {
        return UuidUtil.randomUUID();
    }

    @Override
    public String getName() {
        return "UUID";
    }
}
