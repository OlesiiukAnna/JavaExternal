package com.game.view.impl;

import com.game.view.BaseChat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;

public class ConsoleChat implements BaseChat {

    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void printCondition() {
        System.out.println("You should guess an integer number in range from 0 to 100 inclusively");
    }

    @Override
    public Optional<String> getValueFromUser(int min, int max) {
        System.out.printf("Please, enter an integer number in range from %d to %d \n", min, max);

        String incomeValue = null;
        try {
            incomeValue = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(incomeValue);
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
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
