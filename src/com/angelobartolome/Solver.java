package com.angelobartolome;

import java.util.*;


/**
 * Created by angelo on 10/05/17.
 */
public class Solver {
    private final City startCity;
    private final City goalCity;
    private City finalCity;

    public Solver(City startCity, City goalCity) {
        this.startCity = startCity;
        this.goalCity = goalCity;
    }

    public City solve() {

        // Cities to search, ordering by smallest cost
        PriorityQueue<City> cityPriorityQueue = new PriorityQueue<>((cityA, cityB) -> {
            if (cityA.getTotalCost() > cityB.getTotalCost())
                return 1;
            else if (cityA.getTotalCost() < cityB.getTotalCost())
                return -1;

            return 0;
        });

        Set<City> cityExploredSet = new HashSet<>();

        startCity.setCostToReachHere(0);
        cityPriorityQueue.add(startCity);

        System.out.println("Solving...");

        City currentCity = null;

        while (!cityPriorityQueue.isEmpty()) {
            // Grab city with smallest cost
            currentCity = cityPriorityQueue.poll();

            // Put into the explored city list
            cityExploredSet.add(currentCity);

            System.out.println("Grabbed: " + currentCity.getName());

            // Check if this city is the goal
            if (currentCity.equals(goalCity)) {
                System.out.println("Done!");
                break;
            }

            // For each city in border
            for (Border border : currentCity.getBorders()) {
                City cityToAnalyse = border.getCity();

                // Cost is the distance of current city to next city
                double distance = border.getDistance();

                // Current sum of cost to reach this state
                double stateCost = currentCity.getCostToReachHere() + distance;

                // Current evaluation function (f(x) = g(x) + h(x))
                double currentTotalCost = stateCost + cityToAnalyse.getDistanceToGoal();

                // If did explore this before, and it's more expensive than it's last cost
                // skip it.
                boolean hasExploredYet = cityExploredSet.contains(cityToAnalyse);
                boolean isLessExpensive = currentTotalCost < cityToAnalyse.getTotalCost();
                if (!hasExploredYet || isLessExpensive) {

                    cityToAnalyse.setParent(currentCity);
                    cityToAnalyse.setCostToReachHere(stateCost);
                    cityToAnalyse.setTotalCost(currentTotalCost);

                    cityPriorityQueue.add(cityToAnalyse);
                }
            }
        }

        return currentCity;
    }
}
