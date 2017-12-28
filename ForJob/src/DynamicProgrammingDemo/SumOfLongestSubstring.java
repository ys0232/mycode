package DynamicProgrammingDemo;

/**
 * Created by lenovo on 2017/12/25.
 */
public class SumOfLongestSubstring {

    public static void main(String[] args){
    int[] a={1,-2,-1,-9,1,8,7,-9,1,30,-2,2,1,3,4,-9,-10,2};
    int max=Integer.MIN_VALUE;
    int start=-1,end=-1;
    int sum=0;
    int tmpstart=0,tmpend=-1;
        for (int i=0;i<a.length;i++) {
           sum+=a[i];
           tmpend++;
           if (sum>max){
               max=sum;
               start=tmpstart;
               end=tmpend;
           }
           if (sum<0){
               sum=0;
               tmpstart=i+1;
           }

        }


    for (int i=start;i<end;i++){
        System.out.print(a[i]+"\t");
    }
    System.out.println("\n"+max);
    }

}
