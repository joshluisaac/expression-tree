package expressiontree.interpreter;

import expressiontree.expressiontree.ExpressionTree;
import java.util.ArrayDeque;
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
    Deque<Symbol> parseTree = new ArrayDeque<>();
    for (int i = 0; i < inputExpression.length(); i++) {
      parseTree = parseNextSymbol(inputExpression, i, false, parseTree);
    }
    return parseTree;
  }

  protected void optimizeParseTree(Deque<Symbol> parseTree) {}

  protected ExpressionTree buildExpressionTree(Deque<Symbol> parseTree) {
    return null;
  }

  private Deque<Symbol> parseNextSymbol(
      String inputExpression, int index, boolean handled, Deque<Symbol> parseTree) {

    return null;
  }
}
