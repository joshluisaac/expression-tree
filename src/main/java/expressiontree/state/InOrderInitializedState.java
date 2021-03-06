package expressiontree.state;

/** A state formatted in-order and containing an expression tree. */
public class InOrderInitializedState extends InOrderUninitializedState {
  public InOrderInitializedState() {}

  /** Print the current expression tree in the @a context using the designed @a format. */
  @Override
  void print(TreeOps context, String format) {
    State.printTree(context.getExpressionTree(), format);
  }

  /**
   * Evaluate the yield of the current expression tree in the @a context using the designed @a
   * format.
   */
  @Override
  void evaluate(TreeOps context, String format) {
    State.evaluateTree(context.getExpressionTree(), format);
  }
}
