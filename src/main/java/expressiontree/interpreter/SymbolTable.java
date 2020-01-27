package expressiontree.interpreter;

import expressiontree.platform.Platform;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * This class stores variables and their values for use by the Interpreter. It plays the role of the
 * "Context" in the Interpreter pattern.
 */
public class SymbolTable {
  private Map<String, Integer> map = new HashMap<>();

  public SymbolTable() {}

  public int get(String variable) {
    Integer value = map.get(variable);
    if (value != null) {
      return value;
    } else {
      map.put(variable, 0);
      return map.get(variable);
    }
  }

  public void set(String variable, int value) {
    map.put(variable, value);
  }

  public void print() {
    for (Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
      Map.Entry<String, Integer> x = it.next();
      Platform.instance().outputLine((x.getKey() + " = " + x.getValue()));
    }
  }

  /** Clear all variables and their values. */
  public void reset() {
    map.clear();
  }
}
