package eg.edu.alexu.csd.datastructure.maze.cs38;

import eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08.DLinkedList;

public class Cell {
  /**
  *
  */
  char data;

  /**
  *
  */
  int x;
  /**
  *
  */
  int y;
  /**
  *
  */
  DLinkedList neighbour;

  /**
   *
   * @return data.
   */
  public char getData() {
    return data;
  }

  /**
   *
   * @param newData
   *          .......
   */
  public void setData(final char newData) {
    this.data = newData;
  }

  /**
   *
   * @return x.
   */
  public int getX() {
    return x;
  }

  /**
   *
   * @param newX
   *          .....
   */
  public void setX(final int newX) {
    this.x = newX;
  }

  /**
   *
   * @return y.
   */
  public int getY() {
    return y;
  }

  /**
   *
   * @param newY
   *          ....
   */
  public void setY(final int newY) {
    this.y = newY;
  }

  /**
   *
   * @return neighour.
   */
  public DLinkedList getNeighbour() {
    return neighbour;
  }

  /**
   *
   * @param map
   *          ...
   */
  public final void setNeighbour(final String[] map) {
    int[] a = new int[] {-1, -1, 1, 1};
    int maxY = map.length - 1;
    int maxX = map[0].length() - 1;
    for (int i = 0; i < a.length; i++) {
      if (i % 2 == 0) {
        if ((x + a[i]) <= maxX && (x + a[i]) >= 0) {
          if (map[y].charAt(x + a[i]) != '#') {
            Cell t = new Cell(map[y].charAt(x + a[i]));
            t.setX(x + a[i]);
            t.setY(y);
            neighbour.add(t);
          }
        }
      } else {
        if ((y + a[i]) <= maxY && (y + a[i]) >= 0) {
          if (map[y + a[i]].charAt(x) != '#') {
            Cell t = new Cell(map[y + a[i]].charAt(x));
            t.setX(x);
            t.setY(y + a[i]);
            neighbour.add(t);
          }
        }
      }
    }
  }

  /**
   *
   * @param newData
   *          ....
   */
  public Cell(final char newData) {
    this.data = newData;
    neighbour = new DLinkedList();
  }

  /**
   * @return ....
   * @param obj
   *          ....
   */
  public boolean equals(final Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    Cell tmp = (Cell) obj;
    return tmp.getX() == this.getX() && this.getY() == tmp.getY();
  }

  /**
   * @return ....
   */
  public int hashCode() {
    return 0;
  }
}
