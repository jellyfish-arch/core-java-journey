package Day02;

public class PrimeOptimized {
    public static void main(String[] args) {
        int num = 29;
        boolean isPrime = true;

        if (num <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println(num + " is " + (isPrime ? "Prime" : "Not Prime"));
    }
}