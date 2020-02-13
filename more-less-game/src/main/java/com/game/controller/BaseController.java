package com.game.controller;

public interface BaseController {

    void startGame();

    void selectLanguage();

    boolean isGameProcessing();

    String getEnteredValue();

    void saveEnteredValue(String value);
}
