package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by yolin on 2018/3/14.
 */
public class subset {

    private static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<Integer> temp;
        Arrays.sort(S);
        res.add(new ArrayList<Integer>());
        for (int i=0;i<S.length;i++){
            int len=res.size();
            for (int j=0;j<len;j++){
                temp=res.get(j);
                res.add(new ArrayList<Integer>(temp));
                temp.add(S[i]);
                // res.add(temp);
            }

        }
        Collections.sort(res, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                if (o1.size()!=o2.size())
                    return o1.size()-o2.size();
                for (int i=0;i<o1.size();i++){
                    if (o1.get(i)!=o2.get(i)){
                        return o1.get(i)-o2.get(i);
                    }
                }
                return 0;
            }
        });

        return res;
    }
    public static void main(String [] args){
        int[] a={1,2,3,4};
        ArrayList<ArrayList<Integer>> res=subsets(a);
        for (ArrayList<Integer> r:res){
            System.out.println(r.toString());
        }
    }

}
