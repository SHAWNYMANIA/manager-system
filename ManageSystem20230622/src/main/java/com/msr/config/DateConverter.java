package com.msr.config;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//全局日期转换器   【暂时无用】
@Component
public class DateConverter implements Converter<String, LocalDateTime> {
    private static final String dateFormat = "yyyy-MM-dd HH:mm:ss";
    private static final String dateFormata = "yyyy-MM-dd HH:mm:ss";
    private static final String shortDateFormat = "yyyy-MM-dd";
    private static final String shortDateFormata = "yyyy/MM/dd";
    private static final String timeStampFormat = "^\\d+$";

    @Override
    public LocalDateTime convert(String value) { //2020-12-12 → value
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        if (StringUtils.isEmpty(value)) {
            return null;
        }
        value = value.trim();
        try {
            if (value.contains("-")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    // yyyy-MM-dd HH:mm:ss 格式
                    formatter = new SimpleDateFormat(dateFormat);
                } else {
                    // yyyy-MM-dd 格式
                    formatter = new SimpleDateFormat(shortDateFormat);
                }
                //return formatter.parse(value);
                return LocalDateTime.parse(value,df);
            } else if (value.matches(timeStampFormat)) {
                //时间戳
                Long lDate = new Long(value);
                return LocalDateTime.parse(value,df);
            } else if (value.contains("/")) {
                SimpleDateFormat formatter;
                if (value.contains(":")) {
                    // yyyy/MM/dd HH:mm:ss 格式
                    formatter = new SimpleDateFormat(dateFormata);
                } else {
                    // yyyy/MM/dd 格式
                    formatter = new SimpleDateFormat(shortDateFormata);
                }
                return LocalDateTime.parse(value,df);
            }
        } catch (Exception e) {
            throw new RuntimeException(String.format("parser %s to Date fail", value));
        }
        throw new RuntimeException(String.format("parser %s to Date fail", value));
    }
}
//测试用
