package com.cyy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by acer on 2018/11/8.
 */
public class TestPlusOne {

    /**
     * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储一个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,2,3]
     * 输出: [1,2,4]
     * 解释: 输入数组表示数字 123。
     * 示例 2:
     * <p>
     * 输入: [4,3,2,1]
     * 输出: [4,3,2,2]
     * 解释: 输入数组表示数字 4321。
     * <p>
     * 难点不在于给数组最后一个元素增一，而在于增一后是否会产生自身的进位以及进位后
     * 是否会导致高位的再次进位，这是一个难点所在。
     */
    @Test
    public void test() {
        int[] nums = {4,3,2,1};
        int[] res = plusOne(nums);
        for (int count : res){
            System.out.println(count);
        }
    }

    /**
     * 最容易想到的一种简单暴力的解决方案：将数组中的元素转换成一个具体的整数，然后自增再拆分即可
     *
     * 这种解决方式存在一个隐形的忧患，就是当传入的数组长度超过 long 类型所能表述的最大数值长度时候，
     * 必然会由于数值溢出而得到错误的结果。同样，这个方法在 LeetCode 上是跑不通的，因为当传入数组为：
     * [7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6] 时，
     * 我们的程序就挂了，并非指出现什么异常什么的错误，而是由于 long 类型数值溢出成另一个不相关的值而
     * 导致的程序计算错误。
     * @param digits
     * @return
     */
    private int[] plusOne(int[] digits) {
        long count = 0;
        for (int num : digits){
            count = count * 10 + num;
        }
        count++;
        List<Long> list = new ArrayList<>();
        while(true){
            if (count < 10){
                list.add(count);
                break;
            }else{
                long high = count/10;
                long low = count - high*10;
                list.add(low);
                count = count/10;
            }
        }
        int[] result = new int[list.size()];
        int flag = result.length -1;
        for (Long l : list){
            int x = l.intValue();
            result[flag] = x;
            flag--;
        }
        return result;
    }

    /**递归思想：每一个元素加一之后判断下是否会产生进位操作，如果有则向上递归即可，否则更改数组的值并返回即可
     *
     * 时间复杂度：
     * 最好时间复杂度为：O(1)，最坏时间复杂度为：O(n)
     * @param digits
     * @return
     */
    private int[] plusOne1(int[] digits) {
        int count = digits[digits.length -1];
        switch(count){
            case 0:
                digits[digits.length -1] = 1;
                break;
            case 1:
                digits[digits.length -1] = 2;
                break;
            case 2:
                digits[digits.length -1] = 3;
                break;
            case 3:
                digits[digits.length -1] = 4;
                break;
            case 4:
                digits[digits.length -1] = 5;
                break;
            case 5:
                digits[digits.length -1] = 6;
                break;
            case 6:
                digits[digits.length -1] = 7;
                break;
            case 7:
                digits[digits.length -1] = 8;
                break;
            case 8:
                digits[digits.length -1] = 9;
                break;
            case 9:
                digits[digits.length -1] = 0;
                if (digits.length == 1){
                    int[] newArray = {1,0};
                    digits = newArray;
                    break;
                }
                int[] result = plusOne1(Arrays.copyOf(digits,digits.length -1));
                //处理返回的数组数据
                digits = Arrays.copyOf(result,result.length + 1);
                digits[digits.length - 1] = 0;
                break;
        }

        return digits;
    }
}