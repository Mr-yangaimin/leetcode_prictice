package com.single;

import org.junit.Test;

/**
 * Created by acer on 2018/11/7.
 */
public class TestSearchInsert {

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
     * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     */
    @Test
    public void test() {
        int[] nums = {1,3,5,6};
        int target = 7;
        int result = searchInsert(nums,target);
        System.out.println(result);
    }

    /**
     * 最简单的实现就是，直接遍历一遍，如果找到等于目标值的元素，返回索引即可，
     * 否则找到第一个大于目标值的元素，并返回该元素的索引
     *
     * 时间复杂度：O();
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= target ){
                return i;
            }
        }
        return nums.length;
    }

    /** 本题的一个核心点在于找到一个目标值，所以本质上来说，这道题目就是一道查找算法题
     *
     * 所以会有很多的解法，二分等其他查找算法。这里我们再次实现一个二分查找算法
     * @param nums
     * @param target
     * @return
     */
    private int searchInsert1(int[] nums, int target){
        int start,end,middle;
        start = 0;
        end = nums.length -1;
        do {
            middle = (start + end)/2;
            if (nums[middle] == target){
                //找到了
                return middle;
            }
            if (nums[middle] < target){
                //目标值过大,在队列后半部分
                start = middle + 1;
            }
            if (nums[middle] > target){
                //目标值过小，在队列的前半部分
                end = middle - 1;
            }
        }while(start <= end);
        //如果数组没有找到 target 目标值，那么判断目标值应该被插入的位置
        return nums[middle] > target ? middle: middle + 1;
    }
}
