package AtOffer;

import java.util.Arrays;

/**
 * Created by yolin on 2018/1/15.
 */
public class MergeList {
    public static void main(String[] args) {
        ListNode list1, list2;
        int[] a = {1, 4, 5, 7, 8, 9, 11, 23, 89};
        int[] b = {0, 3, 6, 10, 17, 20, 72, 88, 90,99,101,111};
        list1 = new ListNode(a[0]);
        ListNode q = list1;
        for (int i = 1; i < a.length; i++) {
            ListNode p = new ListNode(a[i]);
            q.next = p;
            q = q.next;
        }
        list2 = new ListNode(b[0]);
        q = list2;
        for (int i = 1; i < b.length; i++) {
            ListNode p = new ListNode(b[i]);
            q.next = p;
            q = q.next;
        }
       // q=list1;
    /*    while (q!=null){
            System.out.print(q.val+"\t");
            q=q.next;
        }
      */
    System.out.println(Arrays.toString(a)+"\n"+Arrays.toString(b));
    if (q.next==null)System.out.println("true\t"+q.val);
    else System.out.println("false");
    ListNode pop=new ListNode(120);
      q=Merge(q,list2);
      while (q!=null){
            System.out.print(q.val+"\t");
            q=q.next;
        }
    }

    private static ListNode Merge(ListNode list1, ListNode list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode head,q ;
        if (list1.val < list2.val) {
            q =list1;
            list1 = list1.next;
        } else {
            q=list2;
            list2 = list2.next;
        }
        head=q;
        while (list1 != null && list2 != null) {
            ListNode pre;

            if (list1.val < list2.val) {
               pre= list1;
                list1 = list1.next;
            } else {
                pre = list2;
                list2 = list2.next;
            }
            q.next=pre;
            q= q.next;
        }
        ListNode p=head;
        while (p!=null){
            System.out.print(p.val+"\t");
            p=p.next;
        }
        System.out.println();

        if (list1 != null) {
          //  System.out.print(list1.val+"\tlist1");
          /*  if (list1.next==null)System.out.println("true\t");
            else System.out.println("false\t"+list1.val);*/
          q.next=list1;

        }
       if(list2 != null){
           // System.out.print(list2.val+"\tlist2");
           q.next = list2;

        }
         return head;
    }
}
