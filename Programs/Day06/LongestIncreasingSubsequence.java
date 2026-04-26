import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLIS = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]);
        }
        
        return maxLIS;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println("Length of LIS: " + lengthOfLIS(nums)); // Expected: 4 (2, 3, 7, 101)
        
        int[] nums2 = {0, 1, 0, 3, 2, 3};
        System.out.println("Length of LIS: " + lengthOfLIS(nums2)); // Expected: 4 (0, 1, 2, 3)
    }
}
