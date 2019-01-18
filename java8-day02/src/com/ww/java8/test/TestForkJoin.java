package com.ww.java8.test;

import com.ww.java8.calc.ForkJoinCalculate;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

/**
 * Created by wangwei on 2019/1/18.
 */
public class TestForkJoin {

    /**
     * ForkJoin 框架
     */
    @Test
    public void test1() {
        Instant start = Instant.now();

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinCalculate(0L, 100000000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("耗费时间：" + Duration.between(start, end).toMillis());
    }

    /**
     * 普通for循环
     */
    @Test
    public void test2() {
        Instant start = Instant.now();

        long sum = 0L;
        for (long i = 0L; i <= 500000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);

        Instant end = Instant.now();
        System.out.println("for循环耗时为：" + Duration.between(start, end).toMillis());//31397
    }

    /**
     *  java8 并行流
     */
    @Test
    public void test3() {
        Instant start = Instant.now();
        LongStream.rangeClosed(0L, 500000000000L)
                .parallel()
                .reduce(0, Long::sum);

        Instant end = Instant.now();
        System.out.println("java8并行流的耗时：" + Duration.between(start, end).toMillis()); //33464
    }
}
