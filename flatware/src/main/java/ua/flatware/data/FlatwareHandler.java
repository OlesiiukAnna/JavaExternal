package ua.flatware.data;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.flatware.data.entity.Flatware;
import ua.flatware.exceptions.FlatwareXmlParserException;
import ua.flatware.exceptions.TransformHelperException;
import ua.flatware.exceptions.ValidatorSAXXSDException;
import ua.flatware.util.FlatwareXmlParser;
import ua.flatware.util.ValidatorSAXXSD;
import ua.flatware.util.XmlTransformHelper;

import static ua.flatware.file.path.constants.FilePathConstants.*;

public class FlatwareHandler {
    private final static Logger logger = LoggerFactory.getLogger(FlatwareHandler.class);

    private Flatware flatware;

    public boolean isXmlValid() {
        boolean result = false;
        try {
            result = ValidatorSAXXSD.isXmlValid(XML.getPath(), XSD.getPath());
        } catch (ValidatorSAXXSDException e) {
            logger.error(e.toString());
        }
        return result;
    }

    public void parseXmlToPojo () {
        try {
            flatware = FlatwareXmlParser.parse(XML.getPath());
        } catch (FlatwareXmlParserException e) {
            logger.error(e.toString());
        }
    }

    public void flatwareSort(Flatware flatware) {
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

    public void transformXml() {
        try {
            XmlTransformHelper.transform(XML.getPath(), XSL.getPath(), NEW_XML.getPath());
        } catch (TransformHelperException e) {
            logger.error(e.toString());
        }
    }

    public Flatware getFlatware() {
        return flatware;
    }

    @Override
    public String toString() {
        return "XmlFileHandler{" +
                "xmlFilePath='" + XML + '\'' +
                ", xsdFilePath='" + XSD + '\'' +
                ", xslFilePath='" + XSL + '\'' +
                ", newXmlFilePath='" + NEW_XML + '\'' +
                '}';
    }
}
