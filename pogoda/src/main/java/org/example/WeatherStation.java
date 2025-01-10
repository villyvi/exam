package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class WeatherStation {
    private static WeatherStation instance;
    private final Map<String, String> cityWeather = new HashMap<>();
    private final List<WeatherObserver> observers = new ArrayList<>();

    private WeatherStation() {

        cityWeather.put("Київ", "Сонячно ☀, +5°C");
        cityWeather.put("Львів", "Хмарно ☁, +3°C");
        cityWeather.put("Лалаленд", "Дощ ☂, +7°C");
        cityWeather.put("Жовтенькі Камази", "Сніг ❄, -52°C");
    }

    public static synchronized WeatherStation getInstance() {
        if (instance == null) {
            instance = new WeatherStation();
        }
        return instance;
    }

    public String getWeather(String city) {
        return cityWeather.getOrDefault(city, "Дані про погоду недоступні");
    }

    public void updateWeather(String city, String newWeather) {
        cityWeather.put(city, newWeather);
        notifyObservers(city, newWeather);
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String city, String weatherData) {
        for (WeatherObserver observer : observers) {
            observer.update(city, weatherData);
        }
    }
}
