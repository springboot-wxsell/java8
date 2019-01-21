package com.ww.java8.test;

import com.ww.java8.utils.DateFormatThreadLocal;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    // 存在线程安全问题
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Callable<Date> task = () -> DateFormatThreadLocal.convert("2018-01-21");
        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<Date>> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            list.add(pool.submit(task));
        }
        for (Future<Date> future : list) {
            System.out.println(future.get());
        }
        pool.shutdown();
    }


    // 线程安全的
    @Test
    public void test2() throws ExecutionException, InterruptedException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        Callable<LocalDate> task =() -> LocalDate.parse("2019-01-21", dtf);

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }
    }
}
