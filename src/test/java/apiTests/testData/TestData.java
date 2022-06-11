package apiTests.testData;

import apiTests.pojos.LocationPojo;

public class TestData {
    private static LocationBuilder builder = new LocationBuilder();

    public static LocationPojo expectedResultInCity(String city) {
        return switch (city) {
            case "New York" -> builder.setCity("New York")
                    .setCountry("United States of America")
                    .setRegion("New York")
                    .setLat("40.714")
                    .setLon("-74.006")
                    .setTimezoneId("America/New_York")
                    .setUtcOffset("-4.0").build();
            case "London" -> builder.setCity("London")
                    .setCountry("United Kingdom")
                    .setRegion("City of London, Greater London")
                    .setLat("51.517")
                    .setLon("-0.106")
                    .setTimezoneId("Europe/London")
                    .setUtcOffset("1.0").build();
            case "Shanghai" -> builder.setCity("Shanghai")
                    .setCountry("China")
                    .setRegion("Shanghai")
                    .setLat("31.005")
                    .setLon("121.409")
                    .setTimezoneId("Asia/Shanghai")
                    .setUtcOffset("8.0").build();
            default -> builder.setCity("Singapur")
                    .setCountry("Mexico")
                    .setRegion("Sonora")
                    .setLat("26.915")
                    .setLon("-109.229")
                    .setTimezoneId("America/Hermosillo")
                    .setUtcOffset("-7.0").build();
        };
    }
}
