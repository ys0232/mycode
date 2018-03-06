package AtOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yolin on 2018/3/6.
 */
public class GetMedium {
    // use heap
    private static int count=0;
    private static PriorityQueue<Integer> minHeap=new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    });
    public static void main(String [] args){

        int[] a={1,2,5,3,9,6,4,7,8};
        for (int r:a){
            Insert(r);
            System.out.println(GetMedian());
        }
    }

    private static void Insert(Integer num){

        if (count%2==0){
            // get one number of maxHeap to minHeap
            maxHeap.offer(num);
            int max=maxHeap.poll();
            minHeap.offer(max);
        }else {
            minHeap.offer(num);
            int min=minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }
    private static Double GetMedian(){

        if (count%2==0){
            return new Double((minHeap.peek()+maxHeap.peek())/2.0);
        }else return new Double(minHeap.peek());
    }
}
