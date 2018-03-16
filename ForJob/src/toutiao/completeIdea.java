package toutiao;

import com.sun.xml.internal.bind.v2.model.core.ID;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by yolin on 2018/3/15.
 */
class idea{
    int id;
    int PMid;
    int comeOut;
    int priority;
    int needTime;
    int completeTime;
    public idea(int i,int id,int come,int priority,int needTime){
        this.comeOut=come;
        this.priority=priority;
        this.PMid=id;
        this.needTime=needTime;
        this.id=i;
    }
    public void completeIdea(int completeTime){
        this.completeTime=completeTime;
    }
}
public class completeIdea {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int p=sc.nextInt();
            idea[] Idea=new idea[p];
            int k=0;
            while (p-->0){
                int id=sc.nextInt();
                int come=sc.nextInt();
                int priority=sc.nextInt();
                int need=sc.nextInt();
                idea idea1=new idea(k,id,come,priority,need);
                Idea[k++]=idea1;
            }
            Arrays.sort(Idea, new Comparator<idea>() {
                @Override
                public int compare(idea o1, idea o2) {
                    if (o1.priority!=o2.priority)
                        return o1.priority-o2.priority;
                    else if (o1.needTime!=o2.needTime)
                        return o1.needTime-o2.needTime;
                    else if (o1.comeOut!=o2.comeOut)
                        return o1.comeOut-o2.comeOut;
                    else if (o1.PMid!=o2.PMid)
                        return o1.PMid-o2.PMid;
                    return 0;
                }
            });
            for (int i=0;i<Idea.length;i++)
                System.out.println(Idea[i].id+"\t"+Idea[i].PMid+"\t"+Idea[i].comeOut+"\t"+Idea[i].priority+"\t"+Idea[i].needTime);
            int[] mTime=new int[m];
            for (int i=0;i<Idea.length;i+=m){
                for (int j=0;j<m;j++){
                    if ((i+j)<Idea.length) {
                        idea idea1 = Idea[i + j];
                        idea1.completeIdea(Math.max(mTime[j], idea1.comeOut) + idea1.needTime);
                        mTime[j] = idea1.completeTime;
                    }
                }
            }
            Arrays.sort(Idea, new Comparator<idea>() {
                @Override
                public int compare(idea o1, idea o2) {
                    return o1.id-o2.id;
                }
            });
            for (int i=0;i<Idea.length;i++)
            System.out.println(Idea[i].completeTime);
        }
    }
}
