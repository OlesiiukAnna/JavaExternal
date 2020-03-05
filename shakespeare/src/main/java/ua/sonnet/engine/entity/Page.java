package ua.sonnet.engine.entity;

import java.util.Map;

public class Page {

    private String url;
    private String sonnet;
    private Map<String, Integer> wordsFrequency;

    public Page(String url, String sonnet, Map<String, Integer> wordsFrequency) {
        this.url = url;
        this.sonnet = sonnet;
        this.wordsFrequency = wordsFrequency;
    }

    public String getUrl() {
        return url;
    }

    public String getSonnet() {
        return sonnet;
    }

    public void setSonnet(String sonnet) {
        this.sonnet = sonnet;
    }

    public Map<String, Integer> getWordsFrequency() {
        return wordsFrequency;
    }

    @Override
    public String toString() {
        return "Page{" +
                "url='" + url + '\'' +
                ", sonnet='" + sonnet + '\'' +
                ", wordsFrequency=" + wordsFrequency +
                '}';
    }
}
