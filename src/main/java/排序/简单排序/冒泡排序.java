package 排序.简单排序;

import java.util.Arrays;

import static 排序.Array.nums;
import static 排序.Array.swap;

/**
 * 不断交换相邻元素,将较大的元素逐渐冒泡到数组的末尾
 */
public class 冒泡排序 {
    /**
     * 5, 3, 7, 2, 9, 8, 1, 4
     */
    public static void main(String[] args) {
        bubbleSort_v2(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 优化1: 记录本次冒泡是否发生交换,如果一次交换都没有,直接结束循环
     */
    public static void bubbleSort_v1(int[] nums) {
        int n = nums.length;
        boolean swapped;
        for (int i = 1; i <= n - 1; i++) { // 循环次数
            swapped = false; // 本次冒泡是否发生交换
            int sum = 0; // 比较次数
            for (int j = 0; j < n - i; j++) { // 比较次数:[0,最后一个没有排序过元素的索引-1]
                sum++;
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + i + "轮冒泡:" + Arrays.toString(nums) + ",比较次数:" + sum);
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * 优化2: 记录最后一次发生交换元素的索引,如果为0,直接结束循环
     */
    public static void bubbleSort_v2(int[] nums) {
        int n = nums.length - 1;
        int i = 0;
        int last; // 最后一次发生交换元素的索引
        while (n > 0) {
            last = 0;
            int sum = 0; // 比较次数
            for (int j = 0; j < n; j++) { // 比较次数:[0,最后一个没有排序过元素的索引-1]
                sum++;
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    last = j;
                }
            }
            i++;
            n = last;
            System.out.println("第" + i + "轮冒泡:" + Arrays.toString(nums) + ",比较次数:" + sum + ",last:" + last);
        }
    }
}
