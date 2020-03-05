package ua.sonnet.engine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLParser {
    private static final String MAIN_EXCEPTION_MESSAGE = "Exception occurred in URLParser";
    private static final Logger logger = LoggerFactory.getLogger(URLParser.class);

    public static String getHtml(String url) {

        URLConnection connection = null;
        try {
            URL website = new URL(url);
            connection = website.openConnection();
        } catch (IOException e) {
            logger.error(MAIN_EXCEPTION_MESSAGE, e);
        }

        StringBuilder response = new StringBuilder();
        assert connection != null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;

            while ((inputLine = reader.readLine()) != null)
                response.append(inputLine);

        } catch (IOException e) {
            logger.error(MAIN_EXCEPTION_MESSAGE, e);
        }

        return response.toString();
    }

}
