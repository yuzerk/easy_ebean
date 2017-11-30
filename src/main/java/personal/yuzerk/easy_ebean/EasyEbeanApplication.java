package personal.yuzerk.easy_ebean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class EasyEbeanApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyEbeanApplication.class, args);
	}
}
