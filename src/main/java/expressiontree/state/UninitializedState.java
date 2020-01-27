package expressiontree.state;

/** A state without an initialized context or format. */
public class UninitializedState extends State {

  /**
   * Formats the traversal order of the state. Default to in-order if user doesn't explicitly
   * request a format order and transition to the designated UninitializedState.
   *
   * @param context
   * @param newFormat
   */
  @Override
  public void format(TreeOps context, String newFormat) {
    if (newFormat.equals("")) newFormat = "in-order";
    else if (!newFormat.equals("in-order"))
      throw new IllegalArgumentException(newFormat + " evaluation is not supported yet");
    context.setNextState(uninitializedStateFactory.makeUninitializedState(newFormat));
  }

  /** A state factory responsible for building uninitilized states. */
  private static UninitializedStateFactory uninitializedStateFactory =
      new UninitializedStateFactory();
}
