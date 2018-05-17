package DynamicProgrammingDemo;

import java.util.ArrayList;
import java.util.Arrays;

public class DigitalTriangle {
    public static void main(String[] args){
        ArrayList<ArrayList<Integer>> a=new ArrayList<>();
        ArrayList<Integer> tem=new ArrayList<>();
        tem.add(-1);
        a.add(new ArrayList<>(tem));tem.clear();
        tem.add(3);tem.add(2);
        a.add(new ArrayList<>(tem));
        tem.clear();
        tem.add(1);tem.add(-2);tem.add(-1);
        a.add(new ArrayList<>(tem));

System.out.println(minimumTotal(a));
    }
    private static int minimumTotal(ArrayList<ArrayList<Integer>> triangle){
        int n=triangle.size();
        int[] res=new int[n];
        for (int i=0;i<n;i++)
            res[i]=triangle.get(n-1).get(i);
        for (int i=n-2;i>=0;i--){
            System.out.println(Arrays.toString(res));
            for (int j=0;j<triangle.get(i).size();++j) {
                System.out.println(triangle.get(i).get(j)+"\t"+res[i]);
                res[j]=Math.min(res[j],res[j+1])+triangle.get(i).get(j);
            }
        }
        System.out.println(Arrays.toString(res));
        return res[0];
    }
}
