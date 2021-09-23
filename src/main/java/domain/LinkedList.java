package domain;

/**
 * LinkedList class handles the creation of an ordered linked list
 * that does not permit duplicates.
 */
public class LinkedList {

    // instance fields
    private ListNode head;
    private ListNode cursor;

    // constructor
    public LinkedList() {
        this.head = null;
        this.cursor = null;
    }

    // other methods

    /**
     * Handles adding a new node to the Linked List.
     * @param value to be assigned to the new node
     */
    public void addNode(String value) {
        // create node
        ListNode newNode = new ListNode(value);

        // add to list
        if (head == null) { // add new value to head of the list; set head and cursor
            populateHead(newNode);
        } else { // use compareTo to determine newNode's value vis a vis the current node value.
            boolean quit = false;

            while (!quit) { // check value of new Node against cursor object's value and set as appropriate
                quit = compareMethod(newNode);
            }
            // reset list head and return cursor
            returnToHead();
        }
    }

    /**
     * Populates the head of the Linked List with the value of the new node.
     * Sets cursor to point to head.
     * @param newNode the new value to be added
     */
    public void populateHead(ListNode newNode) {
        this.head = newNode;
        this.cursor = head;
    }

    /**
     * Handles the actions setting values to be taken according to the given compareTo value
     * of the new Node against the value pointed to by the cursor.
     * @param newNode to be added
     * @return boolean
     */
    public boolean compareMethod(ListNode newNode) {
        int compValue = cursor.compareTo(newNode);

        switch(compValue) {
            case -1:
                cursor.setPreviousItem(newNode);
                return true;
            case 0:
                return true;
            case 1:
                if (cursor.next == null) {
                    cursor.setNextItem(newNode);
                    return true;
                } else {    // continue to next node
                    cursor = (ListNode) cursor.nextItem();
                }
                return false;
            default:
                System.out.println("An error has occurred.");
                return true;
        }
    }

    /**
     * Deletes a node.
     */
    public void deleteNode(String str) {
        boolean quit = false;
        while (!quit) {
            if (cursor.value.equals(str)) {
                cursor.deleteNode(cursor);
                returnToHead();
                quit = true;
            } else {
                cursor = (ListNode) cursor.nextItem();
            }
        }
    }

    /**
     * Cycles cursor back to and resets head.
     */
    public void returnToHead() {
        cursor = (ListNode) cursor.returnToHead(cursor);
        head = cursor;
    }

    /**
     * Handles printing of nodes.
     */
    public void printList() {
        cursor.print(cursor);
    }

}
