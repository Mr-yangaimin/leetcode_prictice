package com.single;

import org.junit.Test;

/**
 * Created by acer on 2018/10/30.
 */
public class TestRemoveElement {

    /**
     * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * 示例 1:
     * <p>
     * 给定 nums = [3,2,2,3], val = 3,
     * <p>
     * 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,1,2,2,3,0,4,2], val = 2,
     * <p>
     * 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
     * <p>
     * 注意这五个元素可为任意顺序。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     */

    @Test
    public void test() {
        int[] nums = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int var = 2;
        int count = removeElement2(nums, var);
        for (int i = 0; i < count; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 整体移动法：
     * 与上一道题目具有相似的逻辑，通过不断的移动元素实现
     * <p>
     * 这种解法不再赘述，时间复杂度较高并且代码逻辑实现复杂
     *
     * @param nums
     * @param val
     * @return
     */
    private int removeElement(int[] nums, int val) {
        int count = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                //特殊情况的判断
                boolean flag = true;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] != nums[j]) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    return i;
                }

                //说明当前元素需要被删除
                if (i + 1 == nums.length) {
                    //说明这个元素是整个数组的最后元素，无需覆盖操作
                    return --count;
                }
                //通过移动覆盖来删除当前元素
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                }
                count--;
                i--;

            }
        }
        return count;
    }

    /**
     * 多指针读取法：
     * 这种思想其实是一种借鉴了选择排序算法思想的思路，选择我们要的元素，过滤不需要的元素
     * @param nums
     * @param val
     * @return
     */
    private int removeElement2(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != val){
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
