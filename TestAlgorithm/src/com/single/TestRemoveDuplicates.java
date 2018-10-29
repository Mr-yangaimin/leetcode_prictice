package com.single;

import org.junit.Test;

/**
 * Created by Walker on 2018/10/19.
 */
public class TestRemoveDuplicates {

    /**
     * ɾ�����������е��ظ���:
     * <p>
     * ����һ���������飬����Ҫ��ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ��ÿ��Ԫ��ֻ����һ�Σ������Ƴ���������³��ȡ�
     * <p>
     * ��Ҫʹ�ö��������ռ䣬�������ԭ���޸��������鲢��ʹ�� O(1) ����ռ����������ɡ�
     * ����ȷ�Ŀռ临�Ӷȣ�Ҳ����˵������������Ŀռ䣬������ͨ���ȽϺͽ�����˼ά��ʽ��ʵ�֣�
     * <p>
     * ʾ�� 1:
     * <p>
     * �������� nums = [1,1,2],
     * <p>
     * ����Ӧ�÷����µĳ��� 2, ����ԭ���� nums ��ǰ����Ԫ�ر��޸�Ϊ 1, 2��
     * <p>
     * �㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
     * ʾ�� 2:
     * <p>
     * ���� nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * ����Ӧ�÷����µĳ��� 5, ����ԭ���� nums ��ǰ���Ԫ�ر��޸�Ϊ 0, 1, 2, 3, 4��
     * <p>
     * ����ؼ��㣺1����������飬2������Ҫ���ǳ����³��ȵ�Ԫ��
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
     * �����ƶ������Ƚ���������Ԫ�أ������ͬ��ڶ���Ԫ�غ������е�Ԫ��������ǰ�ƶ���
     * �����ڸ��ǵ��ظ����Ǹ�Ԫ�ء����磺
     * nums = [1,1,2]���ȽϷ������� 0 �� 1 λ�ô�����Ԫ�ص�ֵ����ͬ�ģ����ǽ����� 1 �������е�Ԫ����ǰ�ƶ�һλ��
     * ������ 2 ������ nums[1]��
     * <p>
     * ����ʵ�ֵ�ʱ�临�ӶȽ�Ϊ���ӣ����� n^2 ����ģ�����Ե�Ч�ʵ�˼��
     *
     * @param array
     * @return
     */
    private int removeDuplicates(int[] array) {
        //����ظ�Ԫ�صĸ���
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                break;
            }
            if (array[i + 1] == array[i] && array[i] != array[array.length-1]) {
                //i+1 λ�ú��������Ԫ��ȫ����ǰ�ƶ�һ��λ�ü���
                for (int j = i + 1; j < array.length; j++) {
                    if (j == array.length - 1) {
                        break;
                    }
                    array[j] = array[j + 1];
                }
                i--;
            }
        }
        //�ҳ��������˵�Ԫ�صĸ���
        //����ǰϵ�Ĳ���������������Ч�����ڵ�Ԫ�ر�Ȼ������������ظ���
        //��ô��һ���ظ���Ԫ��λ�ü���ЧԪ�ص�ͷ
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
     * ʹ������ָ��������ͬһ�����飬������һ��˼·�����Ҳ�ͬ��Ԫ�ء��������ǰԪ�ص�������
     * ǰһ��Ԫ�أ�˵�����Ԫ�ز�������Ҫ��Ԫ�أ������ߣ�֪���ҵ�һ����ͬ��Ԫ�أ����ǰ�����
     * ǰ���λ�ý��б���
     *
     * ʱ�临�Ӷ�Ϊ��O(n);
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
