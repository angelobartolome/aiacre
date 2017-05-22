package com.angelobartolome;

/**
 * Created by angelo on 10/05/17.
 */
public class Border {
    private int distance;
    private City city;

    public Border(int distance, City city) {
        this.distance = distance;
        this.city = city;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
