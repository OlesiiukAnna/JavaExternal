package ua.flatware.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import ua.flatware.commands.Command;
import ua.flatware.exceptions.ValidatorSAXXSDException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorSAXXSD {

    private final static Logger logger = LoggerFactory.getLogger(ValidatorSAXXSD.class);
    private static ValidatorSAXXSD validator = new ValidatorSAXXSD();

    private static String language = XMLConstants.W3C_XML_SCHEMA_NS_URI;

    private ValidatorSAXXSD() {
    }

    public static ValidatorSAXXSD getValidator() {
        return validator;
    }

    public static boolean isXmlValid(String xmlName, String xsdName) throws ValidatorSAXXSDException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(language);
        File schemaLocation = new File(xsdName);
        try {
            Schema schema = schemaFactory.newSchema(schemaLocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlName);
            validator.validate(source);
            return true;
        } catch (SAXException e) {
            logger.error(String.format("Validation %s is not valid because ", xmlName), e);
            throw new ValidatorSAXXSDException(String.format("Validation %s is not valid because ", xmlName), e);
        } catch (IOException e) {
            logger.error(String.format("%s is not valid because ", xmlName), e);
            throw new ValidatorSAXXSDException(String.format("%s is not valid because ", xmlName), e);
        }
    }

}
