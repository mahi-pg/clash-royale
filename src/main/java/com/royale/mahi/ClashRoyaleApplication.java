package com.royale.mahi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.royale.mahi")
@SpringBootApplication
public class ClashRoyaleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClashRoyaleApplication.class, args);
	}

}
