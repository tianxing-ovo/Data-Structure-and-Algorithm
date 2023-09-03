package 排序;

public interface Array {
    int[] nums = {5, 3, 7, 2, 9, 8, 1, 4};

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
