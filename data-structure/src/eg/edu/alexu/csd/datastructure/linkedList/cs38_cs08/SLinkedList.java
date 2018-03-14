package eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

public class SLinkedList implements ILinkedList {
  /**
   * head node of the list.
   */
  public Node head;
  /**
   * size of the list.
   */
  public int size;

  /** Node of a singly linked list of strings. */
  public class Node {
    /**
     * next is a node to link between nodes.
     */
    private Node next;
    /**
     * the value of node.
     */
    private Object element;

    /**
     * Creates a node with the given element and next node.
     * 
     * @param newelement
     *          ...
     * @param newnext
     *          ....
     */
    public Node(final Object newelement, final Node newnext) {
      this.next = newnext;
      this.element = newelement;
    }

    /**
     * Returns the next node of this node.
     * 
     * @return next
     */
    public Node getNext() {
      return next;
    }

    /**
     * Sets the next node of this node.
     * 
     * @param newnext
     *          next node.
     */
    public void setNext(final Node newnext) {
      this.next = newnext;
    }

    /**
     * Returns the element of this node.
     * 
     * @return element
     */
    public Object getElement() {
      return element;
    }

    /**
     * Sets the element of this node.
     * 
     * @param newelement
     *          element of node.
     */
    public void setElement(final Object newelement) {
      this.element = newelement;
    }

  }

  /** Default constructor that creates an empty list. */
  public SLinkedList() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public final void add(final int index, final Object element) {
    // TODO Auto-generated method stub
    Node newNode = new Node(element, null);
    if (head == null) {
      head = newNode;
      size++;
      return;
    }
    if (index < 0 || index > size) {
      throw new RuntimeException();
    }
    Node node = head;
    for (int i = 0; i < index - 1 && node != null; i++) {
      node = node.getNext();
    }
    newNode.setNext(node.getNext());
    node.setNext(newNode);
    size++;
    return;
  }

  @Override
  public final void add(final Object element) {
    // TODO Auto-generated method stub
    Node newNode = new Node(element, null);
    if (head == null) {
      head = newNode;
      size++;
      return;
    }
    Node node = head;
    while (node.getNext() != null) {
      node = node.getNext();
    }
    node.setNext(newNode);
    newNode.setNext(null);
    size++;
    return;
  }

  @Override
  public final Object get(final int index) {
    // TODO Auto-generated method stub
    if (index < 0 || index > size - 1 || head == null) {
      throw new RuntimeException();
    }
    Node node = head;
    for (int i = 0; i < index && node != null; i++) {
      node = node.getNext();
    }
    return node.getElement();
  }

  @Override
  public final void set(final int index, final Object element) {
    // TODO Auto-generated method stub
    if (index < 0 || index > size - 1 || head == null) {
      throw new RuntimeException();
    }
    Node node = head;
    for (int i = 0; i < index && node != null; i++) {
      node = node.getNext();
    }
    node.setElement(element);

  }

  @Override
  public final void clear() {
    // TODO Auto-generated method stub
    head = null;
    size = 0;

  }

  @Override
  public final boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
  }

  @Override
  public final void remove(final int index) {
    // TODO Auto-generated method stub
    if (head == null || index < 0 || index > size - 1) {
      throw new RuntimeException();
    }
    if (index == 0) {
      head = head.getNext();
      size--;
      return;
    }
    Node node = head;
    for (int i = 0; i < index - 1 && node != null; i++) {
      node = node.getNext();
    }
    node.setNext(node.getNext().getNext());
    size--;
    return;
  }

  @Override
  public final int size() {
    // TODO Auto-generated method stub
    return size;
  }

  @Override
  public final SLinkedList sublist(final int fromIndex, final int toIndex) {
    // TODO Auto-generated method stub
    if (fromIndex > toIndex || fromIndex > size - 1 || fromIndex < 0
        || toIndex < 0 || toIndex > size - 1 || head == null) {
      throw new RuntimeException();
    }
    SLinkedList sub = new SLinkedList();
    int s = toIndex - fromIndex + 1;
    for (int i = 0; i < s; i++) {
      sub.add(get(fromIndex + i));
    }
    return sub;
  }

  @Override
  public final boolean contains(final Object o) {
    // TODO Auto-generated method stub
    if (size == 0 || head == null) {
      throw new RuntimeException();
    }
    boolean found = false;
    Node node = head;
    while (node != null) {
      if (node.getElement() == o) {
        found = true;
        break;
      }
      node = node.getNext();
    }
    return found;
  }

}
