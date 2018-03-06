package AtOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Created by yolin on 2018/3/5.
 */
public class printMinNumber {
    public static void main(String [] args){
        int[] a={3,32,321};
        System.out.println(PrintMinNumber(a));

    }
    private static String PrintMinNumber(int[] numbers){

        int n=numbers.length;
        String str="";
        ArrayList<Integer> list=new ArrayList<>();
        for (int i=0;i<n;i++){
            list.add(numbers[i]);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer num1,Integer num2){
                String s1=num1+""+num2;
                String s2=num2+""+num1;
                return s1.compareTo(s2);
            }
        });
        for (int j:list){
            str+=j;
        }
        return str;
    }
}
