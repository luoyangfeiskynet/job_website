package cn.com.fqy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="cn.com.fqy.core.dao")
public class XtsjWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(XtsjWebsiteApplication.class, args);
	}
}
