package 排序.简单排序;

import java.util.Arrays;

import static util.SwapUtil.swap;


/**
 * 算法思想: 不断交换相邻元素,将较大的元素逐渐冒泡到数组的末尾
 */
public class 冒泡排序 {

    /**
     * 初始版本
     * 外层循环次数: 数组长度 - 1
     * 内层比较次数: 最后一个没有排序过元素的索引
     */
    public static void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = 1; i <= n - 1; i++) {
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }
            }
            System.out.println("第" + i + "轮冒泡: " + Arrays.toString(nums) + ", 比较次数:" + (n - i));
        }
    }

    /**
     * 优化1: 记录本次冒泡是否发生交换,如果一次交换都没有,直接结束循环
     */
    public static void bubbleSort_v1(int[] nums) {
        int n = nums.length;
        boolean swapped;
        for (int i = 1; i <= n - 1; i++) {
            // 本次冒泡是否发生交换
            swapped = false;
            for (int j = 0; j < n - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    swapped = true;
                }
            }
            System.out.println("第" + i + "轮冒泡: " + Arrays.toString(nums) + ", 比较次数:" + (n - i));
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
        while (n > 0) {
            // 最后一次发生交换元素的索引
            int last = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    last = j;
                }
            }
            i++;
            System.out.println("第" + i + "轮冒泡: " + Arrays.toString(nums) + ", 比较次数: " + n);
            n = last;
        }
    }
}
