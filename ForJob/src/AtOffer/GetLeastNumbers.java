package AtOffer;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/1/19.
 * bubble sort
 */
public class GetLeastNumbers {
    private static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
           ArrayList<Integer> result=new ArrayList<>();
        if(input.length==0 || k>input.length)return result;
            for (int i=0;i<k;i++){
                for (int j=i+1;j<input.length;j++){
                    if (input[i]>input[j]){
                        int t=input[i];
                        input[i]=input[j];
                        input[j]=t;
                    }
                }
                result.add(input[i]);
            }
            return result;
    }
    public static void main(String[] args){
        int[] a={4,5,1,6,7,8,2,3,9};
        int k=4;
        System.out.println(GetLeastNumbers_Solution(a,k).toString());
    }
}

