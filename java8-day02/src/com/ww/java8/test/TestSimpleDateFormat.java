package com.ww.java8.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author WangWei
 * @Title: TestSimpleDateFormat
 * @ProjectName java8
 * @date 2019/1/18 19:38
 * @description:
 */
public class TestSimpleDateFormat {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Callable<Date> task = () -> sdf.parse("2019-01-18");
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(pool.submit(task));
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
    }
}
