package structure.link;

public class getKthfromKid {

    public ListNode getKthFromEnd(ListNode head, int k){

        // 双指针
        ListNode fast = head,slow = head;
        int count = k;
        while(fast != null && count>0){
            fast = fast.next;
        }

        if(count == 0) return head;

        while(fast!=null){
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

}
