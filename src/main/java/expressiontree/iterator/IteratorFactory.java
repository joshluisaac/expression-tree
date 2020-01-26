package expressiontree.iterator;

import expressiontree.expressiontree.ExpressionTree;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @class IteratorFactory
 * @brief Implementation of the Factory Method pattern that dynamically allocates the appropriate @a
 *     Iterator strategy requested by a caller. This variant of the pattern doesn't use inheritance,
 *     so it plays the role of the ConcreteCreator in the Factory Method pattern.
 */
public class IteratorFactory {

  public static interface IIteratorFactoryCommand {
    Iterator<ExpressionTree> execute(ExpressionTree tree);
  }

  private Map<String, IIteratorFactoryCommand> traversalMap = new HashMap<>();

  public IteratorFactory() {
    traversalMap.put("in-order", InOrderIterator::new);
    traversalMap.put("pre-order", PreOrderIterator::new);
    traversalMap.put("post-order", PostOrderIterator::new);
    traversalMap.put("level-order", LevelOrderIterator::new);
  }

  /**
   * Create a new @a Iterator implementation based on the caller's designated @a
   * traversalOrderRequest.
   */
  public Iterator<ExpressionTree> makeIterator(ExpressionTree tree, String traversalOrderRequest) {
    if (traversalOrderRequest.equals("")) traversalOrderRequest = "in-order";
    IIteratorFactoryCommand command = traversalMap.get(traversalOrderRequest);
    if (command != null) return command.execute(tree);
    else
      throw new IllegalArgumentException(
          traversalOrderRequest + " is not a supported traversal order");
  }
}
