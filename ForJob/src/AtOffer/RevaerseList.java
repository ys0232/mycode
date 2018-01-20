package AtOffer;

/**
 *  Created by yolin on 2018/1/15.
 *  use head insert method
 *  insert a node from head rather than tail.
 */
public class RevaerseList {
    private static ListNode ReverseList(ListNode head) {
        if(head==null || head.next==null)return null;
        ListNode tail,q;
        tail=head;
        q=head.next;
        while (q!=null){
            head.next=q.next;
            q.next=tail;
            tail=q;
            q=head.next;
        }
        return tail;
    }
    public static void main(String[] args){
        ListNode head=new ListNode(0);
        int[] a={2,3,4,5,1,7,6,9,8,10};
        ListNode q=head;
        for (int i:a){
            ListNode p=new ListNode(i);
            q.next=p;
            q=q.next;
        }
        q=head;
        while (q!=null){
            System.out.print(q.val+"\t");
            q=q.next;
        }
        System.out.println();
        q=ReverseList(q);
        while (q!=null){
            System.out.print(q.val+"\t");
            q=q.next;
        }
    }
}
