package AtOffer;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;

/**
 * Created by yolin on 2018/3/5.
 */
public class PrintTreeWithZ {
    public static void main(String[] args) {
        int[] pre = {1, 2, -1, 7, -1, 5};
        TreeNode root = new TreeNode(pre[0]);
        TreeNode p, q;
        p = root;
        q = root;
        int flag = -1;
        for (int i = 1; i < pre.length; i += 2) {
            if (pre[i]==-1)
                continue;
            p.left = new TreeNode(pre[i]);
            if (i < pre.length - 1)
                p.right = new TreeNode(pre[i + 1]);
            if (flag == -1) {
                flag = 1;
                q = p;
                p = p.left;
            } else {
                flag = -1;
                p = q.right;
            }
        }
       ArrayList<ArrayList<Integer>> r = Print(root);
        for (ArrayList<Integer> i : r)
           System.out.println("===============\n" + i.toString());

    }
    private static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot){
        ArrayList<ArrayList<Integer>> res=new ArrayList<>();
        ArrayList<TreeNode> queue=new ArrayList<>();
        ArrayList<Integer> temp=new ArrayList<>();
        String str="";
        if (pRoot==null)return res;
        queue.add(pRoot);
        int last,nlast=pRoot.val,t=-1;
        boolean flag=true;
        while (!queue.isEmpty()) {
            TreeNode p = queue.remove(0);
            if (flag)
            str+=p.val+"\t";
            else
                str=p.val+"\t"+str;
            last = p.val;
            if (last == nlast || queue.isEmpty()) {
                if (flag)flag=false;
                else flag=true;
                String[] a=str.split("\t");
                for (int i=0;i<a.length;i++){
                    if (!a[i].equals("\t")){
                        temp.add(Integer.valueOf(a[i]));
                    }
                }
                str="";
                System.out.println(temp.toString());
                res.add(temp);
                temp = new ArrayList<>();
            }

                if (p.left != null) {
                    queue.add(p.left);
                    if (last == nlast) {
                        t = p.left.val;
                    }
                }
                if (p.right != null) {
                    queue.add(p.right);
                    if (last == nlast) {
                        t = p.right.val;
                    }
                }

            nlast = t;
        }
        return res;
    }

}
