package com.cyy;

import org.junit.Test;

/**
 * Created by acer on 2018/11/7.
 */
public class TestMaxSubArray {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    @Test
    public void test() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    /**
     * 暴力破解法：遍历整个数组，使用每个元素做为起始点，逐个累加后续的节点，并保存最大值
     *
     * 最大和的子序列必然是整个序列的一个子部分，也就是说必然会以序列的某个节点为起始点，
     * 所以我们只要遍历每一个节点，找到每一个节点下可能出现的最大值即可
     *
     * @param nums
     * @return
     */
    private int maxSubArray(int[] nums) {
        int sum,current,max = nums[0];
        for (int i = 0; i < nums.length; i++){
            sum = nums[i];
            current = nums[i];
            for (int j = i+1; j < nums.length; j++){
                current += nums[j];
                if (current > sum){
                    sum = current;
                }
            }
            //循环出来后，sum 的值就是以当前元素为起点节点的序列最大值
            if (sum >= max){
                max = sum;
            }
        }
        return max;
    }

    /** 网上看到的一个扫描法：时间复杂度为 O(n)
     * 说实话，想出这个算法的人的确值得佩服
     * 例如：[-2,1,-3,4,-1,2,1,-5,4]
     * @param nums
     * @return
     */
    private int maxSubArray1(int[] nums) {
        int current = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (current <= 0){
                //当前节点之前的所有和为负值
                current = nums[i];
            }else{
                current += nums[i];
            }

            if (current > sum){
                sum = current;
            }
        }
        return sum;
    }
}
