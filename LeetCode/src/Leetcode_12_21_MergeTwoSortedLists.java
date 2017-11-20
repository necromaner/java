/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-10-28
 * Time: 下午2:21
 */
public class Leetcode_12_21_MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution solution=new Solution();
        ListNode node1=new ListNode(20);
        ListNode node2=new ListNode(30);
        ListNode node3=new ListNode(40);
        ListNode node4=new ListNode(50);
        ListNode node5=null;
        ListNode node6=new ListNode(70);
        ListNode l1=new ListNode(10);
        ListNode l2=new ListNode(60);
        l1.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        l2.next=node6;
        ListNode l3=solution.mergeTwoLists(l1,l2);
        System.out.println(l1.val);
        l1=l1.next;
        System.out.println(l1.val);
        System.out.println(l1.next.val);
        
    }
}
