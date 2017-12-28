package one;
import java.util.*;
public class test1003{
	
 public static void main(String[] args){
          Scanner sc=new Scanner(System.in);
                 int num=sc.nextInt();
                   int k=1;
                  while(k<=num){
                 int count=0;
                 count=sc.nextInt();
                  long max=-1001;
                  long sum=0;
                  int start=1;
                  int end=1;
                  int startTmp=1;
                  int tmp=0;
                for(int i=0;i<count;i++){
                    tmp=sc.nextInt();
                   sum+=tmp;
               if(sum>max){
                  max=sum;
              start=startTmp;
                 end=i+1;
                }
              if(sum<0){
                   sum=0;
            startTmp=i+2;}
         

}
                System.out.println("Case "+k+":");
                System.out.println(max+" "+start+" "+end);
     if(k<num)
     System.out.println();
     k++;
}
                  sc.close();
}
}