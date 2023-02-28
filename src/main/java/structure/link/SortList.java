package structure.link;

import org.junit.jupiter.api.Test;

public class SortList {

    public ListNode sortList(ListNode head){
        // 结束递归条件
        if(head == null || head.next == null) return head;
        // 1. 找到中间节点
        ListNode fast = head.next,slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        return new MergeSortrdNode().mergeTwoLists(left, right);
    }

    @Test
    public void testSortList(){
        ListNode listNode = ListNode.constructListNodes(new int[]{4, 2, 1, 3});
        ListNode listNode1 = new SortList().sortList(listNode);
        ListNode.printListNodes(listNode1);

    }

}
