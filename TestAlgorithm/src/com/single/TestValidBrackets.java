package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/10/12.
 */
public class TestValidBrackets {

    /**
     * ��Ч����������
     * <p>
     * ����һ��ֻ���� '('��')'��'{'��'}'��'['��']' ���ַ������ж��ַ����Ƿ���Ч��
     * <p>
     * ��Ч�ַ��������㣺
     * <p>
     * �����ű�������ͬ���͵������űպϡ�
     * �����ű�������ȷ��˳��պϡ�
     * ע����ַ����ɱ���Ϊ����Ч�ַ�����
     */
    @Test
    public void test() {
        System.out.println(isValid("(fdsf)"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("{(fd[s]f)fasd}"));
        System.out.println(isValid("{(fd[}"));
    }

    /**
     * �ܹ��뵽ʹ��ջ�������ݽṹ�������Ͼ������ܽ⿪�ˣ�
     * ͨ����������ȫ����ջ��������������ʱƥ��ջ��Ԫ���Ƿ����Լ�����һ�뼴��
     *
     * �����ַ�������Ϊ n��
     *
     * ʱ�临�Ӷ�Ϊ��O(n)���ռ临�Ӷ�Ϊ��O(n)
     * @param s
     * @return
     */
    private boolean isValid(String s) {
        //����ʹ��ջ��˼��������������⣬��Ӧ��ջ�ͳ�ջ����
        String[] stack = new String[s.length()];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            String temp = String.valueOf(s.charAt(i));
            if (temp.equals("(") || temp.equals("[") || temp.equals("{")){
                //��ջ����
                stack[count] = temp;
                count++;
            }
            //�����İ����������Ҫ��ջ��Ԫ�ؽ���ƥ���
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
