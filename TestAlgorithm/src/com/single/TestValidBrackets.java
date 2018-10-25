package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/10/12.
 */
public class TestValidBrackets {

    /**
     * 有效的括号问题
     * <p>
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 注意空字符串可被认为是有效字符串。
     */
    @Test
    public void test() {
        System.out.println(isValid("(fdsf)"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{(fd[s]f)fasd}"));
        System.out.println(isValid("{(fd[}"));
    }

    /**
     * 能够想到使用栈这种数据结构，基本上就算是能解开了，
     * 通过将左括号全部入栈，而遇到右括号时匹配栈顶元素是否是自己的另一半即可
     *
     * 假设字符串长度为 n，
     *
     * 时间复杂度为：O(n)，空间复杂度为：O(n)
     * @param s
     * @return
     */
    private boolean isValid(String s) {
        //可以使用栈的思想来处理这个问题，对应入栈和出栈操作
        String[] stack = new String[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            String temp = String.valueOf(s.charAt(i));
            if (temp.equals("(") || temp.equals("[") || temp.equals("{")){
                //入栈即可
                stack[count] = temp;
                count++;
            }
            //结束的半边括号是需要出栈顶元素进行匹配的
            if (temp.equals(")")){
                if (count == 0){
                    return false;
                }
                String value = stack[count-1];
                if ("(".equals(value)){
                    count--;
                }else{
                    return false;
                }
            }

            if (temp.equals("]")){
                if (count == 0){
                    return false;
                }
                String value = stack[count-1];
                if ("[".equals(value)){
                    count--;
                }else{
                    return false;
                }
            }

            if (temp.equals("}")){
                if (count == 0){
                    return false;
                }
                String value = stack[count-1];
                if ("{".equals(value)){
                    count--;
                }else{
                    return false;
                }
            }
        }
        if (count != 0){
            return false;
        }
        return true;
    }
}
