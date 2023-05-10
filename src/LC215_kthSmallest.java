import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LC215_kthSmallest {
//        // Method I : sort
//    public int findKth(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k > nums.length) {
//            throw new IllegalArgumentException();
//        }
//        Arrays.sort(nums);
//        return nums[k - 1];
//    }

    // Method II : minHeap
    public int findKth(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k > nums.length) {
            throw new IllegalArgumentException();
        }
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.asList(Arrays.stream(nums).boxed().toArray(Integer[]::new)));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        while (--k > 0) {
            minHeap.poll();
        }

        return minHeap.poll();
    }

//    // Method III : maxHeap
//    public int findKth(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k > nums.length) {
//            throw new IllegalArgumentException();
//        }
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
//        for (int num: nums) {
//            if (maxHeap.size() < k) {
//                maxHeap.offer(num);
//            } else if (maxHeap.peek() > num) {
//                maxHeap.poll();
//                maxHeap.offer(num);
//            }
//        }
//        return maxHeap.poll();
//    }

//    // Method IV : Quick Selection
//    public int findKth(int[] nums, int k) {
//        if (nums == null || nums.length == 0 || k > nums.length) {
//            throw new IllegalArgumentException();
//        }
//
//        return findKth(nums, k, 0, nums.length - 1);
//    }
//
//
//    private int findKth(int[] nums, int k, int left, int right) {
//        if (left == right) {
//            return nums[left];
//        }
//
//        int pivotIdx = partition(nums, left, right);
//        int rank = pivotIdx - left + 1;
//        if (rank == k) {
//            return nums[pivotIdx];
//        } else if (rank < k) {
//            return findKth(nums, k - rank, pivotIdx + 1, right);
//        } else {
//            return findKth(nums, k, left, pivotIdx - 1);
//        }
//    }
//
//    private int partition(int[] nums, int left, int right) {
//        int pivot = nums[right];
//        int i = left - 1;
//        for (int j = left; j < right; j++) {
//            if (nums[j] < pivot) {
//                i++;
//                swap(nums, i, j);
//            }
//        }
//        swap(nums, i + 1, right);
//        return i + 1;
//
//    }
//
//    private void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }

    public static void main(String[] args) {
        LC215_kthSmallest lc215_kthSmallest = new LC215_kthSmallest();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc215_kthSmallest.findKth(new int[]{3,2,1,5,6,4}, 2));
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc215_kthSmallest.findKth(new int[]{3,2,3,1,2,4,5,5,6}, 4));
        System.out.println();
    }
}
