import java.util.*;

// any increasing subsequence
public class LC300_FollowUp_2 {
    public List<Integer> lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int n = nums.length;
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(nums[0]));
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        map.put(0, null);
        for (int i = 1; i < n; i++) {
            Integer pre = null;
            if (nums[i] > nums[list.get(list.size() - 1)]) {
                list.add(i);
                if (list.size() > 1) {
                    pre = list.get(list.size() - 2);
                }
            } else {
                int idx = smallestLargerOrEqual(list, nums[i], nums);
                list.set(idx, i);
                if (idx >= 1) {
                    pre = list.get(idx - 1);
                }
            }
            map.put(i, pre);
        }

        List<Integer> res = new LinkedList<>();
        Integer cur = list.get(list.size() - 1);
        while (cur != null) {
            res.add(0, nums[cur]);
            cur = map.get(cur);
        }

        return res;
    }

//    private void addToMap(HashMap<Integer, Integer> map, int idx) {
//        if (idx == 0) {
//            map.put(idx, null);
//        } else {
//
//        }
//    }

    private int smallestLargerOrEqual(List<Integer> list, int target, int[] nums) {
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[list.get(mid)] < target) {
                left = mid + 1;
            } else if (nums[list.get(mid)] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        LC300_FollowUp_2 lc300_followUp_2 = new LC300_FollowUp_2();

        // Test Case 1
        System.out.println("Test Case 1");
        System.out.println(lc300_followUp_2.lengthOfLIS(new int[]{10,9,2,3,7,5,3,4,5,6}).toString());
        System.out.println();

        // Test Case 2
        System.out.println("Test Case 2");
        System.out.println(lc300_followUp_2.lengthOfLIS(new int[]{0,1,0,3,2,3}).toString());
        System.out.println();

        // Test Case 3
        System.out.println("Test Case 3");
        System.out.println(lc300_followUp_2.lengthOfLIS(new int[]{7,7,7,7,7,7,7}).toString());
        System.out.println();
    }
}
