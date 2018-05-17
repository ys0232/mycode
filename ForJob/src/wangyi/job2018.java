package wangyi;

import java.util.*;

public class job2018 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            HashMap<Integer,Integer>  list=new HashMap<>();
            int n = sc.nextInt();
            int m = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int power = sc.nextInt();
                int salary = sc.nextInt();
                if (list.containsKey(power)){
                    int t=list.get(power);
                    if (t<salary){
                        list.put(power,salary);
                    }
                }else list.put(power,salary);
            }
            int[] power = new int[m];
            for (int i = 0; i < m; i++)
                power[i] = sc.nextInt();
            int[][] jobs=new int[2][list.size()];
            int k=0;
            for (Integer it:list.keySet()){
                jobs[0][k]=list.get(it);
                jobs[1][k++]=it;
            }
            Arrays.sort(jobs);
            System.out.println(Arrays.toString(jobs));
            for (int i=0;i<m;i++){
                boolean flag=true;
                for (int j=jobs.length-1;j>=0;j--){
                    if (power[i]>=jobs[1][j]){
                        System.out.println(list.get(jobs[1][j]));
                        flag=false;break;
                    }
                }
                if (flag)System.out.println(0);
            }
        }
    }
}
