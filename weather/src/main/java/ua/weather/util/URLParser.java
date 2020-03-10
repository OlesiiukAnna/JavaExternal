package ua.weather.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.weather.exceptions.URLParserException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLParser {
    private static final String MAIN_EXCEPTION_MESSAGE = "Exception occurred in URLParser";
    private static final Logger logger = LoggerFactory.getLogger(URLParser.class);

    public static String getContent(String url) throws URLParserException {
        String result;
        HttpURLConnection connection;
        try {
            URL website = new URL(url);
            connection = (HttpURLConnection) website.openConnection();
            connection.setReadTimeout(20000);
            connection.setConnectTimeout(20000);
            connection.setRequestMethod("GET");

            int status = connection.getResponseCode();

            if (status == HttpURLConnection.HTTP_OK) {
                result = getStringFromStream(connection.getInputStream());
            } else {
                throw new IOException();
            }
        } catch (IOException e) {
            logger.warn(MAIN_EXCEPTION_MESSAGE, e);
            throw new URLParserException(MAIN_EXCEPTION_MESSAGE);
        }

        return result;
    }

    private static String getStringFromStream(InputStream inputStream) {
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String inputLine;

            while ((inputLine = reader.readLine()) != null)
                response.append(inputLine);

        } catch (IOException e) {
            logger.warn(MAIN_EXCEPTION_MESSAGE, e);
        }
        return response.toString();
    }

}
