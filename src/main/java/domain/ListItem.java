package domain;

/**
 * Abstract class functioning as a blueprint
 * for a node (list item).
 */
public abstract class ListItem {

    // instance fields
    ListItem previous;
    ListItem next;
    Object value;

    // constructors
    public ListItem(Object value) {
        this.previous = null;
        this.next = null;
        this.value = value;
    }

    // getter
    public Object getValue() {
        return value;
    }

    // abstract methods
    abstract ListItem previousItem();

    abstract ListItem nextItem();

    abstract void setPreviousItem(ListItem newNode);

    abstract void setNextItem(ListItem newNode);

    abstract ListItem returnToHead(ListItem newNode);

    abstract int compareTo(ListItem otherItem);

    abstract void deleteNode(ListItem cursor);

    /**
     * Prints values within linked list to console.
     * @param node containing value
     */
    void print(ListItem node) {
        int counter = 1;
        while (node != null) {
            System.out.println("Value " + counter + " : " + node.value);
            node = node.nextItem();
            counter++;
        }
    }
}
