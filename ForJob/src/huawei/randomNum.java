package huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

public class randomNum {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            PriorityQueue<Integer> heap=new PriorityQueue<Integer>(n);
            for (int i=0;i<n;i++) {
                int t = sc.nextInt();
              //  System.out.println(t+"\t"+heap.size());
                if (!heap.contains(t)) {
                    heap.add(t);
                }
            }

            for (;heap.size()>0;){
                System.out.println(heap.poll());
            }

        }
    }
}
