package Day03;

public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = {5, 12, 3, 19, 7};

        int max = arr[0];

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Max: " + max);
    }
}