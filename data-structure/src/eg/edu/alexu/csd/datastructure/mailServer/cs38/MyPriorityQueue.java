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
    int key;

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
     * @param newkey
     *          ...
     */
    public PNode(final Object newItem, final PNode newNext, final int newkey) {
      // TODO Auto-generated constructor stub
      this.item = newItem;
      this.next = newNext;
      this.key = newkey;
    }
  }

  /**
   *
   */
  public MyPriorityQueue() {
    // TODO Auto-generated constructor stub
    size = 0;
    head = new PNode(null, null, 0);
  }

  @Override
  public final void insert(final Object item, final int key) {
    // TODO Auto-generated method stub
    if (key < 1) {
      throw new RuntimeException();
    }
    if (size == 0) {
      head = new PNode(item, null, key);
      size++;
      return;
    }
    PNode newNode = new PNode(item, null, key);
    PNode n = head;
    if (size == 1) {
      if (head.getKey() >= key) {
        newNode.setNext(n);
        head = newNode;
      } else {
        head.setNext(newNode);
      }
      size++;
      return;
    }
    for (int i = 0; i < size && n.getNext() != null; i++) {
      if (n.getNext().getKey() >= key) {
        break;
      }
      n = n.getNext();
    }
    PNode cu = n.getNext();
    newNode.setNext(cu);
    n.setNext(newNode);
    size++;
  }

  @Override
  public final Object removeMin() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new RuntimeException();
    }
    Object ret = head.getItem();
    PNode deleted = head;
    head = deleted.getNext();
    deleted.setNext(null);
    size--;
    return ret;
  }

  @Override
  public final Object min() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new RuntimeException();
    }
    return head.getItem();
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
