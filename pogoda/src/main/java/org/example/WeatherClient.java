package org.example;

class WeatherClient implements WeatherObserver {
    private final String name;

    public WeatherClient(String name) {
        this.name = name;
    }

    @Override
    public void update(String city, String weatherData) {
        System.out.println(name + ", ось Ваша оновлена інформація про обране місто! " + city + ": " + weatherData);
    }
}