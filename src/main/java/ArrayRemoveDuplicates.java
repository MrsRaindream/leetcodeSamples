
/**
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 *
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 */
public class ArrayRemoveDuplicates {

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,1,2};
        System.out.println(countUnique(nums));
    }

    public static int countUnique(int[] nums) {
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index+1;
    }

}
