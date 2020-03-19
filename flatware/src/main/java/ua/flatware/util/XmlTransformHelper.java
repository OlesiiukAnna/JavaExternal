package ua.flatware.util;

import ua.flatware.exceptions.TransformHelperException;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XmlTransformHelper {

    private XmlTransformHelper transformHelper;

    private XmlTransformHelper() {

    }

    public XmlTransformHelper getTransformHelper() {
        if (transformHelper == null) {
            transformHelper = new XmlTransformHelper();
        }
        return transformHelper;
    }

    public static void transform(String xmlFilePath, String xslFilePath, String newXmlFilePath) throws TransformHelperException {
        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(xslFilePath));
            transformer.transform(new StreamSource(xmlFilePath),
                    new StreamResult(newXmlFilePath));
        } catch (TransformerException e) {
            System.err.println("Impossible transform file ");
            throw new TransformHelperException("Impossible transform file", e);
        }
    }
}
