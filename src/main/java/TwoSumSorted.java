/**
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note:
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class TwoSumSorted {

    public static void main(String[] args) {
        int[] array = new int[] {-5,-4,1,2,3,4,5};
        int[] res = twoSumSorted(array, 3);
        System.out.println(res[0]);
        System.out.println(res[1]);
    }

    public static int[] twoSumSorted(int[] numbers, int target) {
        int firstIndex = 0;
        int lastIndex = numbers.length - 1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[firstIndex] + numbers[lastIndex] == target) {
                return new int[] {firstIndex, lastIndex};
            } else if (numbers[lastIndex] > target ||
                    numbers[firstIndex] + numbers[lastIndex] > target) {
                lastIndex--;
            } else {
                firstIndex++;
            }
        }
        return null;
    }
}
