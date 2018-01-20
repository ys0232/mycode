package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/19.
 */
public class ContinuousSequence {
    public static void main(String[] args){
        int sum=4;
        ArrayList<ArrayList<Integer>> ans=FindContinuousSequence(sum);
        for (ArrayList r:ans){
            System.out.println(r.toString());
        }

    }
    private static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
       ArrayList<ArrayList<Integer>> result=new ArrayList<>();
       if (sum<=0)return result;
       int s=0,start=1;
       for (int i=1;i<sum;){
           if (s>=sum){
               s-=start;
               start+=1;
           }else {
               s+=i;i++;
           }
           if (s==sum){
               ArrayList<Integer> r1=new ArrayList<>();
               for (int j=start;j<i;j++){
                   r1.add(j);
               }
             //  System.out.println(r1.toString());
               result.add(r1);
           }

         //  System.out.println(s+"\t"+start);
       }
        return result;
    }
}
