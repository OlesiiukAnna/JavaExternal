package com.game;

import com.game.controller.BaseController;
import com.game.controller.impl.NumberGameController;
import com.game.model.impl.NumberGame;
import com.game.view.BaseChat;
import com.game.view.impl.ConsoleChat;

public class Main {
    public static void main(String[] args) {
        NumberGame numberGame = new NumberGame();
        BaseChat chat = new ConsoleChat();
        BaseController controller = new NumberGameController(chat, numberGame);

        controller.startGame();
    }
}
