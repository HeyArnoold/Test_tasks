package apiTests.testData;

import apiTests.pojos.LocationPojo;

public class LocationBuilder {
    LocationPojo currentLocation = new LocationPojo();

    public LocationBuilder setCity(String city) {
        currentLocation.setName(city);
        return this;
    }

    public LocationBuilder setCountry(String country) {
        currentLocation.setCountry(country);
        return this;
    }

    public LocationBuilder setRegion(String region) {
        currentLocation.setRegion(region);
        return this;
    }

    public LocationBuilder setLat(String lat) {
        currentLocation.setLat(lat);
        return this;
    }

    public LocationBuilder setLon(String lon) {
        currentLocation.setLon(lon);
        return this;
    }

    public LocationBuilder setTimezoneId(String timezoneId) {
        currentLocation.setTimezoneId(timezoneId);
        return this;
    }

    public LocationBuilder setUtcOffset(String utcOffset) {
        currentLocation.setUtcOffset(utcOffset);
        return this;
    }

    public LocationPojo build() {
        return currentLocation;
    }
}
