package com.single;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Walker
 */
public class TestTwoSumAdd {

    /**
     *
     *
     ����һ�����������һ��Ŀ��ֵ���ҳ������к�ΪĿ��ֵ����������

     ����Լ���ÿ������ֻ��Ӧһ�ִ𰸣���ͬ����Ԫ�ز��ܱ��ظ����á�

     ʾ��:

     ���� nums = [2, 7, 11, 15], target = 9

     ��Ϊ nums[0] + nums[1] = 2 + 7 = 9
     ���Է��� [0, 1]

     */
    @Test
    public void testTwoSum(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum3(nums,target);
        if (result != null) {
            System.out.println(nums[result[0]] + "+" + nums[result[1]] + "=" + target);
        } else {
            System.out.println("û�з���Ҫ�������Ԫ��!");
        }
    }

    /**
     * �����ƽ�
     * ʱ�临�Ӷ�Ϊ��O(n^2)
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum(int[] nums, int target){
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++){
            for (int j = i+1; j < nums.length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

    /**
     * ���ε� HashMap ������ʱ�临�ӶȽ��� O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>(16);
        int i;
        for (i = 0; i < nums.length; i++){
            map.put(nums[i],i);
        }

        for (i = 0; i < nums.length; i++){
            int temp = target - nums[i];
            //�Լ����Լ��ӵ���Ŀ��ֵ��������
            if (map.containsKey(temp) && map.get(temp) != i){
                return new int[]{i,map.get(temp)};
            }
        }
        return null;
    }

    /**
     * ѹ����һ�� HashMap ������ɣ�ʱ�临�Ӷ� O(n)
     * @param nums
     * @param target
     * @return
     */
    private int[] twoSum3(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>(16);
        int temp;
        for (int i = 0; i < nums.length; i++){
            temp = target - nums[i];
            if(map.containsKey(temp)){
                return new int[]{map.get(temp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }

    //ʵ�ֶ���ʵ����ʱ�临�Ӷ���һ���ģ�ֻ����ʵ���������뼯����һ��
}
