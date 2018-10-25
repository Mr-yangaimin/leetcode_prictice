package com.single;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Walker on 2018/9/27.
 */
public class TestRomanToInt {

    /**
     * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
     * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
     * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
     * <p>
     * 输入: "III"
     * 输出: 3
     */
    @Test
    public void test() {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    /**
     * 时间复杂度：O(n)，取决于输入的字符串的长度
     * 空间复杂度：O(n)，取决于输入的字符串的长度
     *
     * @param s
     * @return
     */
    private int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap(16);
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        char[] chars = s.toCharArray();
        String str;
        for (int i = 0; i < chars.length; i++) {
            //特殊情况处理
            if ((i + 1) < chars.length && map.get(String.valueOf(chars[i])) < map.get(String.valueOf(chars[i + 1]))) {
                str = String.valueOf(chars[i]) + String.valueOf(chars[i + 1]);
                switch (str) {
                    case "IV":
                        result += 4;
                        break;
                    case "IX":
                        result += 9;
                        break;
                    case "XL":
                        result += 40;
                        break;
                    case "XC":
                        result += 90;
                        break;
                    case "CD":
                        result += 400;
                        break;
                    case "CM":
                        result += 900;
                        break;
                }
                i++;
                continue;
            }
            //正常情况
            result += map.get(String.valueOf(chars[i]));
        }

        return result;
    }
}
