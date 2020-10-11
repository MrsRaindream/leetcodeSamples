import java.util.*;

/**
 * https://leetcode.com/problems/3sum/
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 */
public class ThreeSum {

    public static final int DEMAND_SUM = 0;

    public static void main(String[] args) {
        int[] array = new int[] {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSumSorted(array, 0);
        System.out.println("list size is: " + lists.size());

        System.out.println(lists.get(0).get(0));
        System.out.println(lists.get(0).get(1));
        System.out.println(lists.get(0).get(2));

        System.out.println("another:");

        System.out.println(lists.get(1).get(0));
        System.out.println(lists.get(1).get(1));
        System.out.println(lists.get(1).get(2));
    }

    public static List<List<Integer>> threeSumSorted(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<List<Integer>> finalResult = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int targetForTwo = DEMAND_SUM - numbers[i];
            List<Integer> twoNumbers = twoNumbersSorted(numbers, i+1, targetForTwo);
            if (twoNumbers != null && twoNumbers.size() == 2) {
                List triplet = new ArrayList();
                triplet.add(numbers[i]);
                triplet.addAll(twoNumbers);
                finalResult.add(triplet);
            }
        }
        return finalResult;
    }

    private static List<Integer> twoNumbersSorted(int[] numbers, int firstIndex, int target) {
        int lastIndex = numbers.length - 1;

        for (int i = firstIndex; i < numbers.length; i++) {
            if (numbers[firstIndex] + numbers[lastIndex] == target && firstIndex != lastIndex) {
                return Arrays.asList(numbers[firstIndex], numbers[lastIndex]);
            } else if (numbers[lastIndex] > target ||
                    numbers[firstIndex] + numbers[lastIndex] > target) {
                lastIndex--;
            } else if (numbers[firstIndex] + numbers[lastIndex] < target) {
                firstIndex++;
            }
        }
        return null;
    }

}
