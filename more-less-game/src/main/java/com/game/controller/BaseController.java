package com.game.controller;

public interface BaseController {

    void startGame();

    boolean isGameProcessing();

    String getEnteredValue();

    void saveEnteredValue(String value);
}
