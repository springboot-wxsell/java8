package com.ww.java8.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author WangWei
 * @Title: DateFormatThreadLocal
 * @ProjectName java8
 * @date 2019/1/21 15:17
 * @description:
 */
public class DateFormatThreadLocal {

    private static final ThreadLocal<DateFormat> df = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static Date convert(String source) throws ParseException {
        return df.get().parse(source);
    }
}
