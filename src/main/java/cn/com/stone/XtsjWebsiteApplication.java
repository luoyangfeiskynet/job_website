package cn.com.stone;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages="cn.com.stone.core.dao")
public class XtsjWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(XtsjWebsiteApplication.class, args);
	}
}
