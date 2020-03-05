package ua.sonnet.controller.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.sonnet.ResourceManager;
import ua.sonnet.controller.Controller;
import ua.sonnet.engine.SearchEngine;
import ua.sonnet.engine.entity.Word;
import ua.sonnet.engine.impl.Engine;
import ua.sonnet.controller.util.SortSearchResultMap;
import ua.sonnet.exceptions.EngineException;
import ua.sonnet.view.BaseChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;

public class SearchController implements Controller {
    private final static Logger logger = LoggerFactory.getLogger(Engine.class);

    private BaseChat chat;
    private SearchEngine searchEngine;

    private ResourceManager resManager = ResourceManager.INSTANCE;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public SearchController(BaseChat chat, SearchEngine searchEngine) {
        this.chat = chat;
        this.searchEngine = searchEngine;
    }

    @Override
    public void search() {
        selectLanguage();
        chat.printGreeting();
        System.out.println(searchEngine.getSiteUrl());

        chat.askToSetSonnetsRange();
        setRange();

        chat.askToEnterWordForSearch();
        String word = getEnteredValue();
        chat.getProcessingMessage();

        Word result = null;
        try {
            result = searchEngine.findMatches(word);
        } catch (EngineException e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            e.printStackTrace();
        }

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("reader.close() in search()", e);
        }

        chat.printResultsMessage(result.getFrequencyInUrl().size());
        LinkedHashMap<String,Integer> sortedUrls = SortSearchResultMap.sortMapByValue(result.getFrequencyInUrl());

        sortedUrls.forEach((k, v) -> System.out.println(k + " = " + v));
    }

    private void setRange() {
        int start = 0;
        int end = -1;
        do {
            try {
                chat.askToEnterRangeStart();
                start = Integer.parseInt(getEnteredValue());
                chat.askToEnterRangeEnd();
                end = Integer.parseInt(getEnteredValue());
                checkRange(start, end);
            } catch (NumberFormatException e) {
                chat.wrongRange();
                logger.info("Number format", e);
            }
        } while (start > end);

        searchEngine.setStartRange(start);
        searchEngine.setEndRange(end);
    }

    private void checkRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException(resManager.getString("wrongRange"));
        }
    }

    @Override
    public void selectLanguage() {
        chat.askToSelectLanguage();
        Locale locale = null;
        boolean isSelected;
        do {
            switch (getEnteredValue()) {
                case "en":
                    locale = new Locale("en");
                    isSelected = true;
                    break;
                case "ru":
                    locale = new Locale("ru");
                    isSelected = true;
                    break;
                case "ua":
                    locale = new Locale("ua");
                    isSelected = true;
                    break;
                default:
                    chat.getWrongLanguageMessage();
                    isSelected = false;
            }
        } while (!isSelected);
        resManager.changeResource(locale);
    }

    @Override
    public String getEnteredValue() {

        String incomeValue = null;
        try {
            incomeValue = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return incomeValue;
    }

}
