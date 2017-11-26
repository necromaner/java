/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: necromaner
 * Date: 2017-11-26
 * Time: 上午11:02
 */
public class Leetcode_22_19_RemoveNthNodeFromEndofList {//完成
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n=1;
        ListNode head=new ListNode(1);
        ListNode node1=new ListNode(2);
        ListNode node2=new ListNode(3);
        ListNode node3=new ListNode(4);
        ListNode node4=new ListNode(5);
        head.next=node1;
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        ListNode NthFrom=solution.removeNthFromEnd(head,n);
        System.out.print("head is  = ");
        while (head!=null){
            System.out.print(head.val);
            if (head.next!=null){
                System.out.print("->");
            }
            head=head.next;
        }
        System.out.println("");
        System.out.println("   n     = "+n);
        System.out.print("NthFrom  = ");
        while (NthFrom!=null){
            System.out.print(NthFrom.val);
            if (NthFrom.next!=null){
                System.out.print("->");
            }
            NthFrom=NthFrom.next;
        }
        System.out.println("");
    }
}
