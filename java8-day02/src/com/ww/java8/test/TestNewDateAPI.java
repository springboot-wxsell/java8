package com.ww.java8.test;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.Set;

/**
 * @author WangWei
 * @Title: TestLocalDateTime
 * @ProjectName java8
 * @date 2019/1/21 16:30
 * @description:
 */
public class TestNewDateAPI {

    // ZoneDate  ZoneTime    ZoneDateTime

    @Test
    public void test9(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/London"));
        System.out.println(ldt);

        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zdt);
    }

    @Test
    public void test8() {
        Set<String> areas = ZoneId.getAvailableZoneIds();
        areas.forEach(System.out::println);
    }

    // DateTimeFormatter: 格式化时间/日期
    @Test
    public void test7() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String format = ldt.format(dtf);
        System.out.println(format);

        System.out.println("---------------------------------");
        // 自定义格式
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format1 = dtf2.format(ldt);
        System.out.println(format1);

        LocalDateTime newDate = ldt.parse(format1, dtf2 );
        System.out.println(newDate);
    }

    // TemporalAdjuester: 时间校正器
    @Test
    public void test6() {
        LocalDateTime ldt =  LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);

        LocalDateTime ldt3 = ldt2.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println(ldt3);

        // 自定义: 下一个工作日
        LocalDateTime with = ldt.with((l) -> {
            LocalDateTime ldt4 = (LocalDateTime) l;

            DayOfWeek dow = ldt.getDayOfWeek();

            if (dow.equals(DayOfWeek.FRIDAY)) {
                return ldt4.plusDays(3);
            } else if (dow.equals(DayOfWeek.SATURDAY)) {
                return ldt4.plusDays(2);
            } else {
                return ldt4.plusDays(1);
            }
        });
        System.out.println(with);
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
