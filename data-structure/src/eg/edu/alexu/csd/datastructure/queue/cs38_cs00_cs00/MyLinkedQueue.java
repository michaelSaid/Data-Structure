package eg.edu.alexu.csd.datastructure.queue.cs38_cs00_cs00;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 *
 * @author DELL
 *
 */
public class MyLinkedQueue implements IQueue, ILinkedBased {

  /**
   *
   */
  private QNode front;
  /**
  *
  */
  private QNode back;
  /**
   *
   */
  private int size;

  /**
   *
   * @author DELL
   *
   */
  public class QNode {
    /**
     *
     */
    private Object item;

    /**
     *
     */
    private QNode next;
    /**
     *
     */
    private QNode prev;

    /**
     *
     * @return prev.
     */
    public QNode getPrev() {
      return prev;
    }

    /**
     *
     * @param newPrev
     *          ....
     */
    public void setPrev(final QNode newPrev) {
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
     *          .........
     */
    public void setItem(final Object newItem) {
      this.item = newItem;
    }

    /**
     *
     * @return next.
     *
     */
    public QNode getNext() {
      return next;
    }

    /**
     *
     * @param newNext
     *          .......
     */
    public void setNext(final QNode newNext) {
      this.next = newNext;
    }

    /**
     *
     * @param newNext
     *          ...
     * @param newPrev
     *          ..
     * @param newItem
     *          ...
     */
    public QNode(final QNode newNext, final QNode newPrev,
        final Object newItem) {
      // TODO Auto-generated constructor stub
      this.item = newItem;
      this.next = newNext;
      this.prev = newPrev;

    }
  }

  /**
   *
   */
  public MyLinkedQueue() {
    // TODO Auto-generated constructor stub
    front = new QNode(back, null, null);
    back = new QNode(null, front, null);
    size = 0;

  }

  @Override
  public final void enqueue(final Object item) {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      back.setItem(item);
    } else if (size() == 1) {
      front.setItem(item);
    } else {
      QNode newNode = new QNode(null, null, item);
      QNode temp = front;
      newNode.setNext(temp);
      temp.setPrev(newNode);
      front = newNode;
    }
    size++;
  }

  @Override
  public final Object dequeue() {
    // TODO Auto-generated method stub
    if (isEmpty()) {
      throw new RuntimeException();
    }
    Object r = back.getItem();
    QNode deleted = back;
    back = deleted.getPrev();
    back.setNext(null);
    size--;
    return r;
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
