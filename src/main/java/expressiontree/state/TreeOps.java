package expressiontree.state;

import expressiontree.expressiontree.ExpressionTree;
import expressiontree.interpreter.Interpreter;

/**
 * Plays the role of the "Context" in the State pattern that ensures user operations on an
 * expression tree are invoked according to the correct protocol. Most of its methods delegate to
 * the corresponding methods in subclasses of the @a State base class, which then perform the
 * requested operations.
 */
public class TreeOps {

  private State state;
  private ExpressionTree tree;
  private boolean formatted;
  private Interpreter interpreter;

  public Interpreter interpreter() {
    return interpreter;
  }

  public TreeOps() {
    state = new UninitializedState();
    formatted = false;
    interpreter = new Interpreter();
    tree = new ExpressionTree(null);
  }

  public void format(String newFormat) {
    state.format(this, newFormat);
    this.formatted = true;
  }

  public void makeTree(String expression) {
    state.makeTree(this, expression);
  }

  public void print(String format) {
    state.print(this, format);
  }

  public void evaluate(String format) {
    state.evaluate(this, format);
  }

  public void set(String keyValuePair) throws Exception {
    String inputString = keyValuePair.replace(" ", "");
    int pos;
    if ((pos = inputString.indexOf('=')) != -1) {
      if (pos != 0 && pos < inputString.length() - 1) {
        String key = inputString.substring(0, pos);
        String value = inputString.substring(pos + 1);
        interpreter.symbolTable().set(key, Integer.parseInt(value));
      } else throw new Exception("Must be in the form key=value");
    } else throw new Exception("Must have = sign present");
  }

  public State getState() {
    return state;
  }

  public void setNextState(State newState) {
    this.state = newState;
    System.out.println("State changed...");
  }

  public ExpressionTree getExpressionTree() {
    return tree;
  }

  public void setExpressionTree(ExpressionTree newTree) {
    tree = newTree;
  }

  public final boolean formatted() {
    return formatted;
  }
}
