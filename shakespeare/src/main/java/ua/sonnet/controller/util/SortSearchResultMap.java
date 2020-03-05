package ua.sonnet.controller.util;

import java.util.*;

public class SortSearchResultMap {

    public static LinkedHashMap<String, Integer> sortMapByValue(Map<String, Integer> mapToSort) {
        LinkedHashMap<String, Integer> sortedByFrequencyValue = null;
        List<Map.Entry<String, Integer>> list = new LinkedList<>(mapToSort.entrySet());

        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

        sortedByFrequencyValue = new LinkedHashMap<>(list.size());
        for (Map.Entry<String, Integer> entry : list) {
            sortedByFrequencyValue.put(entry.getKey(), entry.getValue());
        }

        return sortedByFrequencyValue;
    }
}
