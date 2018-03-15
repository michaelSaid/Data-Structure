package eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;

/**
 * doubly linked list .
 */
public class DLinkedList implements ILinkedList {
  /**
   * head node of the list.
   */
  public Node head;
  /**
   * tailer node of the end of list.
   */
  public Node tailer;
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
     * prev is a node to link between nodes.
     */
    private Node prev;
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
     * @param newprev
     *          .......
     */
    public Node(final Object newelement, final Node newnext,
        final Node newprev) {
      this.next = newnext;
      this.element = newelement;
      this.prev = newprev;
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

    /**
     * Returns the previous node of this node.
     *
     * @return prev
     */
    public Node getPrev() {
      return prev;
    }

    /**
     * Sets the prev node of this node.
     *
     * @param newprev
     *          prev node.
     */
    public void setPrev(final Node newprev) {
      this.prev = newprev;
    }

  }

  /** Default constructor that creates an empty list. */
  public DLinkedList() {
    // TODO Auto-generated constructor stub
    size = 0;
    head = new Node(null, null, null);
    tailer = new Node(null, null, head);
    head.setNext(tailer);

  }

  @Override
  public final void add(final int index, final Object element) {
    // TODO Auto-generated method stub
    if (index < 0 || index > size) {
      throw new RuntimeException();
    }
    Node newNode = new Node(element, null, null);
    Node node = head.getNext();
    if (index == 0) {
      if (head.getNext() == null) {
        head.setNext(newNode);
        newNode.setPrev(head);
        newNode.setNext(tailer);
        tailer.setPrev(newNode);
      } else {
        newNode.setNext(node);
        node.setPrev(newNode);
        newNode.setPrev(head);
        head.setNext(newNode);
      }
      size++;
      return;
    }
    if (index == size) {
      Node n = tailer.getPrev();
      n.setNext(newNode);
      newNode.setPrev(n);
      newNode.setNext(tailer);
      tailer.setPrev(newNode);
      size++;
      return;
    }
    for (int i = 0; i < index - 1 && node != tailer; i++) {
      node = node.getNext();
    }
    newNode.setNext(node.getNext());
    node.getNext().setPrev(newNode);
    node.setNext(newNode);
    newNode.setPrev(node);
    size++;
    return;
  }

  @Override
  public final void add(final Object element) {
    // TODO Auto-generated method stub
    Node newNode = new Node(element, null, tailer);
    if (head.getNext() == null) {
      head.setNext(newNode);
      newNode.setPrev(head);
      tailer.setPrev(newNode);
      size++;
      return;
    }
    Node node = tailer.getPrev();
    node.setNext(newNode);
    newNode.setPrev(node);
    tailer.setPrev(newNode);
    size++;
    return;
  }

  @Override
  public final Object get(final int index) {
    // TODO Auto-generated method stub
    if (index < 0 || index > size - 1 || size == 0) {
      throw new RuntimeException();
    }
    Node node = head.getNext();
    for (int i = 0; i < index && node != tailer; i++) {
      node = node.getNext();
    }
    return node.getElement();
  }

  @Override
  public final void set(final int index, final Object element) {
    // TODO Auto-generated method stub
    if (index < 0 || index > size - 1 || size == 0) {
      throw new RuntimeException();
    }
    Node node = head.getNext();
    for (int i = 0; i < index && node != tailer; i++) {
      node = node.getNext();
    }
    node.setElement(element);

  }

  @Override
  public final void clear() {
    // TODO Auto-generated method stub
    size = 0;
    head = new Node(null, null, null);
    tailer = new Node(null, null, head);
    head.setNext(tailer);
  }

  @Override
  public final boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
  }

  @Override
  public final void remove(final int index) {
    // TODO Auto-generated method stub
    if (head.getNext() == null || index < 0 || index > size - 1 || size == 0) {
      throw new RuntimeException();
    }
    Node node = head.getNext();
    if (index == 0) {
      head.setNext(node.getNext());
      node.getNext().setPrev(head);
      node.setNext(null);
      node.setPrev(null);
      size--;
      return;
    }
    if (index == size - 1) {
      Node re = tailer.getPrev();
      Node n = re.getPrev();
      n.setNext(tailer);
      tailer.setPrev(n);
      re.setNext(null);
      re.setPrev(null);
      size--;
      return;

    }
    for (int i = 0; i < index - 1 && node != tailer; i++) {
      node = node.getNext();
    }
    Node rem = node.getNext();
    Node last = node.getNext().getNext();
    last.setPrev(node);
    node.setNext(last);
    rem.setNext(null);
    rem.setPrev(null);
    size--;
    return;
  }

  @Override
  public final int size() {
    // TODO Auto-generated method stub
    return size;
  }

  @Override
  public final DLinkedList sublist(final int fromIndex, final int toIndex) {
    // TODO Auto-generated method stub
    if (fromIndex > toIndex || fromIndex > size - 1 || fromIndex < 0
        || toIndex < 0 || toIndex > size - 1 || head.getNext() == null
        || size == 0) {
      throw new RuntimeException();
    }
    DLinkedList sub = new DLinkedList();
    int s = toIndex - fromIndex + 1;
    for (int i = 0; i < s; i++) {
      sub.add(get(fromIndex + i));
    }
    return sub;
  }

  @Override
  public final boolean contains(final Object o) {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new RuntimeException();
    }
    if (head.getNext().getElement().equals(o)
        || tailer.getPrev().getElement().equals(o)) {
      return true;
    }
    Node node = head.getNext();
    while (node != tailer) {
      if (node.getElement().equals(o)) {
        return true;
      }
      node = node.getNext();
    }
    return false;
  }

}
