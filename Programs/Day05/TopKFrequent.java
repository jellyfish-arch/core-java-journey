import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;

        Map<Integer,Integer> map = new HashMap<>();
        for(int n: nums) map.put(n, map.getOrDefault(n,0)+1);

        PriorityQueue<Map.Entry<Integer,Integer>> pq =
                new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            pq.add(e);
            if(pq.size()>k) pq.poll();
        }

        while(!pq.isEmpty()){
            System.out.println(pq.poll().getKey());
        }
    }
}