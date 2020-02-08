package com.game.model.impl;

import com.game.model.BaseNumberGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class NumberGame implements BaseNumberGame {

    private int targetNumber;
    private int min = 0;
    private int max = 100;

    private int currentNumber = -1;
    private String lastEnteredValue = null;
    private List<String> values = new ArrayList<>();

    private int tries = 0;

    public NumberGame() {
        this.targetNumber = getRandomNumber(min, max);
    }

    private int getRandomNumber(int min, int max) {
        Random result = new Random();
        return result.nextInt((max - min) + 1) + min;
    }

    private void checkRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
    }

    public int getTargetNumber() {
        return targetNumber;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        checkRange(min, this.max);
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        checkRange(this.min, max);
        this.max = max;
    }

    @Override
    public void saveValueOfAttempt(String value) {
        lastEnteredValue = value;
        values.add(value);
    }

    @Override
    public boolean isWon() {
        if (isTargetNumber()) {
            return true;
        }
        if (isNumberInRange()) {
            setNewRange();
        }
        return false;
    }

    private boolean isTargetNumber() {
        Optional<Integer> lastValue = getLastEnteredNumber();
        if (lastValue.isEmpty()){
            return false;
        }
        return currentNumber == targetNumber;
    }

    private boolean isNumberInRange() {
        return currentNumber > min && currentNumber < max;
    }

    private Optional<Integer> getLastEnteredNumber() {
        if (isEnteredValueIsNumber()){
            currentNumber = Integer.parseInt(lastEnteredValue);
        } else {
            return Optional.empty();
        }

        return Optional.of(currentNumber);
    }

    private boolean isEnteredValueIsNumber() {
        try {
            Integer.parseInt(lastEnteredValue);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public void setNewRange() {
        if (currentNumber < targetNumber) {
            setMin(currentNumber);
        } else {
            setMax(currentNumber);
        }
    }

    @Override
    public void countAttempt() {
        tries++;
    }

    @Override
    public int getNumberOfAttempts() {
        return tries;
    }

    @Override
    public List<String> getEnteredValues() {
        return values;
    }

}
