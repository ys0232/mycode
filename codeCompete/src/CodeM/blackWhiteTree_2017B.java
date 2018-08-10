package CodeM;

import java.util.*;

class B_node{
    int id;
    int k;

    public B_node(int id, int k) {
        this.id = id;
        this.k = k;
    }
}
public class blackWhiteTree_2017B {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] pare=new int[n+1];
        int node=0;int[] vis=new int[n+1];
        int[] node_k=new int[n+1];
        ArrayList<Integer> parent=new ArrayList<>();
        for (int i=2;i<=n;i++){
            pare[i]=sc.nextInt();
            if (!parent.contains(pare[i])){
                parent.add(pare[i]);
            }
        }
        B_node[] b_nodes=new B_node[parent.size()];
        int cnt=0;
        for (int i=1;i<=n;i++){
            int t=sc.nextInt();
            node_k[i]=t;
            if (parent.contains(i)){
            b_nodes[cnt++]=new B_node(i,t);
            }
        }
       int res=0;
        for (int i=1;i<=n;i++){
            if (parent.contains(i))continue;
            int temp=node_k[i];
            int pare_t=pare[i];temp-=1;
            node+=1;res+=1;vis[i]+=1;
            while (temp>0 && pare_t>0){
                temp-=1;
                if (vis[pare_t]==0){
                    vis[pare_t]+=1;node+=1;
                }
                pare_t=pare[pare_t];
            }
            if (node>=n)break;
        }
        Arrays.sort(b_nodes, new Comparator<B_node>() {
            @Override
            public int compare(B_node b_node, B_node t1) {
                return t1.k-b_node.k;
            }
        });
        for (int i=0;i<b_nodes.length;i++){
            int temp=node_k[i];boolean flag=false;
            int pare_t=pare[b_nodes[i].id];
            if (vis[b_nodes[i].id]==0){
                node+=1;flag=true;
            }temp-=1;
            while (temp>0 && pare_t>0){
                if (vis[pare_t]==0){
                    node+=1;flag=true;
                }
                temp-=1;
                pare_t=pare[pare_t];
            }
            if (flag)res+=1;
            if (node>=n)break;
        }
        System.out.println(res);
    }
}
