package eg.edu.alexu.csd.datastructure.stack.cs38;

import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 *
 * @author DELL
 *
 */
public class MyStack implements IStack {

  /**
   *
   */
  SNode top;
  /**
   *
   */
  int size;

  /**
   *
   * class stack node.
   *
   */
  public class SNode {
    /**
     *
     */
    private SNode next;
    /**
     *
     */
    private Object element;

    /**
     *
     * @return next
     */
    public SNode getNext() {
      return next;
    }

    /**
     *
     * @param newNext
     *          ....
     */
    public void setNext(final SNode newNext) {
      this.next = newNext;
    }

    /**
     *
     * @return element
     */
    public Object getElement() {
      return element;
    }

    /**
     *
     * @param newElement
     *          .....
     */
    public void setElement(final Object newElement) {
      this.element = newElement;
    }

    /**
     *
     * @param newNext
     *          ...
     * @param newElement
     *          ...
     */
    public SNode(final SNode newNext, final Object newElement) {
      this.element = newElement;
      this.next = newNext;
    }
  }

  /**
   *
   */
  public MyStack() {
    // TODO Auto-generated constructor stub
    top = new SNode(null, null);
    size = 0;
  }

  @Override
  public final Object pop() {
    // TODO Auto-generated method stub
    if (top == null || size == 0) {
      throw new RuntimeException();
    }
    Object pop = top.getElement();
    top = top.getNext();
    size--;
    return pop;
  }

  @Override
  public final Object peek() {
    // TODO Auto-generated method stub
    if (top == null || size == 0) {
      throw new RuntimeException();
    }
    return top.getElement();
  }

  @Override
  public final void push(final Object element) {
    // TODO Auto-generated method stub
    SNode newNode = new SNode(null, element);
    SNode node = top;
    newNode.setNext(node);
    top = newNode;
    size++;
    return;
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
