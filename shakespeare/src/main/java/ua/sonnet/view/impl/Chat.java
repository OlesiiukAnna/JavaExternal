package ua.sonnet.view.impl;

import ua.sonnet.ResourceManager;
import ua.sonnet.view.BaseChat;

public class Chat implements BaseChat {
    private ResourceManager resManager = ResourceManager.INSTANCE;

    @Override
    public void askToSelectLanguage() {
        System.out.println(resManager.getString("language"));
    }

    @Override
    public void getWrongLanguageMessage() {
        System.out.println(resManager.getString("incorrectLanguage"));
    }

    @Override
    public void printGreeting() {
        System.out.println(resManager.getString("greeting"));
    }

    @Override
    public void askToSetSonnetsRange(){
        System.out.println(resManager.getString("getRangeOfSonnets"));
    }

    @Override
    public void askToEnterRangeStart() {
        System.out.println(resManager.getString("askForRangeStart"));
    }

    @Override
    public void askToEnterRangeEnd() {
        System.out.println(resManager.getString("askForRangeEnd"));
    }

    @Override
    public void wrongRange() {
        System.out.println(resManager.getString("wrongRange"));
    }

    @Override
    public void askToEnterWordForSearch() {
        System.out.println(resManager.getString("getWordFromUser"));
    }

    @Override
    public void getProcessingMessage() {
        System.out.println(resManager.getString("processing"));
    }

    @Override
    public void printResultsMessage(int numberOfUrls) {
        System.out.printf(resManager.getString("searchResults"), numberOfUrls);
    }

}
