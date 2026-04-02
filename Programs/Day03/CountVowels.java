package Day03;

public class CountVowels {
    public static void main(String[] args) {
        String str = "programming";
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ("aeiouAEIOU".indexOf(ch) != -1) {
                count++;
            }
        }

        System.out.println("Vowels: " + count);
    }
}