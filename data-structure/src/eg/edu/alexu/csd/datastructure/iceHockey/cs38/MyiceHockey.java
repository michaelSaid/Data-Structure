package eg.edu.alexu.csd.datastructure.iceHockey.cs38;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
/**
 * @author DELL
 *
 *
 */
import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 * the solve.
**/
public class MyiceHockey implements IPlayersFinder {

  /**
   * photo is array of string.
   **/
  String[] ph;
  /**
   * team is a num of team.
   **/
  Integer te;
  /**
   * length with x.
   **/
  int lenX;
  /**
   * length with x.
   **/
  int lenY;
  /**
   * boolean array of visiting.
   **/
  boolean[][] visit;
  /**
   * length of chains.
   **/
  int len;
  /**
   * mini x.
   **/
  int miniX;
  /**
   * mini y.
   **/
  int miniY;
  /**
   * max x.
   **/
  int maxX;
  /**
   * max y.
   **/
  int maxY;

  @Override
  public final Point[] findPlayers(final String[] photo, final int team,
      final int threshold) {
    // TODO Auto-generated method stub
    this.ph = photo;
    this.te = team;
    if (photo == null) {
      return null;
    }
    lenX = photo[0].length();
    lenY = photo.length;
    visit = new boolean[lenX][lenY];
    if (photo.length == 0) {
      return null;
    }
    int i, j;
    final int con = 4;
    Queue<Point> p = new LinkedList<>();
    for (i = 0; i < lenY; i++) {
      for (j = 0; j < lenX; j++) {
        setPo(j, i);
        dFS(j, i);
        if (len * con >= threshold) {
          p.add(setPoint());
        }
        len = 0;

      }
    }
    int size = p.size();
    Point[] points = new Point[size];
    for (i = 0; i < size; i++) {
      points[i] = p.remove();
    }
    Arrays.sort(points, new Sort());
    return points;
  }

  /**
   * function to check.
   * @param row
   * num of rows
   * @param col
   * num of col
   * @return ... .
   */
  public final boolean isVaild(final int row, final int col) {
    return row >= 0 && row < lenX && col >= 0 && col < lenY;
  }
  /**
   * function to check.
   * @param row
   * num of rows
   * @param col
   * num of col
   */
  public final void setDefault(final int col, final int row) {
    if (miniX > 2 * col) {
      miniX = 2 * col;
    }
    if (miniY > 2 * row) {
      miniY = 2 * row;
    }
    if (maxX < 2 * (col + 1)) {
      maxX = 2 * (col + 1);
    }
    if (maxY < 2 * (row + 1)) {

      maxY = 2 * (row + 1);
    }
  }
  /**
   * function to check.
   * @param row
   * num of rows
   * @param col
   * num of col
   */
  public final void setPo(final int col, final int row) {
    miniX = 2 * col;
    miniY = 2 * row;
    maxX = 2 * (col + 1);
    maxY = 2 * (row + 1);
  }
  /**
   * function to DFS .
   * @param row
   * num of rows
   * @param col
   * num of col
   */
  public final void dFS(final int row, final int col) {

    if (isVaild(row, col)) {
      if (ph[col].charAt(row) == te.toString().charAt(0)
          && !visit[row][col]) {
        visit[row][col] = true;
        len++;
        setDefault(row, col);
      } else {
        return;
      }
    } else {
      return;
    }
    dFS(row + 1, col);
    dFS(row, col + 1);
    dFS(row - 1, col);
    dFS(row, col - 1);
  }
  /**
   * function to set points.
   * @return ... .
   **/
  public final Point setPoint() {
    Point p = new Point();
    p.x = (maxX + miniX) / 2;
    p.y = (maxY + miniY) / 2;
    return p;
  }

}
