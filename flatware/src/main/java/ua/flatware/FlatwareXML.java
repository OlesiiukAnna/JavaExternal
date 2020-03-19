package ua.flatware;

import ua.flatware.controller.Controller;
import ua.flatware.controller.impl.XmlController;
import ua.flatware.data.XmlFileHandler;
import ua.flatware.view.BaseChat;
import ua.flatware.view.Chat;

public class FlatwareXML {
    public static void main(String[] args) {

        String xml = "flatware/src/main/java/ua/flatware/files/flatware.xml";
        String xsd = "flatware/src/main/java/ua/flatware/files/flatware.xsd";
        String xsl = "flatware/src/main/java/ua/flatware/files/flatware.xsl";
        String newXML = "flatware/src/main/java/ua/flatware/files/NEWflatware.xml";

        BaseChat chat = new Chat();
        XmlFileHandler xmlFileHandler = new XmlFileHandler(xml, xsd, xsl, newXML);

        Controller controller = new XmlController(chat, xmlFileHandler);
        controller.start();

    }
    
}
