package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/9/27.
 */
public class TestPalindrome {

    /**
     * �ж�һ�������Ƿ��ǻ���������������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
     * ���ܲ�������תΪ�ַ�����������������ͨ������ֵ����������������
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
     * ���ǵ��͵�һ�������������ݽṹ����ʵ�ֵ�ģʽ
     * ��Ȼû�����ַ���ʵ�֣������ǰ����ַ������߼�������ȴ���ģ����֮�²�û�еڶ���ʵ������
     * <p>
     * ʱ�临�Ӷ�Ϊ��O(logx)���ռ临�Ӷ�Ϊ��O(1)
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
        //�ж� x ��һ����λ��
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

            //ȡ��λ��j ���λ��
            lower = (x / array[j]) % 10;
            //ȡ��λ��i-j ���λ��
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
     * �ٷ���
     * <p>
     * ʱ�临�ӶȺͿռ临�ӶȺ���һ��ʵ����һ���ģ����Ǵ������Ǻ��ٵģ�ֵ�ý��
     * <p>
     * һ�߷�ת������һ���У�����������������ֵ����ȵģ���Ȼ�ǻ�����
     *
     * @param x
     * @return
     */
    private boolean isPalindrome2(int x) {
        // ���������
        // ������������ x < 0 ʱ��x ���ǻ�������
        // ͬ���أ�������ֵ����һλ�� 0��Ϊ��ʹ������Ϊ���ģ�
        // �����һλ����ҲӦ���� 0
        // ֻ�� 0 ������һ����
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // �����ֳ���Ϊ����ʱ�����ǿ���ͨ�� revertedNumber/10 ȥ��������λ�����֡�
        // ���磬������Ϊ 12321 ʱ���� while ѭ����ĩβ���ǿ��Եõ� x = 12��revertedNumber = 123��
        // ���ڴ�����λ�����ֲ�Ӱ����ģ����������Լ���ȣ����������ǿ��Լ򵥵ؽ���ȥ����
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
