package org.example;

class WeatherProxy {
    private final WeatherStation weatherStation;

    public WeatherProxy() {
        this.weatherStation = WeatherStation.getInstance();
    }

    public String getWeather(String city) {
        System.out.println("Отримання даних  для міста: " + city);
        return weatherStation.getWeather(city);
    }
}