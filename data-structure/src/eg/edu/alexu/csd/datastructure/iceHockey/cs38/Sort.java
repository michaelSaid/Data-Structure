package eg.edu.alexu.csd.datastructure.iceHockey.cs38;

import java.awt.Point;
import java.util.Comparator;
/*
 * sort is function to sort points
**/

public class Sort implements Comparator<Point> {

  @Override
  public final int compare(final Point arg0, final Point arg1) {
    // TODO Auto-generated method stub
    int x = Integer.compare(arg0.x, arg1.x);
    if (x == 0) {
      return Integer.compare(arg0.y, arg1.y);
    } else {
      return x;
    }
  }

}
