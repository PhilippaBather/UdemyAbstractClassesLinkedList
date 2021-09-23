package domain;

/**
 * ListNode handles the actions to be performed on the nodes
 * within a linked list.
 */
public class ListNode extends ListItem {

    // constructor
    public ListNode(Object value) {
        super(value);
    }

    // methods

    @Override
    ListItem previousItem() {
        return this.previous;
    }

    @Override
    ListItem nextItem() {
        return this.next;
    }

    @Override
    void setPreviousItem(ListItem newNode) {
        if (this.previous != null) {
            ListItem copy = this.previousItem();
            newNode.previous = copy;
            copy.next = newNode;
        }
        newNode.next = this;
        this.previous = newNode;
    }

    @Override
    void setNextItem(ListItem newNode) {
        newNode.previous = this;
        this.next = newNode;
    }

    @Override
    int compareTo(ListItem otherItem) {

        if (this.value.equals(otherItem.getValue())) {
            return 0;
        } else if (((String) this.value).compareTo((String) otherItem.getValue()) > 0)  {
            return -1;
        } else {
            return 1;
        }
    }

    @Override
    ListItem returnToHead(ListItem cursor) {
        while (cursor.previous != null) {
             cursor = cursor.previous;
        }
        return cursor;
    }

    @Override
    void deleteNode(ListItem cursor) {
        ListNode prev = (ListNode) cursor.previous;
        cursor = (ListNode) cursor.nextItem();
        prev.next = cursor;
    }
}
