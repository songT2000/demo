package com.demo.portal.test.guaguale;

import java.util.ArrayList;
import java.util.List;

public class ArrayCombinations {
    public static void main(String[] args) {
        String[][] input = {
                {"石油", "黄金", "白银"},
                {"石油", "黄金", "白银"}
        };

        List<String> result = new ArrayList<>();
        combine(input, 0, "", result);

        // 打印所有组合
        for (String combination : result) {
            System.out.println(combination);
        }
    }

    public static void combine(String[][] input, int index, String current, List<String> result) {
        // 如果已经处理完了最后一行，则将结果加入列表中
        if (index == input.length) {
            result.add(current);
            return;
        }

        // 递归地组合当前行的每一个元素
        for (int i = 0; i < input[index].length; i++) {
            combine(input, index + 1, current + input[index][i], result);
        }
    }
}
