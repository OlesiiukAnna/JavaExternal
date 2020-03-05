package ua.sonnet.engine;

import ua.sonnet.engine.entity.Word;
import ua.sonnet.exceptions.EngineException;

public interface SearchEngine {

    Word findMatches(String word) throws EngineException;

    void setStartRange(int start);

    void setEndRange(int endRange);

    String getSiteUrl();
}
