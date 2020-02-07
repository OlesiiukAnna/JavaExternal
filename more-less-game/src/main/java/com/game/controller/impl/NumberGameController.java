package com.game.controller.impl;

import com.game.controller.BaseController;
import com.game.ecxeption.WrongValueException;
import com.game.model.impl.NumberGame;
import com.game.view.BaseChat;

import java.util.Optional;

public class NumberGameController implements BaseController {

    private BaseChat chat;
    private NumberGame numberGame;

    private boolean isGameProcessing = true;

    public NumberGameController(BaseChat chat, NumberGame numberGame) {
        this.chat = chat;
        this.numberGame = numberGame;
    }

    @Override
    public void startGame() {
        chat.printCondition();

        do {
            chat.printPreviousAttempts(numberGame.getEnteredValues());
            saveEnteredValue(getEnteredValue());

            if (isGameProcessing()) {
                chat.getWrongValueMassage();
            }
            countAttempt();

        } while (isGameProcessing);

        chat.printCongratulations();
        chat.printStatistic(numberGame.getNumberOfAttempts(), numberGame.getEnteredValues());
    }

    private void countAttempt() {
        numberGame.countAttempt();
    }

    @Override
    public boolean isGameProcessing() {
        isGameProcessing = !numberGame.isWon();
        return isGameProcessing;
    }

    @Override
    public String getEnteredValue() {
        Optional<String> value = chat.getValueFromUser(numberGame.getMin(), numberGame.getMax());
        if (value.isEmpty()) {
            throw new WrongValueException("Some Null appeared");
        }
        return value.get();
    }

    @Override
    public void saveEnteredValue(String value) {
        numberGame.saveValueOfAttempt(value);
    }

}
