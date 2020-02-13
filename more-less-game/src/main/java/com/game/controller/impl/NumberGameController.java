package com.game.controller.impl;

import com.game.ResourceManager;
import com.game.controller.BaseController;
import com.game.model.impl.NumberGame;
import com.game.view.BaseChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class NumberGameController implements BaseController {

    private BaseChat chat;
    private NumberGame numberGame;

    private boolean isGameProcessing = true;

    private ResourceManager resManager = ResourceManager.INSTANCE;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public NumberGameController(BaseChat chat, NumberGame numberGame) {
        this.chat = chat;
        this.numberGame = numberGame;
    }

    @Override
    public void startGame() {
        selectLanguage();
        chat.printCondition();

        do {
            chat.printPreviousAttempts(numberGame.getEnteredValues());
            chat.askUserForValue(numberGame.getMin(), numberGame.getMax());

            saveEnteredValue(getEnteredValue());

            if (isGameProcessing()) {
                chat.getWrongValueMassage();
            }
            countAttempt();

        } while (isGameProcessing);

        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        chat.printCongratulations();
        chat.printStatistic(numberGame.getNumberOfAttempts(), numberGame.getEnteredValues());
    }

    private void countAttempt() {
        numberGame.countAttempt();
    }

    @Override
    public void selectLanguage() {
        chat.askSelectLanguage();
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
    public boolean isGameProcessing() {
        isGameProcessing = !numberGame.isWon();
        return isGameProcessing;
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

    @Override
    public void saveEnteredValue(String value) {
        numberGame.saveValueOfAttempt(value);
    }

}
