import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static 排序.简单排序.冒泡排序.*;

/**
 * 冒泡排序测试
 */
public class BubbleSortTest {

    @Test
    public void test1() {
        int[] nums = {5, 2, 7, 4, 1, 3, 8, 9};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test2() {
        int[] nums = {5, 2, 7, 4, 1, 3, 8, 9};
        bubbleSort_v1(nums);
        System.out.println(Arrays.toString(nums));
    }

    @Test
    public void test3() {
        int[] nums = {5, 2, 7, 4, 1, 3, 8, 9};
        bubbleSort_v2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
