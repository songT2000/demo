package com.demo.portal.test.guaguale;

import java.util.*;

public class ArrayPermutations {
    public static void main(String[] args) {
        // 示例数组
        String[] arr1 = {"石油", "钻石", "黄金", "白银", "铜"};
        String[] arr2 = {"石油", "钻石", "黄金", "白银", "铜"};
        Integer firstBonus = 2000;
        Integer secondBonus = 500;
        Integer thirdBonus = 200;
        List<List<String[]>> allCombinations = generateAllCombinations(arr1, arr2);

        // 打印组合数量
        System.out.println("总发行量: " + allCombinations.size());
        System.out.println("总销量: " + allCombinations.size()*2000);
        //各个奖金段的数量
        Map<Integer, Integer> bonusNum = new TreeMap<>();
        //各个奖金段的总金额
        Map<Integer, Integer> bonusTotal = new TreeMap<>();
        // 计算所有组合的中奖
        for (List<String[]> combination : allCombinations) {
            int num = 0;
            int bonus = 0;
            for (int i = 0; i <= 4; i++) {
                if (combination.get(0)[i].equals(combination.get(1)[i])) {
                    switch (combination.get(0)[i]) {
                        case "石油":
                            bonus = bonus + firstBonus;
                            num++;
                            break;
                        case "钻石":
                            bonus = bonus + secondBonus;
                            num++;
                            break;
                        case "黄金":
                            bonus = bonus + thirdBonus;
                            num++;
                            break;
                        default:
                    }
                }
            }
            if (num > 0) {
                bonus = bonus * num;
            }
            if (bonusNum.get(bonus) != null) {
                Integer temp = bonusNum.get(bonus) + 1;
                bonusNum.put(bonus, temp);
            } else {
                bonusNum.put(bonus, 1);
            }
            if (bonusTotal.get(bonus) != null) {
                Integer temp = bonusTotal.get(bonus) + bonus;
                bonusTotal.put(bonus, temp);
            } else {
                bonusTotal.put(bonus, bonus);
            }
            for (String[] arr : combination) {
                System.out.print("[");
                for (String i : arr) {
                    System.out.print(i + " ");
                }
                System.out.print("] ");
            }
            System.out.println();
        }
        // 打印组合数量
        System.out.println("---各个奖金段的数量---");
        for (Map.Entry<Integer, Integer> entry : bonusNum.entrySet()) {
            System.out.println("奖金：" + entry.getKey() + "---数量" + entry.getValue());
        }
        Integer totalBonus = 0;
        System.out.println("---各个奖金段的总金额---");
        for (Map.Entry<Integer, Integer> entry : bonusTotal.entrySet()) {
            System.out.println("奖金：" + entry.getKey() + "---金额:" + entry.getValue());
            totalBonus += entry.getValue();
        }
        System.out.println("总奖金---" + totalBonus);
    }

    // 生成所有排列的辅助方法
    public static List<String[]> generatePermutations(String[] arr) {
        List<String[]> permutations = new ArrayList<>();
        permute(arr, 0, permutations);
        return permutations;
    }

    // 全排列生成方法
    private static void permute(String[] arr, int index, List<String[]> result) {
        if (index == arr.length - 1) {
            result.add(arr.clone());
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            permute(arr, index + 1, result);
            swap(arr, index, i); // 回溯
        }
    }

    // 交换数组中的元素
    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 生成两个数组的所有组合
    public static List<List<String[]>> generateAllCombinations(String[] arr1, String[] arr2) {
        List<String[]> permutations1 = generatePermutations(arr1);
        List<String[]> permutations2 = generatePermutations(arr2);

        List<List<String[]>> allCombinations = new ArrayList<>();

        for (String[] perm1 : permutations1) {
            for (String[] perm2 : permutations2) {
                List<String[]> combination = new ArrayList<>();
                combination.add(perm1);
                combination.add(perm2);
                allCombinations.add(combination);
            }
        }

        return allCombinations;
    }
}
