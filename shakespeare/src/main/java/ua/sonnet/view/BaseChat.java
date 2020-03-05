package ua.sonnet.view;

import java.util.List;

public interface BaseChat {

    void askToSelectLanguage();

    void getWrongLanguageMessage();

    void printGreeting();

    void askToSetSonnetsRange();

    void askToEnterRangeStart();

    void askToEnterRangeEnd();

    void wrongRange();

    void askToEnterWordForSearch();

    void getProcessingMessage();

    void printResultsMessage(int numberOfUrls);
}
