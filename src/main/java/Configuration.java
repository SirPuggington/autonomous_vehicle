public enum Configuration {
    INSTANCE;

    public final String fileSeparator = System.getProperty("file.separator");
    public final String userDirectory = System.getProperty("user.dir");

    public final String pathToJavaArchiveElectricEngine = userDirectory + fileSeparator + "electric_engine" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;
    public final String pathToJavaArchiveDoor = userDirectory + fileSeparator + "door" + fileSeparator + "implementation" + fileSeparator + "jar" + fileSeparator;

}
