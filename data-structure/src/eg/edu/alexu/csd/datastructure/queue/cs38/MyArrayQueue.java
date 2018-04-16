package eg.edu.alexu.csd.datastructure.queue.cs38;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;

/**
 *
 * @author DELL
 *
 */
public class MyArrayQueue implements IQueue, IArrayBased {
  /**
   *
   */
  private int front;
  /**
   *
   */
  private int rear;
  /**
   *
   */
  private int cap;
  /**
   *
   */
  private int size;
  /**
   *
   */
  private Object[] array;

  /**
   *
   * @param capacity
   *          ....
   */
  public MyArrayQueue(final int capacity) {
    // TODO Auto-generated constructor stub
    this.cap = capacity;
    array = new Object[capacity];
    size = 0;
    front = -1;
    rear = -1;

  }

  @Override
  public final void enqueue(final Object item) {
    // TODO Auto-generated method stub
    if (size == cap) {
      throw new RuntimeException();
    }
    if (size == 0) {
      front = 0;
      rear = 0;
      array[front] = item;
      size++;
      return;
    }
    front = (front + 1) % cap;
    array[front] = item;
    size++;

  }

  @Override
  public final Object dequeue() {
    // TODO Auto-generated method stub
    if (size == 0) {
      throw new RuntimeException();
    }
    Object r = array[rear];
    array[rear] = null;
    rear = (rear + 1) % cap;
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
