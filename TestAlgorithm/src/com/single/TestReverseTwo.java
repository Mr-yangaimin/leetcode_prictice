package com.single;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Walker on 2018/9/19.
 */
public class TestReverseTwo {


    /**
     * 给定一个 32 位有符号整数，将整数中的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     * 示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * <p>
     * 数字的取值范围：[-2147483648,2147483647]
     */

    @Test
    public void test() {
        System.out.println(reverse2(123));
        System.out.println(reverse2(-123));
        System.out.println(reverse2(120));
        System.out.println(reverse2(-120));
        System.out.println(reverse2(-2147483648));
        System.out.println(reverse2(Integer.MAX_VALUE / 10));
    }

    /**
     * 最简单粗暴的实现，时间复杂度为：O(n^2)
     * 实现的思路很粗糙，溢出的处理策略是：使用一个更大的类型变量进行同时操作，如果没有
     * 发生溢出，两个变量的值是相等，溢出的话将导致大类型变量表示的数值大于小类型变量表示的数值
     *
     * @param num
     * @return
     */
    public int reverse(int num) {
        List<Long> list = new ArrayList<>(16);
        long numL = (long) num;
        long temp, flag = 1;
        if (numL < 0) {
            numL = -numL;
            flag = 0;
        }
        while (numL != 0) {
            temp = numL / 10;
            list.add(numL - (10 * temp));
            numL = temp;
        }
        int result = 0, count = 1;
        long data = 0L, index;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                count = count * 10;
            }
            index = list.get(i);
            data = index * count + data;
            result = (int) (result + index * count);
            count = 1;
        }

        //处理溢出情况
        if (result < data) {
            return 0;
        }
        if (flag == 0) {
            result = -result;
        }
        return result;
    }

    /**
     * 实现的很巧妙，时间复杂度为：O(log(n))
     *
     * @param num
     * @return
     */
    public int reverse2(int num) {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            //rev = rev * 10 + pop 可能发生溢出，所以可以提前进行检查，判断是否可能发生溢出
            //Integer.MAX_VALUE = 2147483647，处理正数情况
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            //Integer.MIN_VALUE = -2147483648，处理负数情况
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;

            //需要明确一点的是：temp = rev / 10;  rev != temp * 10;，除法运算会干掉个位
        }
        return rev;

    }
}
