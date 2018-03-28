package eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

/**
 * @author DELL
 *
 */

class Polytest {

  /**
   * testcase1 to test.
   **/
  @Test
  public void testcase1() {
    solve instance = new solve();
   final int[][] temp1 = new int[][] {{3, 7}, {45, 5}, {176, 3}, {128, 1}};
    instance.setPolynomial('C', temp1);
    final int[][] temp2 = new int[][] {{-120, 5},
      {-1, 3}, {27, 2}, {1, 1}, {-1, 0}};
    instance.setPolynomial('B', temp2);
    assertNull("Polynomial R is not set yet", instance.print('R'));
    int[][] result1 = instance.add('B', 'C');
    assertNotNull("Polynomial R must be set after evaluation",
        instance.print('R'));
    final int[][] expected = new int[][] {{3, 7}, {-75, 5}, {175, 3},
        {27, 2}, {129, 1}, {-1, 0}};
    assertArrayEquals(expected, result1);
  }
  /**
   * testcase2 to test.
   **/
  @Test
  public void testcase2() {
    solve instance = new solve();
   final int[][] temp1 = new int[][] {{1, 1}, {1, 0}};
    instance.setPolynomial('A', temp1);
    final int[][] temp2 = new int[][] {{1, 1}, {-1, 0}};
    instance.setPolynomial('B', temp2);
    assertNull("Polynomial R is not set yet", instance.print('R'));
    int[][] result1 = instance.multiply('B', 'A');
    assertNotNull("Polynomial R must be set after evaluation",
        instance.print('R'));
    final int[][] expected = new int[][] {{1, 2}, {-1, 0}};
    assertArrayEquals(expected, result1);
  }
  /**
   * testcase3 to test.
   **/
  @Test
  public void testcase3() {
    solve instance = new solve();
   final int[][] temp1 = new int[][] {{1, 1}, {1, 0}};
    instance.setPolynomial('A', temp1);
    final int[][] temp2 = new int[][] {{1, 1}, {-1, 0}};
    instance.setPolynomial('B', temp2);
    assertNull("Polynomial R is not set yet", instance.print('R'));
    int[][] result1 = instance.add('B', 'A');
    assertNotNull("Polynomial R must be set after evaluation",
        instance.print('R'));
    final int[][] expected = new int[][] {{2, 1}};
    assertArrayEquals(expected, result1);
  }
  /**
   * testcase4 to test.
   **/
  @Test
  public void testcase4() {
    solve instance = new solve();
   final int[][] temp1 = new int[][] {{1, 1}, {1, 0}};
    instance.setPolynomial('A', temp1);
    final int[][] temp2 = new int[][] {{1, 1}, {-1, 0}};
    instance.setPolynomial('B', temp2);
    assertNull("Polynomial R is not set yet", instance.print('R'));
    int[][] result1 = instance.subtract('B', 'A');
    assertNotNull("Polynomial R must be set after evaluation",
        instance.print('R'));
    final int[][] expected = new int[][] {{-2, 0}};
    assertArrayEquals(expected, result1);
  }
  /**
   * testcase5 to test.
   **/
  @Test
  public void testcase5() {
    solve instance = new solve();
   final int[][] temp1 = new int[][] {{1, 1}, {1, 0}};
    instance.setPolynomial('A', temp1);
    final int[][] temp2 = new int[][] {{1, 1}, {-1, 0}};
    instance.setPolynomial('B', temp2);
    assertNull("Polynomial R is not set yet", instance.print('R'));
    int[][] result1 = instance.subtract('A', 'B');
    assertNotNull("Polynomial R must be set after evaluation",
        instance.print('R'));
    final int[][] expected = new int[][] {{2, 0}};
    assertArrayEquals(expected, result1);
  }
}
