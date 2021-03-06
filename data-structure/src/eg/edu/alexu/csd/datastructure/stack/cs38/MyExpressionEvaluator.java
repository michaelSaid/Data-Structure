package eg.edu.alexu.csd.datastructure.stack.cs38;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 *
 * @author DELL
 *
 */
public class MyExpressionEvaluator implements IExpressionEvaluator {
  /**
   *
   */
  private Object num1;
  /**
   *
   */
  private Object num2;
  /**
   *
   */
  private static String closed = ")";
  /**
   *
   */
  private static String opend = "(";

  /**
   *
   * @param operation
   *          ....
   * @return ....
   */
  private Object evaluateOperation(final char operation) {
    if (operation == '+') {
      return (float) num1 + (float) num2;
    } else if (operation == '-') {
      return (float) num1 - (float) num2;
    } else if (operation == '*') {
      return (float) num1 * (float) num2;
    } else if (operation == '/') {
      return ((float) num1 / (float) num2);
    }
    return null;

  }

  /**
   *
   * @param sub
   *          ...
   * @return ....
   */
  private boolean isOperation(final String sub) {
    return sub.equals("+") || sub.equals("-") || sub.equals("*")
        || sub.equals("/");
  }

  /**
   *
   * @param op1
   *          ....
   * @param op2
   *          ....
   * @return .....
   */
  private boolean compareOperation(final String op1, final String op2) {
    if ((op1.equals("*") || op1.equals("/"))
        && (op2.equals("+") || op2.equals("-"))) {
      return true;
    } else if ((op1.equals("*") && op2.equals("/"))
        || (op2.equals("*") && op1.equals("/"))) {
      return true;
    } else if ((op1.equals("-") && op2.equals("+"))
        || (op2.equals("-") && op1.equals("+"))) {
      return true;
    } else if ((op1.equals("*") && op2.equals("*"))
        || (op2.equals("/") && op1.equals("/"))) {
      return true;
    } else if ((op1.equals("+") && op2.equals("+"))
        || (op2.equals("-") && op1.equals("-"))) {
      return true;
    }
    return false;

  }

  @Override
  public final String infixToPostfix(final String expression) {
    // TODO Auto-generated method stub
    if (expression.isEmpty()) {
      throw new RuntimeException();
    }
    StringBuilder postFix = new StringBuilder("");
    MyStack s = new MyStack();
    int numOfNums = 0;
    int numOfOp = 0;
    for (int i = 0; i < expression.length();) {
      char te = expression.substring(i, i + 1).charAt(0);
      if (Character.isLetterOrDigit(te)) {
        String num = "";
        while (Character.isLetterOrDigit(te)) {
          num += expression.substring(i, i + 1);
          i++;
          if (i == expression.length()) {
            break;
          }
          te = expression.substring(i, i + 1).charAt(0);
        }
        postFix.append(num + " ");
        numOfNums++;
      } else {
        if (isOperation(expression.substring(i, i + 1))
            || expression.substring(i, i + 1).equals(opend)) {
          String exp = expression.substring(i, i + 1);
          while (!s.isEmpty() && compareOperation((String) s.peek(), exp)) {
            postFix.append((String) s.peek() + " ");
            s.pop();
          }
          s.push(exp);
          if (isOperation(expression.substring(i, i + 1))) {
            numOfOp++;
          }
        } else if (expression.substring(i, i + 1).equals(closed)) {
          while (!s.isEmpty() && !s.peek().equals(opend)) {
            postFix.append((String) s.peek() + " ");
            s.pop();
          }
          s.pop();
        }
        i++;
      }
    }
    if (numOfNums <= numOfOp) {
      throw new RuntimeException();
    }
    while (!s.isEmpty()) {
      if (s.peek().toString().equals(opend)) {
        throw new RuntimeException();
      }
      postFix.append(s.pop() + " ");
    }
    postFix.deleteCharAt(postFix.length() - 1);
    return postFix.toString();
  }

  @Override
  public final int evaluate(final String expression) {
    // TODO Auto-generated method stub
    if (expression.isEmpty()) {
      throw new RuntimeException();
    }
    MyStack stack = new MyStack();
    for (int i = 0; i < expression.length(); i++) {
      char te = expression.charAt(i);
      if (Character.isLetterOrDigit(te)) {
        String temp = "";
        while (expression.charAt(i) != ' ') {
          temp += expression.substring(i, i + 1);
          i++;
        }
        stack.push(Float.valueOf(temp));
      } else if (expression.charAt(i) != ' ') {
        num2 = stack.pop();
        num1 = stack.pop();
        stack.push(evaluateOperation(expression.charAt(i)));
      }
    }
    return Math.round((float) stack.peek());
  }

}
