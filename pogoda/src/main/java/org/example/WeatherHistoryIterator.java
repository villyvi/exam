package org.example;
import java.util.Iterator;

import java.util.List;

class WeatherHistoryIterator implements Iterator<String> {
    private final List<String> history;
    private int position = 0;

    public WeatherHistoryIterator(List<String> history) {
        this.history = history;
    }

    @Override
    public boolean hasNext() {
        return position < history.size();
    }

    @Override
    public String next() {
        return history.get(position++);
    }
}