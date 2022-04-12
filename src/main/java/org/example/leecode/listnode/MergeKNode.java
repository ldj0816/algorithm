package org.example.leecode.listnode;

/**
 * @author: 吕东杰
 * @description: //TODO
 * @create: 2021-07-01 14:31
 **/
public class MergeKNode {

    int min = 1000000;

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode node = new ListNode();
        if(lists==null||lists.length==0){
            return node ;
        }
        mergeLists(node,lists);
        return node.next;

    }
    private void mergeLists(ListNode node,ListNode[] lists){
        int len = lists.length;
        int location = 0;
        for(int i = 0;i<lists.length; i++ ){
            if(lists[i]==null){
                len--;
                if(len==0){
                    return;
                }
                continue;
            }
            if(min > lists[i].val){
                min = lists[i].val;
                location = i;
            }
        }
        node.next = lists[location];
        node = node.next;
        lists[location] = lists[location].next;
        min = 1000000;
        mergeLists(node, lists);
        return;
    }

    public static void main(String[] args) {
        MergeKNode mergeKNode = new MergeKNode();
        ListNode node1 = new ListNode(1,new ListNode(4,new ListNode(5)));
        ListNode node2 = new ListNode(1,new ListNode(3,new ListNode(4)));
        ListNode node3 = new ListNode(2,new ListNode(6));
        ListNode[] nodes = new ListNode[]{node1,node2,node3};
        ListNode node = mergeKNode.mergeKLists(nodes);
        System.out.println(1);

    }
}
