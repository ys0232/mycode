package CodeM;


import java.util.Scanner;

public class makeOrder {
    public static void main(String [] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        double cost_sp=0;
        double not_sp=0;
        for (int i=0;i<n;i++){
           int item=sc.nextInt();
           int sp=sc.nextInt();
            if (sp==1){
                //can use special offer
                cost_sp+=item;
            }else not_sp+=item; //can't use special offer
        }
        //all cost
        double sum_cost=cost_sp+not_sp;
        // use special offer
        cost_sp=0.8*cost_sp+not_sp;
        // use full reduction
        double res=sum_cost;
        for (int i=0;i<m;i++){
            int all=sc.nextInt();
            int cut=sc.nextInt();
            if (all<=sum_cost){
                if (res>sum_cost-cut){
                    //the key point,logical relation
                    res=sum_cost-cut;
                }
            }
        }
        res=cost_sp<res?cost_sp:res;
        System.out.println(String.format("%.2f",res));
    }
}
