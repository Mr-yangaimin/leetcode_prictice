package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/9/27.
 */
public class TestLongestCommonPrefix {

    /**
     * ��дһ�������������ַ��������е������ǰ׺��
     * <p>
     * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
     * <p>
     * ʾ�� 1:
     * <p>
     * ����: ["flower","flow","flight"]
     * ���: "fl"
     * <p>
     * ע�⣺��������ֻ����Сд��ĸ a-z,���Ҵ�������鳤�Ȳ���
     */
    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"a", "a"}));
        System.out.println(longestCommonPrefix(new String[]{"cxa", "ccx"}));
        System.out.println(longestCommonPrefix(new String[]{"axcv", "avxcv"}));
        System.out.println(longestCommonPrefix(new String[]{"adfs", "ads"}));
        System.out.println(longestCommonPrefix(new String[]{"aqqq", "aqqq"}));
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "aa"}));
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"aa", "ab"}));

    }

    /**
     * һ�ֺ������뵽���㷨�������
     * ��ȡ�����е�һ���ַ�����ΪĿ������������ÿһλ�ַ���ʼ��������е��ַ��������俪ͷ
     * ��ô���������ȡ��һλ�ַ�����µ�Ŀ���������ٴ������е��ַ���ȥƥ�䣬ֱ��ƥ��ʧ�ܻ���ѭ������
     * <p>
     * ���贫����� n ���ַ��������飬����ַ����ĳ���Ϊ m����ô��
     *
     * ʱ�临�Ӷȣ�O(m*n)���ռ临�Ӷȣ�O(n)
     *
     * @param strs
     * @return
     */
    private String longestCommonPrefix(String[] strs) {
        if (strs.length <= 0) {
            return "";
        }

        String reg = strs[0];
        boolean isExisit = true;
        for (int i = 0; i < reg.length(); i++) {
            String temp;
            if (i == 0) {
                temp = reg.substring(0, 1);
            } else {
                temp = reg.substring(0, i + 1);
            }
            for (String str : strs) {
                if (!str.startsWith(temp)) {
                    isExisit = false;
                    break;
                }
            }
            if (!isExisit) {
                if (temp.length() == 1) {
                    //�����ڷ��������Ĺ����ִ�
                    return "";
                } else {
                    //���ط��������Ĺ����ִ�
                    if (temp.length() == 2) {
                        return temp.substring(0, 1);
                    } else {
                        return temp.substring(0, temp.length() - 1);
                    }
                }
            }
        }
        return reg;
    }

}
