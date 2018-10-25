package com.single;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Walker on 2018/9/19.
 */
public class TestReverseTwo {


    /**
     * ����һ�� 32 λ�з����������������е����ֽ��з�ת��
     * <p>
     * ʾ�� 1:
     * <p>
     * ����: 123
     * ���: 321
     * ʾ�� 2:
     * <p>
     * ����: -123
     * ���: -321
     * ʾ�� 3:
     * <p>
     * ����: 120
     * ���: 21
     * <p>
     * ���ֵ�ȡֵ��Χ��[-2147483648,2147483647]
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
     * ��򵥴ֱ���ʵ�֣�ʱ�临�Ӷ�Ϊ��O(n^2)
     * ʵ�ֵ�˼·�ֲܴڣ�����Ĵ�������ǣ�ʹ��һ����������ͱ�������ͬʱ���������û��
     * �������������������ֵ����ȣ�����Ļ������´����ͱ�����ʾ����ֵ����С���ͱ�����ʾ����ֵ
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

        //����������
        if (result < data) {
            return 0;
        }
        if (flag == 0) {
            result = -result;
        }
        return result;
    }

    /**
     * ʵ�ֵĺ����ʱ�临�Ӷ�Ϊ��O(log(n))
     *
     * @param num
     * @return
     */
    public int reverse2(int num) {
        int rev = 0;
        while (num != 0) {
            int pop = num % 10;
            num /= 10;
            //rev = rev * 10 + pop ���ܷ�����������Կ�����ǰ���м�飬�ж��Ƿ���ܷ������
            //Integer.MAX_VALUE = 2147483647�������������
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            //Integer.MIN_VALUE = -2147483648�����������
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;

            //��Ҫ��ȷһ����ǣ�temp = rev / 10;  rev != temp * 10;�����������ɵ���λ
        }
        return rev;

    }
}
