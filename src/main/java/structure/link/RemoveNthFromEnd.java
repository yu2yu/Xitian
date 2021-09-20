package structure.link;

import org.junit.jupiter.api.Test;

public class RemoveNthFromEnd {

    // 删除倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 哑节点
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        // 双指针
        ListNode left=head,right = head,prev = dummyNode;
        while(n > 0){
            right = right.next;
            --n;
        }
        while(right != null){
            prev = left;
            left = left.next;
            right = right.next;
        }
        prev.next = left.next;
        return dummyNode.next;
    }


    @Test
    public void testRemoveNthFromEnd(){
        ListNode headNode = ListNode.constructListNodes(new int[]{1, 2, 3, 4});
        ListNode node = removeNthFromEnd(headNode,5);
        ListNode.printListNodes(node);
    }

}
