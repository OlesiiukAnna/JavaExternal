package ua.flatware.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.flatware.controller.Controller;
import ua.flatware.data.XmlFileHandler;

import ua.flatware.view.BaseChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XmlController implements Controller {
    private final static Logger logger = LoggerFactory.getLogger(XmlController.class);
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private BaseChat chat;
    private XmlFileHandler xmlFileHandler;

    public XmlController(BaseChat chat, XmlFileHandler xmlFileHandler) {
        this.chat = chat;
        this.xmlFileHandler = xmlFileHandler;
    }

    @Override
    public void start() {
        chat.printGreeting();
        handleFlatwareXml();
    }

    public void handleFlatwareXml() {
        boolean validation = xmlFileHandler.isXmlValid();

        if (validation) {
            chat.printIfXmlValid();
            xmlFileHandler.parseXmlToPojo();
            chat.printParsingSuccessful();
            xmlFileHandler.transformXml();
            chat.printTransformationComplete();
        } else {
            chat.printIfXmlNotValid();
        }

    }

    public String getEnteredValue() {

        String incomeValue = null;
        try {
            incomeValue = reader.readLine();
        } catch (IOException e) {
            logger.error(e.toString());
        }

        return incomeValue;
    }
}
