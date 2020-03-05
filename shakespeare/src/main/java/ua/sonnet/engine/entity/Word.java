package ua.sonnet.engine.entity;

import java.util.*;

public class Word {

    private String word;
    private Map<String, Integer> frequencyInUrl;

    public Word(String word) {
        this.word = word;
        this.frequencyInUrl = new HashMap<>();
    }

    public Map<String, Integer> getFrequencyInUrl() {
        return frequencyInUrl;
    }

    public void addFrequencyInUrl(String url, Integer frequency) {
        frequencyInUrl.put(url, frequency);
    }

    @Override
    public String toString() {
        return "Word{" +
                "word='" + word + '\'' +
                ", frequencyInUrl=" + frequencyInUrl +
                '}';
    }

}
