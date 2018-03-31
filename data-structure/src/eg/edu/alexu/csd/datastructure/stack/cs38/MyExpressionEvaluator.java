package eg.edu.alexu.csd.datastructure.stack.cs38;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

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
   * @param operation
   *          ....
   * @return ....
   */
  private Object evaluateOperation(final char operation) {
    if (operation == '+') {
      return (int) num1 + (int) num2;
    } else if (operation == '-') {
      return (int) num1 - (int) num2;
    } else if (operation == '*') {
      return (int) num1 * (int) num2;
    } else if (operation == '/') {
      return ((int) num1 / (int) num2);
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
        || sub.equals("/") || sub.equals(")") || sub.equals("(");
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
    }
    return false;

  }

  @Override
  public final String infixToPostfix(final String expression) {
    // TODO Auto-generated method stub
    if (expression.isEmpty()) {
      throw new RuntimeException();
    }
    MyStack stack = new MyStack();
    String postFix = "";
    for (int i = 0; i < expression.length(); i++) {
      if (!isOperation(expression.substring(i, i + 1))
          && expression.charAt(i) != ' ') {
        String temp = "";
        while (expression.charAt(i) != ' ' && expression.charAt(i) != ')') {
          temp += expression.substring(i, i + 1);
          if (i == expression.length() - 1) {
            break;
          } else if (expression.charAt(i + 1) == ')') {
            break;
          }
          i++;
        }
        postFix += temp + " ";
      } else if (expression.charAt(i) != ' ') {
        if (expression.charAt(i) != ')') {
          if (expression.charAt(i) == '(') {
            stack.push(expression.substring(i, i + 1));
          } else {
            if (stack.isEmpty()) {
              stack.push(expression.substring(i, i + 1));
              i++;
            } else if (compareOperation((String) stack.peek(),
                expression.substring(i, i + 1))) {
              MyStack temp = new MyStack();
              while (!stack.isEmpty() && compareOperation((String) stack.peek(),
                  expression.substring(i, i + 1))) {
                temp.push(stack.pop());
              }
              while (!temp.isEmpty()) {
                postFix += (String) temp.pop() + " ";
              }
              stack.push(expression.substring(i, i + 1));
              i++;
            } else {
              stack.push(expression.substring(i, i + 1));
              i++;
            }
          }
        } else {
          while (!stack.isEmpty()) {
            String temp1 = (String) stack.peek();
            if (!temp1.equals("(")) {
              postFix += temp1 + " ";
            }
            temp1 = (String) stack.pop();
          }
        }
      }
    }
    while (!stack.isEmpty()) {
      postFix += (String) stack.pop() + " ";
    }
    postFix = postFix.substring(0, postFix.length() - 1);
    return postFix;
  }

  @Override
  public final int evaluate(final String expression) {
    // TODO Auto-generated method stub
    if (expression.isEmpty()) {
      throw new RuntimeException();
    }
    MyStack stack = new MyStack();
    for (int i = 0; i < expression.length(); i++) {
      if (!isOperation(expression.substring(i, i + 1))
          && expression.charAt(i) != ' ') {
        String temp = "";
        while (expression.charAt(i) != ' ') {
          temp += expression.substring(i, i + 1);
          i++;
        }
        stack.push(Integer.valueOf(temp));
      } else if (expression.charAt(i) != ' ') {
        num2 = stack.pop();
        num1 = stack.pop();
        stack.push(evaluateOperation(expression.charAt(i)));
      }
    }
    return (int) stack.peek();
  }

}
