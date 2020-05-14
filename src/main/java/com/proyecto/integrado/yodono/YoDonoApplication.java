package com.proyecto.integrado.yodono;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableSchedulerLock(defaultLockAtMostFor = "30s")
public class YoDonoApplication {

	public static void main(String[] args) {
		SpringApplication.run(YoDonoApplication.class, args);
	}

}
