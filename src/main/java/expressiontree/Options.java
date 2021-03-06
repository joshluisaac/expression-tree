package expressiontree;

import expressiontree.platform.Platform;

/** This class implements the Singleton pattern to handle command-line option processing. */
public class Options {
  /** Are we running in verbose mode or not? */
  private boolean verbose = false;

  /** The singleton @a Options instance. */
  private static Options uniqueInstance = null;

  /** Method to return the one and only singleton uniqueInstance. */
  public static Options instance() {
    if (uniqueInstance == null) uniqueInstance = new Options();
    return uniqueInstance;
  }

  /** Run the program in verbose mode. */
  public boolean verbose() {
    return this.verbose;
  }

  /** Parse command-line arguments and set the appropriate values. */
  public boolean parseArgs(String[] argv) {
    if (argv.length > 0) {
      if (argv[0].equals("-v")) verbose = true;
      else {
        printUsage();
        return false;
      }
    }
    return true;
  }

  /** Print out usage and default values. */
  public void printUsage() {
    Platform platform = Platform.instance();
    String options = "Options";
    platform.errorLog(options, "\nHelp Invoked on ");
    platform.errorLog(options, "[-h|-v] ");
    platform.errorLog("", "");
    platform.errorLog("", "");

    platform.errorLog(options, "Usage: ");
    platform.errorLog(options, "-h: invoke help ");
    platform.errorLog(options, "-v: enter verbose mode \n");
  }

  /** Make the constructor private for a singleton. */
  private Options() {}
}
