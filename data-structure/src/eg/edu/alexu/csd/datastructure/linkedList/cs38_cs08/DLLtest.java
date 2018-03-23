
package eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author DELL
 *
 */
public class DLLtest {

  /**
   * testcase1 to test.
   **/
  @Test
  public void testcase1() {
    DLinkedList object = new DLinkedList();
    final int n = 6;
    for (int i = 0; i < n; i++) {
      object.add(i, i);
    }
    object.set(1, n + 2 + 2);
    final int n1 = 40;
    object.set(n - 2, n1);
    object.remove(1);
    assertEquals(object.get(1), 2);
  }

  /**
   * testcase2 to test.
   **/
  @Test
  public void testcase2() {
    DLinkedList c = new DLinkedList();
    final int n = 3;
    for (int i = 0; i < n; i++) {
      c.add(i);
    }
    c.add(0, n);
    c.add(n + 1, n + 1);

    assertTrue(c.contains(n + 1));
    assertTrue(c.contains(0));
    assertTrue(c.contains(1));
    assertTrue(c.contains(2));
    assertTrue(c.contains(n));
    final int n1 = 7;
    assertFalse(c.contains(n1 + 2));
    assertFalse(c.contains(n1));
  }

  /**
   * testcase3 to test.
   **/
  @Test
  public void testcase3() {
    DLinkedList test = new DLinkedList();
    final int n = 5;
    for (int i = n; i < n + n + n; ++i) {
      test.add(Integer.valueOf(i));
    }
    final int n1 = 1000000;
    test.add(Integer.valueOf(n1));
    assertEquals((2 * n + 1), test.size());
    assertEquals(true, test.contains(Integer.valueOf(n1)));
    assertEquals(false, test.contains(Integer.valueOf((n - 1))));
  }

  /**
   * testcase4 to test.
   **/
  @Test
  public void testcase4() {
    DLinkedList instance = new DLinkedList();
    final int n = 3;
    instance.add(1);
    instance.add(n);
    instance.add(n + 2);
    instance.set(1, 'F');
    assertEquals('F', instance.get(1));
  }

  /**
   * testcase5 to test.
   **/
  @Test
  public void testcase5() {
    DLinkedList instance = new DLinkedList();
    instance.add('a');
    instance.add('b');
    instance.add('c');
    instance.add('d');
    DLinkedList temp = instance.sublist(1, 2);
    assertEquals(temp.get(0), instance.get(1));
    assertEquals(temp.get(1), instance.get(2));
  }

  /**
   * testcase6 to test.
   **/
  @Test
  public void testcase6() {
    DLinkedList c = new DLinkedList();
    final int n = 3;
    final int n1 = 7;
    for (int i = 0; i < n; i++) {
      c.add(i);
    }
    c.add(0, n);
    c.add(n + 1, n + 1);
    c.set(1, n1);
    c.set(n + 1, n1 + 2);
    DLinkedList d = new DLinkedList();
    d.add(n);
    d.add(n1);
    d.add(1);
    d.add(2);
    d.add(n1 + 2);
    for (int i = 0; i < n + 2; i++) {
      assertEquals(c.get(i), d.get(i));
    }

  }

}
