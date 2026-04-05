import java.util.*;

public class CombinationSum {

    static void solve(List<List<Integer>> res, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            if (nums[i] > target) continue;

            temp.add(nums[i]);
            solve(res, temp, nums, target - nums[i], i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> res = new ArrayList<>();

        solve(res, new ArrayList<>(), nums, 7, 0);

        System.out.println(res);
    }
}