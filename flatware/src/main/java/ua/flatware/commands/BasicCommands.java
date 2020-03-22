package ua.flatware.commands;

public enum BasicCommands {

    VALIDATE_XML_WITH_XSD("validate_xml_with_xsd"),
    PARSE_XML_TO_POJO("parse_xml_to_pojo"),
    VALIDATE_POJO_PARAMETERS("validate_pojo_parameters"),
    SHOW_FLATWARE("show_flatware"),
    TRANSFORM_XML_TO_HTML("transform_xml_to_html");

    private String commandName;

    BasicCommands(String commandName) {
        this.commandName = commandName;
    }

    public String getName() {
        return commandName;
    }
}
