package DynamicProgrammingDemo;

public class maxMultiply {
    public static void main(String[] args){
        int[] a={5,3,-9,5,-2,0,8,7,-6,-1};
        int maxSoFar=Integer.MIN_VALUE;
        int maxending=1,minending=1;
        int new_maxending=1,new_minending=1;
        for (int i=0;i<a.length;i++){
            new_maxending=Math.max(Math.max(maxending*a[i],
                    minending*a[i]),a[i]);
            new_minending=Math.min(Math.min(maxending*a[i],
                    minending*a[i]),a[i]);
            minending=new_minending;
            maxending=new_maxending;
            maxSoFar=maxSoFar>maxending?maxSoFar:maxending;
            System.out.println(maxSoFar+"\t"+maxending+"\t"+minending);
        }
        System.out.println(maxSoFar);
    }
}
