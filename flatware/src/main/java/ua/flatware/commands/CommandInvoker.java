package ua.flatware.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.flatware.data.entity.Flatware;
import ua.flatware.exceptions.FlatwareXmlParserException;
import ua.flatware.exceptions.TransformHelperException;
import ua.flatware.exceptions.ValidatorSAXXSDException;
import ua.flatware.util.FlatwareValidator;
import ua.flatware.util.FlatwareXmlParser;
import ua.flatware.util.ValidatorSAXXSD;
import ua.flatware.util.XmlTransformHelper;

import java.util.HashMap;
import java.util.Map;

import static ua.flatware.commands.BasicCommands.*;
import static ua.flatware.file.path.constants.FilePathConstants.*;

public class CommandInvoker {
    private final static Logger logger = LoggerFactory.getLogger(CommandInvoker.class);

    private Map<String, Command> commands;
    private Flatware flatware;

    public CommandInvoker(Flatware flatware) {
        this.commands = new HashMap<>();
        this.flatware = flatware;
        registerBasicCommands();
    }

    public CommandInvoker(Map<String, Command> commands, Flatware flatware) {
        this.commands = commands;
        this.flatware = flatware;
        registerBasicCommands();
    }

    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        command.execute();
    }

    public void setFlatware(Flatware flatware) {
        this.flatware = flatware;
    }

    private void registerBasicCommands() {
        registerCommand(VALIDATE_XML_WITH_XSD.getName(), () -> {
            try {
                boolean v = ValidatorSAXXSD.isXmlValid(XML.getPath(), XSD.getPath());
                if (!v) {
                    throw new ValidatorSAXXSDException();
                }
            } catch (ValidatorSAXXSDException e) {
                logger.error("Command invoker error", e);
            }
        });

        registerCommand(PARSE_XML_TO_POJO.getName(), () -> {
            try {
                FlatwareXmlParser.parse(XML.getPath());
            } catch (FlatwareXmlParserException e) {
                logger.error("Command invoker error", e);
            }
        });

        registerCommand(VALIDATE_POJO_PARAMETERS.getName(), () ->
                FlatwareValidator.isFlatwareValid(flatware));

        registerCommand(SHOW_FLATWARE.getName(), () -> {
            if (flatware.getFlatware().isEmpty()) {
                System.out.println("Nothing to show");
            } else {
                flatware.getFlatware().forEach(System.out::println);
            }
        });

        registerCommand(TRANSFORM_XML_TO_HTML.getName(), () -> {
            try {
                XmlTransformHelper.transform(XML.getPath(), XSL.getPath(), NEW_XML.getPath());
            } catch (TransformHelperException e) {
                logger.error("Command invoker error", e);
            }
        });

    }

    void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

}
