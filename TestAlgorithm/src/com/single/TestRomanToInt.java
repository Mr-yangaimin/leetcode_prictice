package com.single;

import org.junit.Test;

import java.util.HashMap;

/**
 * Created by Walker on 2018/9/27.
 */
public class TestRomanToInt {

    /**
     * �������ְ������������ַ�: I�� V�� X�� L��C��D �� M��
     * <p>
     * �ַ�          ��ֵ
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * ���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II �� 27 д��  XXVII, ��Ϊ XX + V + II ��
     * <p>
     * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д�� IIII������ IV������ 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪ IX���������Ĺ���ֻ�������������������
     * <p>
     * I ���Է��� V (5) �� X (10) ����ߣ�����ʾ 4 �� 9��
     * X ���Է��� L (50) �� C (100) ����ߣ�����ʾ 40 �� 90��
     * C ���Է��� D (500) �� M (1000) ����ߣ�����ʾ 400 �� 900��
     * ����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
     * <p>
     * ����: "III"
     * ���: 3
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
     * ʱ�临�Ӷȣ�O(n)��ȡ����������ַ����ĳ���
     * �ռ临�Ӷȣ�O(n)��ȡ����������ַ����ĳ���
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
            //�����������
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
            //�������
            result += map.get(String.valueOf(chars[i]));
        }

        return result;
    }
}
