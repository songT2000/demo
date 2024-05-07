package com.demo.portal.test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Java8Tester  {
    public static void main(String args[]) {
//        final int num = 1;
//        Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));
//        s.convert(2);  // 输出结果为 3
//
//        ComparatorT<String> comparator = (first) -> {
//            return "王二麻子";
//        };
//        System.out.println(comparator.convert("王二麻子"));
//
//        List<String> names1 = new ArrayList<String>();
//        names1.add("Google ");
//        names1.add("Runoob ");
//        names1.add("Taobao ");
//        names1.add("Baidu ");
//        names1.add("Sina ");
//
//        List<String> names2 = new ArrayList<String>();
//        names2.add("Google ");
//        names2.add("Runoob ");
//        names2.add("Taobao ");
//        names2.add("Baidu ");
//        names2.add("Sina ");
//
//        Java8Tester tester = new Java8Tester();
//        System.out.println("使用 Java 7 语法: ");
//
//        tester.sortUsingJava7(names1);
//        System.out.println(names1);
//        System.out.println("使用 Java 8 语法: ");
//
//        tester.sortUsingJava8(names2);
//        System.out.println(names2);

//        System.out.println("1========================1");
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//        eval(list, n->2==2);

//        List<String>strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
//        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
//
//        System.out.println("筛选列表: " + filtered);
//        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
//        System.out.println("合并字符串: " + mergedString);

//        // 获取当前的日期时间
//        LocalDateTime currentTime = LocalDateTime.now();
//        System.out.println("当前时间: " + currentTime);
//
//        LocalDate date1 = currentTime.toLocalDate();
//        System.out.println("date1: " + date1);
//
//        Month month = currentTime.getMonth();
//        int day = currentTime.getDayOfMonth();
//        int seconds = currentTime.getSecond();
//
//        System.out.println("月: " + month +", 日: " + day +", 秒: " + seconds);
//
//        LocalDateTime date2 = currentTime.withDayOfMonth(10).withYear(2012);
//        System.out.println("date2: " + date2);
//
//        // 12 december 2014
//        LocalDate date3 = LocalDate.of(2014, Month.DECEMBER, 12);
//        System.out.println("date3: " + date3);
//
//        // 22 小时 15 分钟
//        LocalTime date4 = LocalTime.of(22, 15);
//        System.out.println("date4: " + date4);
//
//        // 解析字符串
//        LocalTime date5 = LocalTime.parse("20:15:30");
//        System.out.println("date5: " + date5);
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        Stream<Integer> stream = list.stream().filter(i -> {
//            System.out.println("Stream API中间操作");
//            return i > 5;
//        });
//        stream.forEach(System.out::println);
//        System.out.println( LocalDateTime.now().plusSeconds(60));


//        // 获取当前日期
//        LocalDate currentDate = LocalDate.now();
//
//        // 获取当日开始时间（凌晨 00:00:00）
//        LocalDateTime startOfDay = currentDate.atStartOfDay();
//
//        // 获取当日结束时间（23:59:59）
//        LocalDateTime endOfDay = LocalDateTime.of(currentDate, LocalTime.MAX);
//
//        System.out.println("Start of Day: " + startOfDay);
//        System.out.println("End of Day: " + endOfDay);
//
        // 获取两个 LocalDateTime 对象
        LocalDateTime dateTime1 = LocalDateTime.now();
        LocalDateTime dateTime2 = LocalDateTime.now().plusMinutes(30); // 假设 dateTime2 比 dateTime1 多半个小时
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        // 计算两个时间的差
        Duration duration = Duration.between(dateTime1, dateTime2);

        // 判断是否相差半个小时
        if (duration.toMinutes() >= 30) {
            System.out.println("两个时间相差半个小时或以上");
        } else {
            System.out.println("两个时间相差不到半个小时");
        }

    }

    public static void eval(List<Integer> list, Predicate<Integer> predicate) {
        for(Integer n: list) {

            if(predicate.test(n)) {
                System.out.println(n + " ");
            }
        }
    }

    // 使用 java 7 排序
    private void sortUsingJava7(List<String> names){
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
    }

    // 使用 java 8 排序
    private void sortUsingJava8(List<String> names){
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
    }

    public interface Converter<T1, T2> {
        void convert(int i);
    }

    public interface ComparatorT<T> {
        String convert(T i);

//        int convertT(T i , T j);
    }
}
