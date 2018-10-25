package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/9/27.
 */
public class TestPalindrome {

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * 你能不将整数转为字符串来解决这个问题吗？通过纯数值运算来解决这个问题
     */
    @Test
    public void test() {
        System.out.println(isPalindrome(12321));
        System.out.println(isPalindrome(2432432));
        System.out.println(isPalindrome(123321));
        System.out.println(isPalindrome(121312312));
        System.out.println(isPalindrome(55555555));
        System.out.println(isPalindrome(-2147447412));
    }

    /**
     * 这是典型的一种利用特殊数据结构快速实现的模式
     * 虽然没有用字符串实现，但是是按照字符串的逻辑进行类比处理的，想比之下并没有第二种实现优雅
     * <p>
     * 时间复杂度为：O(logx)，空间复杂度为：O(1)
     *
     *
     *
     * @param x
     * @return
     */
    private boolean isPalindrome(int x) {
        boolean flag = true;
        int[] array = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 2147483647};
        int i = 0;
        if (x < 0) {
            return false;
        }
        if (x < 10) {
            return true;
        }
        //判断 x 是一个几位数
        while (x > array[i]) {
            i++;
        }
        int j = 0, lower, high;
        while (j <= (i - 1) / 2) {

            if (j == 0) {
                lower = x % 10;
                high = x / array[i - j - 1];
                if (lower != high) {
                    flag = false;
                    break;
                }
                j++;
                continue;
            }

            //取低位，j 这个位置
            lower = (x / array[j]) % 10;
            //取高位，i-j 这个位置
            high = x / array[i - j - 1] % 10;
            if (lower != high) {
                flag = false;
                break;
            }
            j++;
        }

        return flag;
    }

    /**
     * 官方答案
     * <p>
     * 时间复杂度和空间复杂度和上一种实现是一样的，但是代码量是很少的，值得借鉴
     * <p>
     * 一边反转整数，一边切，如果最后两个变量的值是相等的，必然是回文数
     *
     * @param x
     * @return
     */
    private boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
