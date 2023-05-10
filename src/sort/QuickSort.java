package sort;

import java.util.Arrays;

public class QuickSort {
    public int[] quickSort(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int pivotIdx = partition(nums, left, right);
        quickSort(nums, left, pivotIdx - 1);
        quickSort(nums, pivotIdx + 1, right);
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(Arrays.toString(quickSort.quickSort(new int[]{5,2,3,1})));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(Arrays.toString(quickSort.quickSort(new int[]{5,1,1,2,0,0})));
        System.out.println();
    }
}
