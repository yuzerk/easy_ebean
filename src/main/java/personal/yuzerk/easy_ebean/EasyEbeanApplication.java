package personal.yuzerk.easy_ebean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import personal.yuzerk.easy_ebean.common.ebeanServer.EbeanDatasourceConfig;

@SpringBootApplication
@ServletComponentScan
@Import(EbeanDatasourceConfig.class)
public class EasyEbeanApplication {

//	@Value("${datasource.db.username}")
//	private String username;
//
//	@Value("${datasource.db.password}")
//	private String password;
//
//	@Value("${datasource.db.databaseUrl}")
//	private String databaseUrl;

	public static void main(String[] args) {
		SpringApplication.run(EasyEbeanApplication.class, args);
	}


//	@Bean
//	EbeanDataSource getDataSource() {
//		EbeanDataSource source = new EbeanDataSource();
//		source.setPassword(password);
//		source.setURL(databaseUrl);
//		source.setUser(username);
//		return source;
//	}
}
