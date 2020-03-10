package ua.sonnet;

import ua.sonnet.controller.impl.SearchController;
import ua.sonnet.engine.SearchEngine;
import ua.sonnet.engine.impl.Engine;
import ua.sonnet.view.BaseChat;
import ua.sonnet.view.impl.Chat;

public class SearchService {
    public static void main(String[] args) {
        SearchEngine searchEngine = Engine.getInstance();
        BaseChat chat = new Chat();

        SearchController controller = new SearchController(chat, searchEngine);
        controller.search();

    }
}
