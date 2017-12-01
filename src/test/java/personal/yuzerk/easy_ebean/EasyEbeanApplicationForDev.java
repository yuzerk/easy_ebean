package personal.yuzerk.easy_ebean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

/**
 * @author yuzk
 * @date 2017/11/30
 */
public class EasyEbeanApplicationForDev {

    public static void main(String[] args) {
        ApplicationContext context = new SpringApplicationBuilder()
                .sources(EasyEbeanApplication.class)
                .profiles("dev")
                .web(true)
                .run(args);
    }
}
