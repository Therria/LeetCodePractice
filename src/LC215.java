import java.util.Arrays;
import java.util.PriorityQueue;

public class LC215 {
//    // Method I : sort
//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k > nums.length) {
//            throw new IllegalArgumentException();
//        }
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

    // Method II : maxHeap

//    // Method III : minHeap
//    public int findKthLargest(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k > nums.length) {
//            throw new IllegalArgumentException();
//        }
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
//        for (int num: nums) {
//            if (minHeap.size() < k) {
//                minHeap.offer(num);
//            } else if (minHeap.peek() < num) {
//                minHeap.poll();
//                minHeap.offer(num);
//            }
//        }
//        return minHeap.poll();
//    }

    // Method IV : Quick Selection
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            throw new IllegalArgumentException();
        }

        return findKth(nums, k, 0, nums.length - 1);
    }


    private int findKth(int[] nums, int k, int left, int right) {
        if (left == right) {
            return nums[left];
        }

        int pivotIdx = partition(nums, left, right);
        int rank = pivotIdx - left + 1;
        if (rank == k) {
            return nums[pivotIdx];
        } else if (rank < k) {
            return findKth(nums, k - rank, pivotIdx + 1, right);
        } else {
            return findKth(nums, k, left, pivotIdx - 1);
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] > pivot) {
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
        LC215 lc215 = new LC215();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc215.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc215.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println();
    }
}
