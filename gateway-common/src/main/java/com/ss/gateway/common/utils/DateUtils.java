package com.ss.gateway.common.utils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author xueshansheng
 * @date 2020/4/26 下午 8:59
 */
public class DateUtils {

    /**
     * 将时间格式转换成字符串
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String getDateStr(Date date, String pattern) {
        return new DateTime(date).toString(pattern);
    }

    /**
     * 根据 pattern 将 dateTime 时间进行格式化
     * 用来去除时分秒，具体根据结果以 pattern 为准
     *
     * @param date
     * @param pattern
     * @return
     */
    public static Date formatToDate(Date date, String pattern) {

        if (date == null) {
            return null;
        }
        DateTimeFormatter format = DateTimeFormat.forPattern(pattern);
        return DateTime.parse(new DateTime(date).toString(pattern), format).toDate();
    }
}
