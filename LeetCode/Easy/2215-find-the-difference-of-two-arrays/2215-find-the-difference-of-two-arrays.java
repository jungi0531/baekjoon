import java.util.*;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> hash1 = new HashSet<>();
        HashSet<Integer> hash2 = new HashSet<>();

        for (int i = 0; i < nums1.length; i++) {
            hash1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            hash2.add(nums2[i]);
        }
        //
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int temp : hash1) {
            if (!hash2.contains(temp)) result.get(0).add(temp);
        }
        for (int temp : hash2) {
            if (!hash1.contains(temp)) result.get(1).add(temp);
        }

        //
        return result;
    }
}