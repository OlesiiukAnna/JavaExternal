package ua.flatware.constants;

public enum FilePathConstants {

    XML("flatware/src/main/resources/files/flatware.xml"),
    XSD("flatware/src/main/resources/files/flatware.xsd"),
    XSL("flatware/src/main/resources/files/flatware.xsl"),
    NEW_XML("flatware/src/main/resources/files/newFlatware.xml");

    private String commandName;

    FilePathConstants(String commandName) {
        this.commandName = commandName;
    }

    public String getPath() {
        return commandName;
    }
}
