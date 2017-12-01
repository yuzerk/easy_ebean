package personal.yuzerk.easy_ebean.common.ebeanServer;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuzk
 * @date 2017/11/30
 */
public class EbeanDatasourceConfig {

    @Value("${datasource.db.username}")
    private String username;

    @Value("${datasource.db.password}")
    private String password;

    @Value("${datasource.db.databaseUrl}")
    private String databaseUrl;

    @Value("${spring.redis.host}")
    private String test;

    @Bean
    public MysqlDataSource getMysqlDataSource() {

        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setUser(username);
        dataSource.setURL(databaseUrl);
        dataSource.setPassword(password);

        return dataSource;
    }



}
