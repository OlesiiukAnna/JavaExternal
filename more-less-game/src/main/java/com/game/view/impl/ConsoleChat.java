package com.game.view.impl;

import com.game.view.BaseChat;

import java.util.List;

public class ConsoleChat implements BaseChat {

    @Override
    public void printCondition() {
        System.out.println("You should guess an integer number in range from 0 to 100 inclusively");
    }

    @Override
    public void getValueFromUser(int min, int max) {/* Optional<String>*/
        System.out.printf("Please, enter an integer number in range from %d to %d \n", min, max);
    }

    @Override
    public void printPreviousAttempts(List<String> attemptValues) {
        if (!attemptValues.isEmpty()){
            System.out.println("You previously entered: " + attemptValues);
        } else {
            System.out.println("You haven't try yet, I have no data of your attempts");
        }
    }

    @Override
    public void printCongratulations() {
        System.out.println("You won!");
    }

    @Override
    public void printStatistic(int tries, List<String> enteredValues) {
        System.out.println("Tries: " + tries);
        System.out.println("Entered values: " + enteredValues);
    }

    @Override
    public void getWrongValueMassage() {
        System.out.println("It's not what we are looking for...");
    }

}
