package expressiontree;

import expressiontree.inputhandler.InputHandler;
import expressiontree.platform.Platform;

/**
 * @class InputDispatcher
 * @brief This class runs the event loop.
 */
public class InputDispatcher {
  /** Handles input events and commands associated with the expression tree app. */
  private InputHandler inputHandler;

  /** Is the input dispatching done? */
  private boolean inputDispatchingDone = false;

  /** The singleton @a InputDispatcher instance. */
  private static InputDispatcher uniqueInstance = null;

  /** Method to return the one and only singleton instance. */
  public static InputDispatcher instance() {
    if (uniqueInstance == null) uniqueInstance = new InputDispatcher();
    return uniqueInstance;
  }

  public void createHandler(boolean verbose, Object input, Object output, Object activity) {
    inputHandler = InputHandler.createHandler(verbose, input, output, activity);
  }

  public void makeHandlerAndPromptUser(
      boolean verbose, Object input, Object output, Object activity) {
    inputHandler = InputHandler.createHandler(verbose, input, output, activity);
    inputHandler.promptUser();
  }

  public void dispatchOneInput() {
    try {
      inputHandler.handleInput();
    } catch (Exception e) {
      Platform.instance().outputLine(e.getMessage());
    }
  }

  public void dispatchAllInputs() {
    /** Continuously runs the InputHandler. */
    while (!inputDispatchingDone) {
      try {
        inputHandler.handleInput();
      } catch (Exception e) {
        Platform.instance().outputLine(e.getMessage());
      }
    }
  }

  /** End the input dispatching loop. */
  public void endInputDispatching() {
    this.inputDispatchingDone = true;
  }

  /** Make the constructor private for a singleton. */
  private InputDispatcher() {}
}
