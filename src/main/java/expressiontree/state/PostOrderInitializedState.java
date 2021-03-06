package expressiontree.state;

/** A state formated post order and containing an expression tree. */
public class PostOrderInitializedState extends PostOrderUninitializedState {
  /** Ctor */
  public PostOrderInitializedState() {}

  /** Print the current expression tree in the @a context using the designed @a format. */
  void print(TreeOps context, String format) {
    State.printTree(context.getExpressionTree(), format);
  }

  /**
   * Evaluate the yield of the current expression tree in the @a context using the designed @a
   * format.
   */
  void evaluate(TreeOps context, String param) {
    throw new IllegalArgumentException("PostOrderInitializedState.evaluate() not yet implemented");
  }
}
