package expressiontree.interpreter;

import expressiontree.expressiontree.ExpressionTree;
import java.util.Deque;

public class InterpreterV2 {

  // Returns an expression tree from a raw text input expression
  public ExpressionTree interpret(String inputExpression) {

    // build a parseTree represented as a stack of symbols
    Deque<Symbol> parseTree = buildParseTree(inputExpression);

    // optimize the parse tree
    optimizeParseTree(parseTree);

    // build and return an expression tree

    return buildExpressionTree(parseTree);
  }

  private Deque<Symbol> buildParseTree(String inputExpression) {
    return null;
  }

  protected void optimizeParseTree(Deque<Symbol> parseTree) {}

  protected ExpressionTree buildExpressionTree(Deque<Symbol> parseTree) {
    return null;
  }
}
