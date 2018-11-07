package com.cyy;

import org.junit.Test;

/**
 * Created by acer on 2018/11/7.
 */
public class TestCountAndSay {

    /**
     * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
     * <p>
     * 1.     1
     * 2.     11
     * 3.     21
     * 4.     1211
     * 5.     111221
     * 1 被读作  "one 1"  ("一个一") , 即 11。
     * 11 被读作 "two 1s" ("两个一"）, 即 21。
     * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
     * <p>
     * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
     * <p>
     * 注意：整数顺序将表示为一个字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入: 1
     * 输出: "1"
     * 示例 2:
     * 输入: 4
     * 输出: "1211"
     * <p>
     * <p>
     * 注意：解题的关键点在于看懂这个报数规则，整个报数队列其实是一个有规则的队列，
     * 后一个元素的值相关于前一个元素的值，而我们的输入 n，其实本质上就是去取
     * 队列中第 n 个元素的值。
     *
     * 而我们的算法核心就是为了写出来这个规则。
     */
    @Test
    public void test() {
        String result = countAndSay(6);
        System.out.println(result);
    }

    /** 弄清楚规则，这道题目也是不难的，主要是能想到使用递归来解决。
     * @param n
     * @return
     */
    private String countAndSay(int n) {
        if (n == 1){
            return "1";
        }else{
            String str = countAndSay(n-1);
            String result = "";
            char[] chs = str.toCharArray();
            int count = 1;
            for (int i = 0; i < chs.length; i++){
                if (i+1 < chs.length && chs[i+1] == chs[i]){
                    count++;
                    continue;
                }
                result += count + "" + chs[i];
                count = 1;
            }
            return result;
        }
    }
}
