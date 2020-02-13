package com.game.view.impl;

import com.game.view.BaseChat;
import com.game.ResourceManager;

import java.util.List;

public class ConsoleChat implements BaseChat {
    private ResourceManager resManager = ResourceManager.INSTANCE;

    @Override
    public void askSelectLanguage() {
        System.out.println(resManager.getString("language"));
    }

    @Override
    public void getWrongLanguageMessage() {
        System.out.println(resManager.getString("incorrectLanguage"));
    }

    @Override
    public void printCondition() {
        System.out.println(resManager.getString("condition"));
    }

    @Override
    public void askUserForValue(int min, int max) {
        System.out.printf(resManager.getString("getValueFromUser"), min, max);
    }

    @Override
    public void printPreviousAttempts(List<String> attemptValues) {
        if (!attemptValues.isEmpty()) {
            System.out.println(resManager.getString("previousValues") + attemptValues);
        } else {
            System.out.println(resManager.getString("noPreviousValues"));
        }
    }

    @Override
    public void printCongratulations() {
        System.out.println(resManager.getString("congratulations"));
    }

    @Override
    public void printStatistic(int tries, List<String> enteredValues) {
        System.out.println(resManager.getString("numberOfTries") + tries);
        System.out.println(resManager.getString("enteredValues") + enteredValues);
    }

    @Override
    public void getWrongValueMassage() {
        System.out.println(resManager.getString("incorrectValue"));
    }

}
