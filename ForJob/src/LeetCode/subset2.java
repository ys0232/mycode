package LeetCode;

import java.util.*;

/**
 * Created by yolin on 2018/3/14.
 */
public class subset2 {
    public static void main(String [] args){
        int[] a={0,2,2};
        ArrayList<ArrayList<Integer>> res=subsetsWithDup(a);
        for (ArrayList<Integer> r:res){
            System.out.println(r.toString());
        }
    }
    private static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num){

        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        Arrays.sort(num);
        for (int i=0;i<num.length;i++){
            ArrayList<Integer> temp=new ArrayList<>();
            int len=res.size();
           for (int j=len-1;j>=0;j--){
               temp=res.get(j);
               ArrayList<Integer> t=new ArrayList<Integer>(temp);
                temp.add(num[i]);
                if (!res.contains(t)){
                     res.add(t);
                }

           }
            temp=new ArrayList<>();
            temp.add(num[i]);
            if (!res.contains(temp)){
                res.add(temp);
            }
            System.out.println(res.toString());
        }
        res.add(new ArrayList<>());
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {

            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()==0 || o2.size()==0)return o1.size()-o2.size();
                int len=o1.size()<o2.size()?o1.size():o2.size();
                for (int i=0;i<len;i++){
                        if (o1.get(i)!=o2.get(i))
                            return o1.get(i)-o2.get(i);
                }
                return o1.size()-o2.size();
            }
        });


        return res;
    }
}
