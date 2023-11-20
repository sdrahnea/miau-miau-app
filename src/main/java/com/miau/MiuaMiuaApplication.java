package com.miau;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.awt.*;
import java.util.Random;

/**
 * Created by sdrahnea
 */
@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
public class MiuaMiuaApplication {

    public static final int INTERVAL = 20000;
    public static final int MAX_X = 400;
    public static final int MAX_Y = 400;

    public static void main(String[] args) throws AWTException, InterruptedException {
        System.setProperty("java.awt.headless", "false");

        SpringApplication.run(MiuaMiuaApplication.class, args);

        Robot robot = new Robot();
        Random random = new Random();

        int lastX = 0;
        int lastY = 0;

        while (true) {
            Point currentPoint = MouseInfo.getPointerInfo().getLocation();

            int currentX = Double.valueOf(currentPoint.getX()).intValue();
            int currentY = Double.valueOf(currentPoint.getY()).intValue();

            if(lastX == currentX && lastY == currentY) {
                robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            }

            lastX = currentX;
            lastY = currentY;
            Thread.sleep(INTERVAL);
        }
    }
}
