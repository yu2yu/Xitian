package LC20240724;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structure.link.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MergeKListNode {


    public ListNode mergeKLists2(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if(l == r){
            return lists[l];
        }
        if(l > r){
            return null;
        }
        int mid = (l+r) >> 1;
        ListNode leftListNode = mergeKLists(lists, l, mid);
        ListNode rightListNode = mergeKLists(lists, mid+1, r);
        return mergeLists(leftListNode, rightListNode);
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        // 两两合并
        int length = lists.length;
        if(length == 1){
            return lists[0];
        }
        ListNode listNode = mergeLists(lists[0], lists[1]);
        lists[1] = listNode;
        return mergeKLists(Arrays.copyOfRange(lists, 1, length));
    }

    public ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode merged = new ListNode(0);
        ListNode pre = merged;
        while(l1 != null && l2 != null){
            if(l1.val >= l2.val){
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
            }else{
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            pre = pre.next;
        }
        pre.next = l1 != null ? l1 : l2;
        return merged.next;
    }


    @Test
    @DisplayName("合并k个有序链表")
    public void testThreeSum(){

        ListNode l1 = ListNode.constructListNodes(new int[]{1, 4, 5});
        ListNode l2 = ListNode.constructListNodes(new int[]{1,3,4});
        ListNode l3 = ListNode.constructListNodes(new int[]{2, 6});

        ListNode listNode = mergeKLists(new ListNode[]{l1, l2, l3});
        ListNode.printListNodes(listNode);
    }

}
