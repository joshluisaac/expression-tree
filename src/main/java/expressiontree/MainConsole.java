package expressiontree;

import expressiontree.platform.Platform;
import expressiontree.platform.PlatformFactory;

/**
 * This class is the main entry point for the command-line version of the expression tree processing
 * app.
 */
public class MainConsole {

  public static void main(String[] args) {
    Platform.instance(new PlatformFactory(System.in, System.out, null).makePlatform());

    Options.instance().parseArgs(args);

    if (Options.instance().verbose()) {
      Platform.instance().outputString("Welcome!\n");
    }
    InputDispatcher.instance()
        .makeHandler(Options.instance().verbose(), System.in, System.out, null);
    InputDispatcher.instance().dispatchAllInputs();
  }
}
