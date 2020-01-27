package expressiontree;

import expressiontree.platform.Platform;
import expressiontree.platform.PlatformFactory;
import lombok.extern.slf4j.Slf4j;


/**
 * This class is the main entry point for the command-line version of the expression tree processing
 * app.
 */

@Slf4j
public class MainConsole {

  public static void main(String[] args) {
    Platform platform = new PlatformFactory(System.in, System.out, null).makePlatform();
    Platform.instance(platform);

    Options.instance().parseArgs(args);

    if (Options.instance().verbose()) {
      Platform.instance().outputString("Welcome!\n");
    }

    InputDispatcher inputDispatcher = InputDispatcher.instance();
    inputDispatcher.createHandler(Options.instance().verbose(), System.in, System.out, null);
    InputDispatcher.instance().dispatchAllInputs();
  }
}
