package com.single;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by acer on 2018/10/30.
 */
public class TestStrStr {

    /**
     * 实现 strStr() 函数，功效等同于 Java 里面的 indexOf(String str) 方法
     * <p>
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     */

    @Test
    public void test() {
        String haystack, needle;
        haystack = "mississippi";
        needle = "pi";
        int count = strStr(haystack, needle);
        System.out.println(count);
    }

    /**
     * 遍历其中任意一个字符串，str1，直到匹配了 str2 字符串的第一个字符为止
     * <p>
     * 接着匹配此位置后面的连续字符是否能够匹配整个 str2，如果能返回当前位置索引即可
     * 否则，从当前位置开始重新第一个步骤
     *
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()){
            return -1;
        }
        if (haystack.length() == 0 || needle.length() == 0){
            return 0;
        }

        char ch = needle.charAt(0);
        char hay;
        for (int i = 0; i < haystack.length(); i++){
            hay = haystack.charAt(i);
            if (hay == ch){
                //找到一个可能匹配的点
                if ((haystack.length() - i) < needle.length()){
                    return -1;
                }
                if ((haystack.length() - i) == needle.length()){
                    if (haystack.substring(i,haystack.length()).equals(needle)){
                        return i;
                    }else{
                        return -1;
                    }
                }
                String str = haystack.substring(i,needle.length() + i);
                if (str.equals(needle)){
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 最优秀的实现还是看 jdk 的indexOf 方法的实现情况
     * @param haystack
     * @param needle
     * @return
     */
    private int strStr2(String haystack,String needle){
        return haystack.indexOf(needle);
    }
}
