package ua.flatware.util;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.flatware.data.entity.Flatware;
import ua.flatware.exceptions.FlatwareXmlParserException;

import java.io.File;
import java.io.IOException;

public class FlatwareXmlParser {

    private final static Logger logger = LoggerFactory.getLogger(FlatwareXmlParser.class);
    private static FlatwareXmlParser flatwareXmlParser = new FlatwareXmlParser();

    private FlatwareXmlParser() {

    }

    public static FlatwareXmlParser getFlatwareXmlParser() {
        return flatwareXmlParser;
    }

    public static Flatware parse(String xmlFilePath) throws FlatwareXmlParserException {
        Flatware flatware = null;
        try {
            XmlMapper xmlMapper = new XmlMapper();
            flatware = xmlMapper.readValue(new File(xmlFilePath), Flatware.class);
        } catch (IOException e) {
            logger.error("XML parse exception", e);
            throw new FlatwareXmlParserException(e);
        }
        return flatware;
    }
}
