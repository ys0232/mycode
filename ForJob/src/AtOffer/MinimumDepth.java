package AtOffer;

/**
 * Created by yolin on 2018/1/19.
 */
public class MinimumDepth {
    public static void main(String[] args){
        int n=9;
        TreeNode root=new TreeNode(0);
        TreeNode p=root,q=p;
        int flag=-1;
        for(int i=1;i<n;i+=2){
            p.left=new TreeNode(i);
            p.right=new TreeNode(i+1);
            if (flag==-1){
                q=p;flag=1;
                p=p.left;
            }else {
                flag=-1;p=q.right;
            }
        }
        System.out.println(run(root));
    }
    private static int run(TreeNode root){
        if (root==null)return 1;
        int left=-1,right=-1;
        if (root.left!=null){
         left=run(root.left);
        }
        if (root.right!=null){
            right=run(root.right);
        }
        int depth=left<right?left:right;
        return depth+1;
    }
}
