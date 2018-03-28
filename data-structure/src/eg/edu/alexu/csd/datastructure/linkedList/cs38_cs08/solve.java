package eg.edu.alexu.csd.datastructure.linkedList.cs38_cs08;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;

public class solve implements IPolynomialSolver {

  /**
   *
   */
  DLinkedList A;
  /**
   *
   */
  DLinkedList B;
  /**
   *
   */
  DLinkedList C;
  /**
   *
   */
  DLinkedList R;

  /**
  *
  */
  public static class Term {
    /**
    *
    */
    private Integer coff;
    /**
    *
    */
    private Integer exp;

    /**
     * @return coff
     */
    public Integer getCoff() {
      return coff;
    }

    /**
     *
     * @param newCoff
     *          ....
     */
    public void setCoff(final Integer newCoff) {
      this.coff = newCoff;
    }

    /**
     * @return exp
     */
    public Integer getExp() {
      return exp;
    }

    /**
     * @param newExp
     *          .....
     */
    public void setExp(final Integer newExp) {
      this.exp = newExp;
    }

    /**
     * Default constructor that creates term.
     *
     * @param co
     *          ...
     * @param ex
     *          ....
     */
    public Term(final Integer co, final Integer ex) {
      this.coff = co;
      this.exp = ex;
    }
  }

  @Override
  public final void setPolynomial(final char poly, final int[][] terms) {
    // TODO Auto-generated method stub
    DLinkedList temp = new DLinkedList();
    for (int i = 0; i < terms.length; i++) {
      Term term = new Term(terms[i][0], terms[i][1]);
      int j;
      boolean flag = false;
      for (j = 0; j < temp.size(); j++) {
        Term te = (Term) temp.get(j);
        if (term.getExp() == te.getExp()) {
          temp.set(j, new Term(term.getCoff() + te.getCoff(), term.getExp()));
          flag = true;
          break;
        }
        if (term.getExp() > te.getExp()) {
          break;
        }
      }
      if (!flag) {
        temp.add(j, term);
      }
    }
    if (poly == 'A') {
      A = temp;
    } else if (poly == 'B') {
      B = temp;
    } else if (poly == 'C') {
      C = temp;
    } else if (poly == 'R') {
      R = temp;
    } else {
      throw new RuntimeException();
    }
  }

  @Override
  public final String print(final char poly) {
    // TODO Auto-generated method stub
    DLinkedList temp = new DLinkedList();
    if (poly == 'A') {
      temp = A;
    } else if (poly == 'B') {
      temp = B;
    } else if (poly == 'C') {
      temp = C;
    } else if (poly == 'R') {
      temp = R;
    } else {
      throw new RuntimeException();
    }
    if (temp == null || temp.size() == 0) {
      return null;
    }
    String pol = new String("");
    String x = "x^";
    for (int i = 0; i < temp.size(); i++) {
      Term term = (Term) temp.get(i);
      Integer coff = term.getCoff();
      Integer exp = term.getExp();
      if (coff != 0 && exp > 0) {
        if (coff != 1 && coff != -1) {
          if (i != 0) {
            if (coff > 0) {
              pol += "+ ";
            } else {
              pol += "- ";
            }
          }
          coff = Math.abs(coff);
          pol += coff.toString();
        } else if (coff == 1 && i != 0) {
          pol += "+ ";
        } else if (coff == -1) {
          pol += "- ";
        }
        if (exp != 1) {
          pol += x + exp.toString();
        } else {
          pol += "x";
        }
      } else if (coff != 0 && exp < 0) {
        if (i != 0) {
          if (coff > 0) {
            pol += "+ ";
          } else {
            pol += "- ";
          }
        }
        if (coff != 1 && coff != -1) {
          coff = Math.abs(coff);
          pol += coff.toString();
        }
        if (exp != 1) {
          pol += x + exp.toString();
        } else {
          pol += "x";
        }

      } else if (coff != 0 && exp == 0) {
        if (coff > 0 && i != 0) {
          pol += "+ ";
        } else if (coff < 0) {
          pol += "- ";
        }
        coff = Math.abs(coff);
        pol += coff.toString();
      }
      if (i != temp.size() - 1 && coff != 0) {
        pol += " ";
      }
    }
    return pol;
  }

  @Override
  public final void clearPolynomial(final char poly) {
    // TODO Auto-generated method stub
    if (poly == 'A' && A != null) {
      A.clear();
    } else if (poly == 'B' && B != null) {
      B.clear();
    } else if (poly == 'C' && C != null) {
      C.clear();
    } else if (poly == 'R' && R != null) {
      R.clear();
    } else {
      throw new RuntimeException();
    }
  }

  @Override
  public final float evaluatePolynomial(final char poly, final float value) {
    // TODO Auto-generated method stub
    DLinkedList temp = new DLinkedList();
    if (poly == 'A') {
      temp = A;
    } else if (poly == 'B') {
      temp = B;
    } else if (poly == 'C') {
      temp = C;
    } else if (poly == 'R') {
      temp = R;
    } else {
      throw new RuntimeException();
    }
    if (temp == null || temp.size() == 0) {
      throw new RuntimeException();
    }
    float res = 0;
    for (int i = 0; i < temp.size(); i++) {
      Term term = (Term) temp.get(i);
      Float coff = term.getCoff().floatValue();
      Float exp = term.getExp().floatValue();

      res += (coff * (Math.pow(value, exp)));
    }
    return res;
  }

  @Override
  public final int[][] add(final char poly1, final char poly2) {
    // TODO Auto-generated method stub
    DLinkedList temp1 = new DLinkedList();
    DLinkedList temp2 = new DLinkedList();
    if (poly1 == 'A') {
      temp1 = A;
    } else if (poly1 == 'B') {
      temp1 = B;
    } else if (poly1 == 'C') {
      temp1 = C;
    } else if (poly1 == 'R') {
      temp1 = R;
    } else {
      throw new RuntimeException();
    }
    if (temp1 == null || temp1.size() == 0) {
      throw new RuntimeException();
    }
    if (poly2 == 'A') {
      temp2 = A;
    } else if (poly2 == 'B') {
      temp2 = B;
    } else if (poly2 == 'C') {
      temp2 = C;
    } else if (poly2 == 'R') {
      temp2 = R;
    } else {
      throw new RuntimeException();
    }
    if (temp2 == null || temp2.size() == 0) {
      throw new RuntimeException();
    }
    R = new DLinkedList();
    R = add2Poly(temp1, temp2);
    sort(R);
    int[][] terms = new int[R.size()][2];
    for (int i = 0; i < R.size(); i++) {
      Term te = (Term) R.get(i);
      terms[i][0] = te.getCoff();
      terms[i][1] = te.getExp();
    }
    return terms;
  }

  @Override
  public final int[][] subtract(final char poly1, final char poly2) {
    // TODO Auto-generated method stub
    DLinkedList temp1 = new DLinkedList();
    DLinkedList temp2 = new DLinkedList();
    if (poly1 == 'A') {
      temp1 = A;
    } else if (poly1 == 'B') {
      temp1 = B;
    } else if (poly1 == 'C') {
      temp1 = C;
    } else if (poly1 == 'R') {
      temp1 = R;
    } else {
      throw new RuntimeException();
    }
    if (temp1 == null || temp1.size() == 0) {
      throw new RuntimeException();
    }
    if (poly2 == 'A') {
      temp2 = A;
    } else if (poly2 == 'B') {
      temp2 = B;
    } else if (poly2 == 'C') {
      temp2 = C;
    } else if (poly2 == 'R') {
      temp2 = R;
    } else {
      throw new RuntimeException();
    }
    if (temp2 == null || temp2.size() == 0) {
      throw new RuntimeException();
    }
    R = new DLinkedList();
    boolean[] t1 = new boolean[temp1.size()];
    boolean[] t2 = new boolean[temp2.size()];
    for (int i = 0; i < temp1.size(); i++) {
      for (int j = 0; j < temp2.size(); j++) {
        if (!t1[i] && !t2[j]) {
          Term term1 = (Term) temp1.get(i);
          Term term2 = (Term) temp2.get(j);
          if (term1.getExp() == term2.getExp()) {
            Integer sum = term1.getCoff() - term2.getCoff();
            R.add(new Term(sum, term1.getExp()));
            t1[i] = true;
            t2[j] = true;
            break;
          }
        }
      }
      if (!t1[i]) {
        R.add(temp1.get(i));
      }
    }
    for (int i = 0; i < temp2.size(); i++) {
      if (!t2[i]) {
        Term te = (Term) temp2.get(i);
        te.setCoff(te.getCoff() * -1);
        R.add(te);
      }
    }
    sort(R);
    int[][] terms = new int[R.size()][2];
    for (int i = 0; i < R.size(); i++) {
      Term te = (Term) R.get(i);
      terms[i][0] = te.getCoff();
      terms[i][1] = te.getExp();
    }
    return terms;
  }

  @Override
  public final int[][] multiply(final char poly1, final char poly2) {
    // TODO Auto-generated method stub
    DLinkedList temp1 = new DLinkedList();
    DLinkedList temp2 = new DLinkedList();
    if (poly1 == 'A') {
      temp1 = A;
    } else if (poly1 == 'B') {
      temp1 = B;
    } else if (poly1 == 'C') {
      temp1 = C;
    } else {
      throw new RuntimeException();
    }
    if (temp1 == null || temp1.size() == 0) {
      throw new RuntimeException();
    }
    if (poly2 == 'A') {
      temp2 = A;
    } else if (poly2 == 'B') {
      temp2 = B;
    } else if (poly2 == 'C') {
      temp2 = C;
    } else {
      throw new RuntimeException();
    }
    if (temp2 == null || temp2.size() == 0) {
      throw new RuntimeException();
    }
    R = new DLinkedList();
    DLinkedList results = new DLinkedList();
    for (int i = 0; i < temp2.size(); i++) {
      DLinkedList result = new DLinkedList();
      for (int j = 0; j < temp1.size(); j++) {
        Term term1 = (Term) temp2.get(i);
        Term term2 = (Term) temp1.get(j);
        Integer res = term1.getCoff() * term2.getCoff();
        Integer newExp = term1.getExp() + term2.getExp();
        result.add(new Term(res, newExp));
      }
      if (i == 0) {
        results = result;
      } else {
        results = add2Poly(result, results);
      }
    }
    R = results;
    sort(R);
    int[][] terms = new int[R.size()][2];
    for (int i = 0; i < R.size(); i++) {
      Term te = (Term) R.get(i);
      terms[i][0] = te.getCoff();
      terms[i][1] = te.getExp();
    }
    return terms;
  }

  /**
   *
   * @param p1
   *          .....
   * @param p2
   *          .....
   * @return result
   */
  public final DLinkedList add2Poly(final DLinkedList p1,
      final DLinkedList p2) {
    DLinkedList result = new DLinkedList();
    boolean[] t1 = new boolean[p1.size()];
    boolean[] t2 = new boolean[p2.size()];
    for (int i = 0; i < p1.size(); i++) {
      for (int j = 0; j < p2.size(); j++) {
        if (!t1[i] && !t2[j]) {
          Term term1 = (Term) p1.get(i);
          Term term2 = (Term) p2.get(j);
          if (term1.getExp() == term2.getExp()) {
            Integer sum = term1.getCoff() + term2.getCoff();
            result.add(new Term(sum, term1.getExp()));
            t1[i] = true;
            t2[j] = true;
            break;
          }
        }
      }
      if (!t1[i]) {
        result.add(p1.get(i));
      }
    }
    for (int i = 0; i < p2.size(); i++) {
      if (!t2[i]) {
        result.add(p2.get(i));
      }
    }
    return result;

  }

  /**
   *
   * @param list
   *          ....
   */
  public void sort(final DLinkedList list) {
    for (int i = 0; i < list.size() - 1; i++) {
      boolean swap = false;
      for (int j = 0; j < list.size() - 1 - i; j++) {
        Term term1 = (Term) list.get(j);
        Term term2 = (Term) list.get(j + 1);
        if (term1.getExp() < term2.getExp()) {
          list.set(j, term2);
          list.set(j + 1, term1);
          swap = true;
        }
      }
      if (!swap) {
        break;
      }
    }
  }

}
