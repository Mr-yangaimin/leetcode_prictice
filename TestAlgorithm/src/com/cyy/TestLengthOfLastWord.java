package com.cyy;

import org.junit.Test;

/**
 * Created by acer on 2018/11/8.
 */
public class TestLengthOfLastWord {

    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * <p>
     * 如果不存在最后一个单词，请返回 0 。
     * <p>
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: "Hello World"
     * 输出: 5
     */
    @Test
    public void test() {
        int count = lengthOfLastWord("a ");
        System.out.println(count);
    }

    /**
     * 这个题目初看起来可以说是非常简单了，但是目标输入的值可能会很坑，比如不是个正常的句子，
     * 空格随意的出现，加一个标志位判断处理下即可
     * @param s
     * @return
     */
    private int lengthOfLastWord(String s) {
        int count = 0;
        boolean flag = true;
        for (int i = s.length() -1; i >= 0; i--){
            if (flag){
                //默认是开启检查的
                if (s.charAt(i) == ' '){
                    continue;
                }
                flag = false;
            }
            if (s.charAt(i) != ' '){
                count++;
            }else{
                break;
            }
        }
        return count;
    }
}
