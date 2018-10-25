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
     给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

     你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。

     示例:

     给定 nums = [2, 7, 11, 15], target = 9

     因为 nums[0] + nums[1] = 2 + 7 = 9
     所以返回 [0, 1]

     */
    @Test
    public void testTwoSum(){
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = twoSum3(nums,target);
        if (result != null) {
            System.out.println(nums[result[0]] + "+" + nums[result[1]] + "=" + target);
        } else {
            System.out.println("没有符合要求的两个元素!");
        }
    }

    /**
     * 暴力破解
     * 时间复杂度为：O(n^2)
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
     * 两次的 HashMap 迭代，时间复杂度降至 O(n)
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
            //自己和自己加等于目标值，不能算
            if (map.containsKey(temp) && map.get(temp) != i){
                return new int[]{i,map.get(temp)};
            }
        }
        return null;
    }

    /**
     * 压缩至一次 HashMap 迭代完成，时间复杂度 O(n)
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

    //实现二和实现三时间复杂度是一样的，只不过实现三将代码集成了一下
}
