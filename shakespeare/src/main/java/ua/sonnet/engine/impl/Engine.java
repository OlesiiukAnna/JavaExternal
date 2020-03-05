package ua.sonnet.engine.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.sonnet.engine.SearchEngine;
import ua.sonnet.engine.entity.Page;
import ua.sonnet.engine.entity.Word;
import ua.sonnet.engine.util.ConverterIntToRoman;
import ua.sonnet.engine.util.URLParser;
import ua.sonnet.exceptions.EngineException;

import java.util.*;

public class Engine implements SearchEngine {
    private final static Logger logger = LoggerFactory.getLogger(Engine.class);

    private final static String URL = "http://shakespeare.mit.edu/Poetry/sonnets.html";
    private final static String BASE_URL = "http://shakespeare.mit.edu/Poetry/sonnet.#.html";
    private final static String TAG_BR = "<BR>";
    private final static String TAG_BLOCK_QUOTE_START = "<BLOCKQUOTE>";
    private final static String TAG_BLOCK_QUOTE_END = "</BLOCKQUOTE>";
    private final static String SPLITTER = "[^A-Za-z]";

    private int startRange;
    private int endRange;

    private Word resultWord;
    private List<Page> pages;

    private Engine() {
        pages = new ArrayList<>();
    }

    @Override
    public void setStartRange(int startRange) {
        this.startRange = startRange;
    }

    @Override
    public void setEndRange(int endRange) {
        this.endRange = endRange;
    }

    public static Engine getInstance() {
        return new Engine();
    }

    @Override
    public String getSiteUrl() {
        return URL;
    }

    @Override
    public Word findMatches(String word) throws EngineException {
        fillPageStorage();
        resultWord = new Word(word);
        fillSearchResults(word);
        return resultWord;
    }

    private void fillSearchResults(String word) {
        for (Page page : pages) {
            if (page.getWordsFrequency().containsKey(word)) {
                resultWord.addFrequencyInUrl(page.getUrl(), page.getWordsFrequency().get(word));
            }
        }
    }

    private void fillPageStorage() throws EngineException {
        for (int i = startRange; i < endRange + 1; i++) {
            Page page = getPage(i);
            pages.add(page);
        }
    }

    private Page getPage(int i) throws EngineException {
        String sonnetNumber = ConverterIntToRoman.intToRoman(i);
        String currentURL = buildUrl(sonnetNumber);
        String sonnet = getSonnetFromHtml(URLParser.getHtml(currentURL));
        Map<String, Integer> wordsFrequencyInSonnet = getWordsFrequencyInSonnet(sonnet);
        return new Page(currentURL, sonnet, wordsFrequencyInSonnet);
    }


    private String buildUrl(String sonnetNumber) {
        return BASE_URL.replace("#", sonnetNumber);
    }


    private Map<String, Integer> getWordsFrequencyInSonnet(String sonnetTextOnSite) {
        Map<String, Integer> map = new HashMap<>();
        String[] words = getWords(sonnetTextOnSite);
        for (String word : words) {
            Integer freq = map.get(word);
            map.put(word, (freq == null) ? 1 : freq + 1);
        }
        return map;
    }

    private String[] getWords(String sonnet) {
        return sonnet.toLowerCase().split(SPLITTER);
    }

    private String getSonnetFromHtml(String htmlPage) throws EngineException {
        if (pageContainsTagsFromArray(htmlPage)) {
            int sonnetTextStart = htmlPage.indexOf(TAG_BLOCK_QUOTE_START) + TAG_BLOCK_QUOTE_START.length();
            int sonnetTextEnd = htmlPage.indexOf(TAG_BLOCK_QUOTE_END);
            return htmlPage.substring(sonnetTextStart, sonnetTextEnd).replaceAll(TAG_BR, " ");
        } else {
            logger.error("Url doesn't contain appropriate tags");
            throw new EngineException();
        }
    }

    private boolean pageContainsTagsFromArray(String inputStr) {
        String[] tags = {TAG_BR, TAG_BLOCK_QUOTE_START, TAG_BLOCK_QUOTE_END};
        return Arrays.stream(tags).parallel().allMatch(inputStr::contains);
    }

}
