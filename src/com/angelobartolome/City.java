package com.angelobartolome;

/**
 * Created by angelo on 10/05/17.
 */
public class City {
    private String name;
    private int distanceToGoal;

    private Border[] borders;

    private City parent;

    private double costToReachHere;
    private double totalCost;

    public City() {
    }

    public City(String name, int distanceToGoal) {
        this.name = name;
        this.distanceToGoal = distanceToGoal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        City city = (City) o;

        return name != null ? name.equals(city.name) : city.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceToGoal() {
        return distanceToGoal;
    }

    public void setDistanceToGoal(int distanceToGoal) {
        this.distanceToGoal = distanceToGoal;
    }

    public Border[] getBorders() {
        return borders;
    }

    public void setBorders(Border[] borders) {
        this.borders = borders;
    }


    public void setParent(City parent) {
        this.parent = parent;
    }

    public City getParent() {
        return parent;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public double getCostToReachHere() {
        return costToReachHere;
    }

    public void setCostToReachHere(double costToReachHere) {
        this.costToReachHere = costToReachHere;
    }
}
