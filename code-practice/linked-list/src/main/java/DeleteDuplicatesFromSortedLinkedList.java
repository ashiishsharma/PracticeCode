/**
 Input:  11-> 15 -> 18 -> 18 -> 20 -> 20
 Output: 11-> 15 -> 18 -> 20

 */
public class DeleteDuplicatesFromSortedLinkedList {


    public static void main(String[] args) {

        LinkedList lst = createSortedLinkedList();
        DeleteDuplicatesFromSortedLinkedList obj = new DeleteDuplicatesFromSortedLinkedList();
        obj.removeDuplicates(lst);
        lst.traverse();
    }

    private void removeDuplicates(LinkedList lst) {

        Node head = lst.getHead();
        Node current = head;

        while(current.next != null) {

            if(current.data.equals(current.next.data)) {
                current.next = current.next.next;
            }else {
                current = current.next;
            }
        }

    }

    private static LinkedList createSortedLinkedList() {
        LinkedList lst = new LinkedList();
        lst.addNode("11");
        lst.addNode("15");
        lst.addNode("18");
        lst.addNode("18");
        lst.addNode("20");
        lst.addNode("20");
        lst.addNode("20");
        return lst;
    }
}
