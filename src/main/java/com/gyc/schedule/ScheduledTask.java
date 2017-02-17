package com.gyc.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author yc.guo@zuche.com on 2017/2/17.
 */
@Component
public class ScheduledTask {

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间：" + LocalDate.now() + " " + LocalTime.now());
    }
}
