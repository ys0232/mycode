package AtOffer;


/**
 * Created by yolin on 2018/1/19.
 */
public class FirstCommonNode {
    public static void main(String[] args){
        int[] a={1,3,4,6,8,9,2,5,7};
        int[] b={9,2,5,6,1,2,3,5,7};
        ListNode pHead1=new ListNode(a[0]),p1=pHead1;
        ListNode pHead2=new ListNode(b[0]),p2=pHead2;
        for (int i:a){
            p1.next=new ListNode(i);
            p1=p1.next;
        }
        for (int i:b){
            p2.next=new ListNode(i);
            p2=p2.next;
        }
        p1=FindFirstCommonNode(pHead1,pHead2);
        if (p1!=null)
        System.out.println(p1.val);

    }
    private static ListNode FindFirstCommonNode(ListNode pHead1,ListNode pHead2){
        ListNode p1=pHead1,p2=pHead2;
        while (p1!=p2){
            p1=(p1==null?pHead2:p1.next);
            p2=(p2==null?pHead1:p2.next);
        }
        return p1;
    }
}
