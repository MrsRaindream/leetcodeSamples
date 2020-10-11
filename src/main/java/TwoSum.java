import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] array = new int[] {-5, 0, 2, 1,2,3};
        twoSum(array, 3);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            int elemFindFor = target - nums[i];
            if (hashMap.containsKey(elemFindFor)) {
                System.out.println(hashMap.get(elemFindFor));
                System.out.println(i);
                return new int[] {target, hashMap.get(elemFindFor)};
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[]{};
    }
}
