package AtOffer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by yolin on 2018/3/3.
 */
public class FindPathOfTarget {
    public static void main(String[] args) {
        int[] pre={1,9,8,2,3,5,6,4};
        TreeNode root=new TreeNode(pre[0]);
        TreeNode p,q;
        p=root;q=root;
        int flag=-1;
        for (int i=1;i<pre.length;i+=2){
            p.left=new TreeNode(pre[i]);
            if (i<pre.length-1)
                p.right=new TreeNode(pre[i+1]);
            if (flag==-1){
                flag=1;
                q=p;
                p=p.left;
            }else {
                flag=-1;
                p=q.right;
            }
        }
        ArrayList<ArrayList<Integer>> res=FindPath(root,13);
        for (ArrayList<Integer> i:res){
            System.out.println("##########"+i.toString());
        }
    }

    private static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int tartget) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> trace = new ArrayList<>();
        if (root != null)
            dfs(root, tartget, res, trace);
        return res;
    }
     private static void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> trace) {
        trace.add(root.val);
        target-=root.val;
        System.out.println(trace.toString()+"\t"+target);
        if (root.left == null && root.right == null) {
            if (target == 0)
                res.add(new ArrayList<Integer>(trace));
           // System.out.println(trace.toString());
        }
        if (root.left != null)
            dfs(root.left, target, res, trace);
        if (root.right != null)
            dfs(root.right, target , res, trace);
       // System.out.println(trace.toString()+"\t"+target);
        trace.remove(trace.size()-1);
    }
}

