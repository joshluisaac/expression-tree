package expressiontree.state;

public class InOrderUninitializedState extends UninitializedState {
  /**
   * Process the @a expression using an in-order interpreter and update the state of the @a context
   * to the @a InOrderInitializedState.
   */
  public InOrderUninitializedState() {
    super();
  }

  /**
   * Process the @a expression using a in-order interpreter and update the state of @a treeOps to
   * the @a InOrderInitializedState.
   */
  @Override
  void makeTree(TreeOps treeOps, String inputExpression) {
    treeOps.setExpressionTree(treeOps.interpreter().interpret(inputExpression));
    treeOps.state(new InOrderInitializedState());
  }
}
