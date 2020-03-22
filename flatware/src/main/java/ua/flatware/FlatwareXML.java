package ua.flatware;

import ua.flatware.controller.Controller;
import ua.flatware.controller.impl.XmlController;
import ua.flatware.data.FlatwareHandler;
import ua.flatware.view.BaseChat;
import ua.flatware.view.Chat;

public class FlatwareXML {
    public static void main(String[] args) {

        BaseChat chat = new Chat();
        FlatwareHandler flatwareHandler = new FlatwareHandler();

        Controller controller = new XmlController(chat, flatwareHandler);
        controller.start();

    }
    
}
