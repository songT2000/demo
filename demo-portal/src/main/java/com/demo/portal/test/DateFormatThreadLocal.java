package com.demo.portal.test;




import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatThreadLocal {

    private static final ThreadLocal<SimpleDateFormat> df = new ThreadLocal<SimpleDateFormat>() {

        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };


    public static Date convert(String str) throws ParseException {
        return df.get().parse(str);
    }

    public static void main(String[] args) {
        System.out.println(123123);
    }

}
