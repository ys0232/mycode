package huawei;

import java.util.*;

public class CombineTable {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            HashMap<Integer,Integer> cnt=new HashMap<>();
            ArrayList<Integer> keys=new ArrayList<>();
            for (int i=0;i<n;i++){
                int key=sc.nextInt();
                int value=sc.nextInt();
                if (cnt.containsKey(key)){
                    value+=cnt.get(key);
                    cnt.put(key,value);
                }else {
                    keys.add(key);
                    cnt.put(key,value);
                }
            }
            Collections.sort(keys);
            for (int key:keys){
                System.out.println(key+" "+cnt.get(key));
            }

        }
    }
}
