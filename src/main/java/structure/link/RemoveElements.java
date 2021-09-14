package structure.link;

import org.junit.jupiter.api.Test;

public class RemoveElements {


    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return head;
        }
        // 主要是删除头部之后
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode cur = node;
        while (cur.next != null){
            if(cur.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return node.next;
    }

    @Test
    public void testRemoveElements(){

        ListNode headNode = ListNode.constructListNodes(new int[]{1, 2, 6, 3, 4, 5, 6});
        ListNode node = removeElements(headNode, 6);
        ListNode.printListNodes(node);

    }

}
