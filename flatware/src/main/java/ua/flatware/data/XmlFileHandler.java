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

public class XmlFileHandler {
    private final static Logger logger = LoggerFactory.getLogger(XmlFileHandler.class);

    private Flatware flatware;

    private String xmlFilePath;

    private String xsdFilePath;
    private String xslFilePath;
    private String newXmlFilePath;

    public XmlFileHandler(String xmlFilePath, String xsdFilePath, String xslFilePath, String newXmlFilePath) {
        this.xmlFilePath = xmlFilePath;
        this.xsdFilePath = xsdFilePath;
        this.xslFilePath = xslFilePath;
        this.newXmlFilePath = newXmlFilePath;
    }

    public boolean isXmlValid() {
        boolean result = false;
        try {
            result = ValidatorSAXXSD.isXmlValid(xmlFilePath, xsdFilePath);
        } catch (ValidatorSAXXSDException e) {
            logger.error(e.toString());
        }
        return result;
    }

    public void parseXmlToPojo () {
        try {
            flatware = FlatwareXmlParser.parse(xmlFilePath);
        } catch (FlatwareXmlParserException e) {
            logger.error(e.toString());
        }
    }

    public void transformXml() {
        try {
            XmlTransformHelper.transform(xmlFilePath, xslFilePath, newXmlFilePath);
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
                "xmlFilePath='" + xmlFilePath + '\'' +
                ", xsdFilePath='" + xsdFilePath + '\'' +
                ", xslFilePath='" + xslFilePath + '\'' +
                ", newXmlFilePath='" + newXmlFilePath + '\'' +
                '}';
    }
}
