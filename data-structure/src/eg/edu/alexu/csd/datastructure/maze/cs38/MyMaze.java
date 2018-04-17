package eg.edu.alexu.csd.datastructure.maze.cs38;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;

import eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08.DLinkedList;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs38.MyLinkedQueue;
import eg.edu.alexu.csd.datastructure.stack.cs38.MyStack;

/**
 *
 * @author DELL
 *
 */
public class MyMaze implements IMazeSolver {
  /**
   *
   */
  File m;
  /**
   *
   */
  int sX;
  /**
   *
   */
  int sY;

  @Override
  public final int[][] solveBFS(final File maze) {
    // TODO Auto-generated method stub
    this.m = maze;
    String[] map = {""};
    try {
      map = (String[]) readFile();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (sX <= 0 || sY <= 0 || sY != map.length) {
      throw new RuntimeException();
    }
    MyLinkedQueue s = new MyLinkedQueue();
    DLinkedList coo = new DLinkedList();
    DLinkedList visited = new DLinkedList();
    Cell[][] prev = new Cell[map.length][map[0].length()];
    Cell t = findS(map);
    if (t == null) {
      throw new RuntimeException();
    }
    s.enqueue(t);
    while (!s.isEmpty()) {
      t = (Cell) s.dequeue();
      visited.add(t);
      coo.add(t);
      if (t.getData() == 'E') {
        break;
      }
      t.setNeighbourBfs(map);
      for (int i = 0; i < t.getNeighbour().size(); i++) {
        Cell c = (Cell) t.getNeighbour().get(i);
        if (!visited.contains(c)) {
          s.enqueue(c);
          visited.add(c);
          prev[c.getY()][c.getX()] = t;
        }
      }
    }
    if (t.getData() != 'E') {
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[0].length(); j++) {
          if (map[i].charAt(j) == 'E') {
            return null;
          }
        }
      }
      throw new RuntimeException();
    }
    coo.clear();
    for (;;) {
      coo.add(t);
      t = prev[t.getY()][t.getX()];
      if (t == null) {
        break;
      }
    }
    int[][] r = new int[coo.size][2];
    for (int i = 0; i < coo.size(); i++) {
      Cell c = (Cell) coo.get(coo.size() - 1 - i);
      r[i][0] = c.getY();
      r[i][1] = c.getX();
    }
    return r;
  }

  @Override
  public final int[][] solveDFS(final File maze) {
    // TODO Auto-generated method stub
    this.m = maze;
    String[] map = {""};
    try {
      map = (String[]) readFile();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    MyStack s = new MyStack();
    DLinkedList coo = new DLinkedList();
    DLinkedList visited = new DLinkedList();
    Cell t = findS(map);
    if (t == null) {
      throw new RuntimeException();
    }
    s.push(t);
    while (!s.isEmpty()) {
      t = (Cell) s.pop();
      visited.add(t);
      coo.add(t);
      if (t.getData() == 'E') {
        break;
      }
      t.setNeighbourDfs(map);
      for (int i = 0; i < t.getNeighbour().size(); i++) {
        Cell c = (Cell) t.getNeighbour().get(i);
        if (!visited.contains(c)) {
          s.push(c);
          visited.add(c);
        }
      }
    }
    if (t.getData() != 'E') {
      for (int i = 0; i < map.length; i++) {
        for (int j = 0; j < map[0].length(); j++) {
          if (map[i].charAt(j) == 'E') {
            return null;
          }
        }
      }
      throw new RuntimeException();
    }
    int[][] r = new int[coo.size][2];
    for (int i = 0; i < coo.size(); i++) {
      Cell c = (Cell) coo.get(i);
      r[i][0] = c.getY();
      r[i][1] = c.getX();
    }
    return r;
  }

  /**
   *
   * @return r
   * @throws Exception
   *           ....
   */
  public String[] readFile() throws Exception {
    BufferedReader in = new BufferedReader(new FileReader(m));
    String s;
    LinkedList<String> r = new LinkedList<String>();
    s = in.readLine();
    int i;
    for (i = 0; i < s.length(); i++) {
      if (s.substring(i, i + 1).equals(" ")) {
        break;
      }
    }
    sY = Integer.valueOf(s.substring(0, i));
    sX = Integer.valueOf(s.substring(i + 1));
    while ((s = in.readLine()) != null) {
      r.add(s);
    }
    in.close();
    return r.toArray(new String[r.size()]);
  }

  /***
   *
   * @param map
   *          ...
   * @return s
   */
  public static Cell findS(final String[] map) {
    Cell s = new Cell('S');
    s.setData('S');
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[0].length(); j++) {
        if (map[i].charAt(j) == s.getData()) {
          s.setX(j);
          s.setY(i);
          return s;
        }
      }
    }
    return null;
  }
}
