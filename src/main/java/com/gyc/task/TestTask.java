package com.gyc.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

/**
 * @author yc.guo@zuche.com on 2017/2/17.
 */
@Component
public class TestTask {

    private static Random random = new Random();
    private static final Logger LOGGER = LoggerFactory.getLogger(TestTask.class);

    @Async
    public Future<String> doTaskOne() throws InterruptedException {
        LOGGER.info("开始执行任务1");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        String result = "任务1执行结束, 耗时：" + (System.currentTimeMillis() - start);
        LOGGER.info(result);
        return new AsyncResult<>(result);
    }

    @Async
    public Future<String> doTaskTwo() throws InterruptedException {
        System.out.println("开始执行任务2");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        String result = "任务1执行结束, 耗时：" + (System.currentTimeMillis() - start);
        System.out.println(result);
        return new AsyncResult<>(result);
    }
}
