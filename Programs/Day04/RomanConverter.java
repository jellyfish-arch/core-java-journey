import java.util.*;

public class RomanConverter {
    static Map<Character, Integer> map = Map.of(
            'I',1,'V',5,'X',10,'L',50,'C',100,'D',500,'M',1000
    );

    public static int romanToInt(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = map.get(s.charAt(i));
            if (i < s.length()-1 && val < map.get(s.charAt(i+1)))
                sum -= val;
            else sum += val;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("IX"));
    }
}