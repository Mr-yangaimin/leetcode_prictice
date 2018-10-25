package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/9/27.
 */
public class TestLongestCommonPrefix {

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串 ""。
     * <p>
     * 示例 1:
     * <p>
     * 输入: ["flower","flow","flight"]
     * 输出: "fl"
     * <p>
     * 注意：所有输入只包含小写字母 a-z,并且传入的数组长度不定
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
     * 一种很容易想到的算法解决方案
     * 任取数组中的一个字符串作为目标结果，从他的每一位字符开始，如果所有的字符串都以其开头
     * 那么往后递增截取后一位字符组成新的目标结果串，再次让所有的字符串去匹配，直到匹配失败或者循环结束
     * <p>
     * 假设传入具有 n 个字符串的数组，结果字符串的长度为 m，那么，
     *
     * 时间复杂度：O(m*n)，空间复杂度：O(n)
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
                    //不存在符合条件的公共字串
                    return "";
                } else {
                    //返回符合条件的公共字串
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
