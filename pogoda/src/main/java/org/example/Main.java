package org.example;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WeatherStation station = WeatherStation.getInstance();

        WeatherObserver client1 = new WeatherClient("Пупа");
        WeatherObserver client2 = new WeatherClient("Таті");
        station.addObserver(client1);
        station.addObserver(client2);

        WeatherProxy proxy = new WeatherProxy();

        List<String> weatherHistory = new ArrayList<>();

        System.out.println("Оберіть місто (Київ, Львів, Лалаленд, Жовтенькі Камази): ");
        String city = scanner.nextLine();

        String weather = proxy.getWeather(city);
        System.out.println("Погода у місті " + city + ": " + weather);

        System.out.println("Оновити погоду для " + city + "? (так/ні)");
        String updateResponse = scanner.nextLine();
        if (updateResponse.equalsIgnoreCase("так")) {
            System.out.println("Введіть нові дані про погоду:");
            String newWeather = scanner.nextLine();
            station.updateWeather(city, newWeather);
            weatherHistory.add(city + ": " + newWeather);
        }

        System.out.println("Історія змін погоди:");
        WeatherHistoryIterator iterator = new WeatherHistoryIterator(weatherHistory);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        scanner.close();
    }
}