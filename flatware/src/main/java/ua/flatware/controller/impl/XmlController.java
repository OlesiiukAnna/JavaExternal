package ua.flatware.controller.impl;

import ua.flatware.commands.CommandInvoker;
import ua.flatware.controller.Controller;
import ua.flatware.data.FlatwareHandler;
import ua.flatware.data.entity.Flatware;
import ua.flatware.util.FlatwareValidator;
import ua.flatware.view.BaseChat;

import static ua.flatware.commands.BasicCommands.SHOW_FLATWARE;

public class XmlController implements Controller {
    
    private BaseChat chat;
    private FlatwareHandler flatwareHandler;
    private CommandInvoker commandInvoker;

    public XmlController(BaseChat chat, FlatwareHandler flatwareHandler) {
        this.chat = chat;
        this.flatwareHandler = flatwareHandler;
        commandInvoker = new CommandInvoker(flatwareHandler.getFlatware());
    }

    @Override
    public void start() {
        chat.printGreeting();
        handleFlatwareXml();
    }

    public void handleFlatwareXml() {
        boolean validation = flatwareHandler.isXmlValid();

        if (validation) {
            chat.printIfXmlValid();
            flatwareHandler.parseXmlToPojo();
            chat.printParsingSuccessful();

            Flatware flatware = flatwareHandler.getFlatware();
            commandInvoker.setFlatware(flatware);

            if (FlatwareValidator.isFlatwareValid(flatware)) {
                chat.printFlatwareIsValid();

                flatwareHandler.flatwareSort(flatware);
                commandInvoker.executeCommand(SHOW_FLATWARE.getName());

                flatwareHandler.transformXml();
                chat.printTransformationComplete();
            } else {
                chat.printFlatWareNotValid();
            }
        } else {
            chat.printIfXmlNotValid();
        }

    }

}
