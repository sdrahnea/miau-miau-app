package com.miau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.awt.*;
import java.util.Random;

/**
 * Created by sdrahnea
 */
@EnableSwagger2
@EnableAutoConfiguration
@SpringBootApplication
@EnableJpaRepositories
@ComponentScan
public class MiuaMiuaApplication {

    public static final int INTERVAL = 20000;
    public static final int MAX_X = 400;
    public static final int MAX_Y = 400;

    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("java.net.headless", "false");

        SpringApplication.run(MiuaMiuaApplication.class, args);

        Robot robot = new Robot();
        Random random = new Random();

        while (true) {
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            Thread.sleep(INTERVAL);
        }
    }
}
