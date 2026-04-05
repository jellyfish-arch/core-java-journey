public class GasStation {

    public static int canComplete(int[] gas, int[] cost) {
        int total = 0, curr = 0, start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            curr += diff;

            if (curr < 0) {
                start = i + 1;
                curr = 0;
            }
        }

        return total >= 0 ? start : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canComplete(gas, cost)); // 3
    }
}