package 排序;

import java.util.Arrays;

import static 排序.Array.nums;

public class 归并排序 {

    public static void main(String[] args) {
        int[] temp = new int[nums.length]; //临时数组
        mergeSort(nums, temp, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 归并排序
     */
    private static void mergeSort(int[] nums, int[] temp, int l, int r) {
        if (l < r) {
            int mid = (l + r) >>> 1;
            mergeSort(nums, temp, l, mid);
            mergeSort(nums, temp, mid + 1, r);
            int p = 0; //临时数组指针
            int i = l; //[l,mid]区间指针
            int j = mid + 1; //[mid+1,r]区间指针
            while (i <= mid && j <= r) {
                temp[p++] = nums[i] < nums[j] ? nums[i++] : nums[j++]; //取较小值
            }
            while (i <= mid) {
                temp[p++] = nums[i++];
            }
            while (j <= r) {
                temp[p++] = nums[j++];
            }
            //源数组 源数组开始索引 目标数组 目标数组开始索引 复制的数组元素的数量
            System.arraycopy(temp, 0, nums, l, r - l + 1); //复制temp到nums中
        }
    }
}
