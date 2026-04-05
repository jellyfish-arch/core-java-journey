import java.util.*;

public class MedianStream {

    static class MedianFinder {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        void add(int num) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());

            if (minHeap.size() > maxHeap.size())
                maxHeap.add(minHeap.poll());
        }

        double median() {
            if (maxHeap.size() > minHeap.size())
                return maxHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.add(1);
        mf.add(2);
        System.out.println(mf.median());
        mf.add(3);
        System.out.println(mf.median());
    }
}