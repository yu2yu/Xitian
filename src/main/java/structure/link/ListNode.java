package structure.link;

/**
 * 链表节点
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode constructListNodes(int[] arr){
        ListNode headNode = new ListNode(arr[0]);
        ListNode node = headNode;
        for (int i = 1; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return headNode;
    }

    public static void printListNodes(ListNode node){
        while(node != null){
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println();
    }
}
