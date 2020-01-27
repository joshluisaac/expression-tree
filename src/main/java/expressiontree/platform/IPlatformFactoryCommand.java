package expressiontree.platform;

/** This interface uses the Command pattern to create @a Platform implementations at runtime. */
public interface IPlatformFactoryCommand {
  Platform execute();
}
