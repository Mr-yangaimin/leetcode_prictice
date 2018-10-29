package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/10/19.
 */
public class TestRemoveDuplicates {

    /**
     * 删除排序数组中的重复项:
     * <p>
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     * （明确的空间复杂度，也就是说不允许创建额外的空间，引导你通过比较和交换的思维方式来实现）
     * <p>
     * 示例 1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例 2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * 解题关键点：1、有序的数组，2、不需要考虑超出新长度的元素
     */

    @Test
    public void test() {
        int[] array = new int[]{0,1,2,3,4,4};
        int length = removeDuplicates2(array);
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
    }

    /**
     * 整体移动法：比较相邻两个元素，如果相同则第二个元素后面所有的元素整体向前移动，
     * 以至于覆盖掉重复的那个元素。例如：
     * nums = [1,1,2]，比较发现索引 0 和 1 位置处两个元素的值是相同的，于是将索引 1 后面所有的元素向前移动一位，
     * 即导致 2 覆盖了 nums[1]。
     * <p>
     * 这种实现的时间复杂度较为复杂，至少 n^2 级别的，是相对低效率的思想
     *
     * @param array
     * @return
     */
    private int removeDuplicates(int[] array) {
        //完成重复元素的覆盖
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                break;
            }
            if (array[i + 1] == array[i] && array[i] != array[array.length-1]) {
                //i+1 位置后面的所有元素全部向前移动一个位置即可
                for (int j = i + 1; j < array.length; j++) {
                    if (j == array.length - 1) {
                        break;
                    }
                    array[j] = array[j + 1];
                }
                i--;
            }
        }
        //找出被覆盖了的元素的个数
        //由于前系的操作，整个数组有效长度内的元素必然是有序的且无重复的
        //那么第一个重复的元素位置即无效元素的头
        int count = -1;
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) break;
            if (array[i+1] == array[i]){
                count = i+1;
                break;
            }
        }
        return count == -1 ? array.length : count;
    }

    /**
     * 使用两个指针来操作同一个数组，基本是一个思路，“找不同的元素”，如果当前元素等于他的
     * 前一个元素，说明这个元素不是我们要的元素，往后走，知道找到一个不同的元素，我们把他往
     * 前面的位置进行保存
     *
     * 时间复杂度为：O(n);
     *
     * @param nums
     * @return
     */
    private int removeDuplicates2(int[] nums) {
        if(nums.length == 0) return 0;
        int ans = 1;
        for(int i = 1 ; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) continue;
            nums[ans++] = nums[i];
        }
        return ans;
    }
}
