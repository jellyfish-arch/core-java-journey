package Day03;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int key = 30;
        boolean found = false;

        for (int num : arr) {
            if (num == key) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "Found" : "Not Found");
    }
}