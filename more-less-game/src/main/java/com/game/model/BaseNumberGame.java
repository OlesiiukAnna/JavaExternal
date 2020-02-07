package com.game.model;

import java.util.List;

public interface BaseNumberGame {
    int getTargetNumber();

    int getMin();

    void setMin(int min);

    int getMax();

    void setMax(int max);

    void saveValueOfAttempt(String value);

    void setNewRange();

    boolean isWon();

    void countAttempt();

    int getNumberOfAttempts();

    List<String> getEnteredValues();
}
