package structure.link;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeleteDuplicates {

    public ListNode deleteDuplicates(ListNode head){

        ListNode prev = new ListNode(-101,head);
        ListNode cur = prev;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next != null && x == cur.next.val){
                    cur.next = cur.next.next;
                }

            }else{
                cur = cur.next;
            }
        }
        return prev.next;
    }


    @Test
    @DisplayName("删除排序链表中重复元素")
    public void testDeleteDuplicates(){
        ListNode listNode = ListNode.constructListNodes(new int[]{1,1,1,2,3});
        ListNode listNode1 = deleteDuplicates(listNode);
        ListNode.printListNodes(listNode1);
    }

}
