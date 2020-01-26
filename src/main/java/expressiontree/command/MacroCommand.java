package expressiontree.command;

import expressiontree.TreeOps;
import java.util.ArrayList;
import java.util.List;

/**
 * @class MacroCommand
 * @brief Execute a sequence of commands. This plays the role of the "ConcreteCommand" in the
 *     Command pattern.
 */
public class MacroCommand extends UserCommand {
  /** Vector of commands that are executed as a macro. */
  private List<UserCommand> macroCommands = new ArrayList<>();

  /** Expression input by the user. */
  private String expr;

  /** Constructor that provides the appropriate @a TreeOps and sequence of commands. */
  public MacroCommand(TreeOps context, List<UserCommand> macroCommands) {
    super.treeOps = context;
    this.macroCommands = macroCommands;
  }

  /** Quit the event loop. */
  public void execute() throws Exception {
    for (UserCommand c : macroCommands) c.execute();
  }

  /** Print the valid commands available to users. */
  public void printValidCommands(boolean verboseField) {
    /** No menu to print in succinct mode. */
  }
}
