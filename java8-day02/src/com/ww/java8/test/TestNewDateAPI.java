package com.ww.java8.test;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @author WangWei
 * @Title: TestLocalDateTime
 * @ProjectName java8
 * @date 2019/1/21 16:30
 * @description:
 */
public class TestNewDateAPI {

    // TemporalAdjuester: 时间校正器
    @Test
    public void test6() {
        LocalDateTime ldt =  LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt2.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt3);
    }


    // 3. Duration: 计算两个"时间" 之间的间隔，
    //    Period:   计算两个"日期" 之间的间隔
    @Test
    public void test5() {

        LocalDate date = LocalDate.of(2019, 01,01);

        LocalDate today = LocalDate.now();

        Period between = Period.between(date, today);
        System.out.println(between.getYears());
        System.out.println(between.getMonths());
        System.out.println(between.getDays());
    }
    @Test
    public void test4() {
        LocalTime start = LocalTime.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        LocalTime end = LocalTime.now();
        System.out.println(Duration.between(start, end).toMillis());
    }
    @Test
    public void test3() {
        Instant start = Instant.now();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println(duration);
        System.out.println(duration.toMillis());
    }

    //2. Instant: 时间戳(以 Unix 元年: 1970.1.1 00:00:00 到某时之间的毫秒值)
    @Test
    public void test2() {
        Instant now = Instant.now(); // 默认获取的 UTC 时区
        System.out.println(now);
        System.out.println(now.atOffset(ZoneOffset.ofHours(8)));
        System.out.println(now.toEpochMilli());
        System.out.println();

        Instant ins = Instant.ofEpochSecond(60);
        System.out.println(ins);
    }

    //1. LocalDate    LocalTime   LocalDateTime
    @Test
    public void test1() {
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        System.out.println(ldt);
        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getHour());
        System.out.println(ldt.getMinute());
        System.out.println(ldt.getSecond());

        LocalDateTime ldt2 = LocalDateTime.of(2019, 01, 21, 16, 35, 33);
        System.out.println(ldt2.plusYears(1l));
        System.out.println(ldt2.minusMonths(2));


    }
}
