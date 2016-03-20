/**
 *For example if the first linked list a is 5->10->15 and the other linked list b is 2->3->20,
 * then SortedMerge() should return a pointer to the head node of the merged list 2->3->5->10->15->20
 */
public class MergeSortedListsWithoutExtraSpace {

    public static void main (String [] args) {

        LinkedList lst1 = new  LinkedList();
        lst1.addNode("5");
        lst1.addNode("10");
        lst1.addNode("15");


        LinkedList lst2 = new  LinkedList();
        lst2.addNode("2");
        lst2.addNode("3");
        lst2.addNode("20");

        MergeSortedListsWithoutExtraSpace obj = new MergeSortedListsWithoutExtraSpace();
        LinkedList finalList = new  LinkedList();
        obj.merge(finalList, lst1.getHead(),lst2.getHead());
        finalList.traverse();
    }

    public static void merge(LinkedList finalList, Node head1, Node head2) {

        Node firstCurrent = head1;
        Node secondCurrent = head2;

        while( firstCurrent != null && secondCurrent != null ) {

            if ( (new Integer(firstCurrent.getData()).intValue() < (new Integer(secondCurrent.getData()).intValue() )))  {

                finalList.addNode(firstCurrent.data);
                firstCurrent = firstCurrent.next;

            } else if ( (new Integer(firstCurrent.getData()).intValue() > (new Integer(secondCurrent.getData()).intValue() )))  {

                finalList.addNode(secondCurrent.data);
                secondCurrent = secondCurrent.next;

            } else {

                finalList.addNode(secondCurrent.data);
                firstCurrent = firstCurrent.next;
                secondCurrent = secondCurrent.next;

            }

        }//end of while

        while (firstCurrent != null) {

            finalList.addNode(firstCurrent.data);
            firstCurrent = firstCurrent.next;
        } //end of while

        while (secondCurrent != null) {
            finalList.addNode(secondCurrent.data);
            secondCurrent = secondCurrent.next;

        } //end of while

    }



}
