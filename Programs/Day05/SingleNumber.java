public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2,2,1};

        int res = 0;
        for (int n : nums) res ^= n;

        System.out.println(res); // 1
    }
}