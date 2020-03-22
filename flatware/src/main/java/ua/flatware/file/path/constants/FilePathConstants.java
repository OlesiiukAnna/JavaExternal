package ua.flatware.file.path.constants;

public enum FilePathConstants {

    XML("flatware/src/main/java/ua/flatware/files/flatware.xml"),
    XSD("flatware/src/main/java/ua/flatware/files/flatware.xsd"),
    XSL("flatware/src/main/java/ua/flatware/files/flatware.xsl"),
    NEW_XML("flatware/src/main/java/ua/flatware/files/newFlatware.xml");

    private String commandName;

    FilePathConstants(String commandName) {
        this.commandName = commandName;
    }

    public String getPath() {
        return commandName;
    }
}
