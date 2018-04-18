package eg.edu.alexu.csd.datastructure.mailServer.cs38;

import eg.edu.alexu.csd.datastructure.mailServer.IPriorityQueue;

/**
 *
 * @author DELL
 *
 */
public class MyPriorityQueue implements IPriorityQueue {
  /**
   *
   */
  PNode head;
  /**
   *
   */
  PNode tail;
  /**
   *
   */
  int size;

  /**
   *
   * @author DELL
   *
   */
  public class PNode {
    /**
     *
     */
    Object item;
    /**
     *
     */
    PNode next;
    /**
     *
     */
    PNode prev;
    /**
     *
     */
    int key;

    /**
     *
     * @return prev
     */
    public PNode getPrev() {
      return prev;
    }

    /**
     *
     * @param newPrev
     *          ...
     */
    public void setPrev(final PNode newPrev) {
      this.prev = newPrev;
    }

    /**
     *
     * @return item.
     */
    public Object getItem() {
      return item;
    }

    /**
     *
     * @param newItem
     *          ...
     */
    public void setItem(final Object newItem) {
      this.item = newItem;
    }

    /**
     *
     * @return next.
     */
    public PNode getNext() {
      return next;
    }

    /**
     *
     * @param newNext
     *          ....
     */
    public void setNext(final PNode newNext) {
      this.next = newNext;
    }

    /**
     *
     * @return key
     */
    public int getKey() {
      return key;
    }

    /**
     *
     * @param newkey
     *          ....
     */
    public void setKey(final int newkey) {
      this.key = newkey;
    }

    /**
     *
     * @param newItem
     *          ...
     * @param newNext
     *          ..
     * @param newPrev
     *          ....
     * @param newkey
     *          ...
     */
    public PNode(final Object newItem, final PNode newNext, final PNode newPrev,
        final int newkey) {
      // TODO Auto-generated constructor stub
      this.item = newItem;
      this.next = newNext;
      this.prev = newPrev;
      this.key = newkey;
    }
  }

  /**
   *
   */
  public MyPriorityQueue() {
    // TODO Auto-generated constructor stub
    size = 0;
    head = new PNode(null, tail, null, 0);
    tail = new PNode(null, null, head, 0);
  }

  @Override
  public final void insert(final Object item, final int key) {
    // TODO Auto-generated method stub
    if (key < 1) {
      throw new RuntimeException();
    }
    PNode newNode = new PNode(item, null, null, key);
    if (size == 0) {
      head.setNext(newNode);
      newNode.setPrev(head);
      newNode.setNext(tail);
      tail.setPrev(newNode);
      size++;
      return;
    }
    if (size == 1) {
      if (head.getNext().getKey() > key) {
        newNode.setPrev(head);
        newNode.setNext(head.getNext());
        head.getNext().setPrev(newNode);
        head.setNext(newNode);
      } else {
        newNode.setNext(tail);
        newNode.setPrev(tail.getPrev());
        tail.getPrev().setNext(newNode);
        tail.setPrev(newNode);
      }
      size++;
      return;
    }
    PNode first = head.getNext();
    PNode last = tail.getPrev();
    for (int i = 0; i < size; i++) {
      if (key >= last.getKey()) {
        newNode.setNext(last.getNext());
        newNode.setPrev(last);
        last.getNext().setPrev(newNode);
        last.setNext(newNode);
        break;
      } else if (key < first.getKey()) {
        newNode.setPrev(first.getPrev());
        newNode.setNext(first);
        first.getPrev().setNext(newNode);
        first.setPrev(newNode);
        break;

      } else {
        first = first.getNext();
        last = last.getPrev();
      }
    }
    size++;
  }

  @Override
  public final Object removeMin() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new RuntimeException();
    }
    Object ret = head.getNext().getItem();
    if (size == 1) {
      size = 0;
      head = new PNode(null, tail, null, 0);
      tail = new PNode(null, null, head, 0);
      return ret;
    }
    PNode deleted = head.getNext();
    head.setNext(deleted.getNext());
    deleted.getNext().setPrev(head);
    deleted.setNext(null);
    deleted.setPrev(null);
    size--;
    return ret;
  }

  @Override
  public final Object min() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new RuntimeException();
    }
    return head.getNext().getItem();
  }

  @Override
  public final boolean isEmpty() {
    // TODO Auto-generated method stub
    return size == 0;
  }

  @Override
  public final int size() {
    // TODO Auto-generated method stub
    return size;
  }

}
