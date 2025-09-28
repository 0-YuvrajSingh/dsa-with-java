package SpecialAlgorithms;

// Boyer–Moore Majority Vote Algorithm
public class BoyerMooreMajorityVote {

    public static int majority(int[] nums) {
        int element = -1;
        int count = 0;

        // Phase 1: Find candidate
        for (int num : nums) {
            if (count == 0) {
                element = num;
                count = 1;
            } else if (num == element) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2: Verify candidate
        count = 0;
        for (int num : nums) {
            if (num == element) {
                count++;
            }
        }

        if (count > nums.length / 2) {
            return element;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority element: " + majority(nums));
    }
}
