package com.game.view;

import java.util.List;

public interface BaseChat {

    void askSelectLanguage();

    void getWrongLanguageMessage();

    void printCondition();

    void askUserForValue(int min, int max);

    void printPreviousAttempts(List<String> attemptValues);

    void printCongratulations();

    void printStatistic(int tries, List<String> enteredValues);

    void getWrongValueMassage();
}
