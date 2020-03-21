package ua.flatware.controller.impl;

import ua.flatware.controller.Controller;
import ua.flatware.data.XmlFileHandler;
import ua.flatware.data.entity.Flatware;
import ua.flatware.util.FlatwareValidator;
import ua.flatware.view.BaseChat;

public class XmlController implements Controller {
    
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

            if (FlatwareValidator.isFlatwareValid(xmlFileHandler.getFlatware())) {
                chat.printFlatwareIsValid();
                Flatware flatware = xmlFileHandler.getFlatware();

                flatwareSort(flatware);
                flatware.getFlatware().forEach(System.out::println);

                xmlFileHandler.transformXml();
                chat.printTransformationComplete();
            } else {
                chat.printFlatWareNotValid();
            }
        } else {
            chat.printIfXmlNotValid();
        }

    }

    private void flatwareSort(Flatware flatware) {
        flatware.getFlatware().sort((ware, anotherWare) -> {
            if (ware.getVisual().getActivePart().getBlade() != null &&
                    anotherWare.getVisual().getActivePart().getBlade() != null) {
                return ware.getVisual().getActivePart().getBlade().getLength() -
                        anotherWare.getVisual().getActivePart().getBlade().getLength();
            } else if (ware.getVisual().getActivePart().getProng() != null &&
                    anotherWare.getVisual().getActivePart().getProng() != null) {
                return ware.getVisual().getActivePart().getProng().getLength() -
                        anotherWare.getVisual().getActivePart().getProng().getLength();
            } else if (ware.getVisual().getActivePart().getScoop() != null &&
                    anotherWare.getVisual().getActivePart().getScoop() != null) {
                return ware.getVisual().getActivePart().getScoop().getVolume() -
                        anotherWare.getVisual().getActivePart().getScoop().getVolume();
            }
            return ware.getType().compareTo(anotherWare.getType());
        });
    }
}
