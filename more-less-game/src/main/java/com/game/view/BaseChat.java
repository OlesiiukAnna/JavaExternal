package com.game.view;

import java.util.List;
import java.util.Optional;

public interface BaseChat {

    void printCondition();

    Optional<String> getValueFromUser(int min, int max);

    void printPreviousAttempts(List<String> attemptValues);

    void printCongratulations();

    void printStatistic(int tries, List<String> enteredValues);

    void getWrongValueMassage();
}
