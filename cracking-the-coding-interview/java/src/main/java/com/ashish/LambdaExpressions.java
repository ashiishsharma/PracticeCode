package com.ashish;

import java.util.List;
import java.util.stream.Stream;

public class LambdaExpressions {

    int getPopulationLambda(List<Country> countries, String continent) {
        /* Filter countries. */
        Stream<Country> sublist = countries.stream().filter(country -> {
            return country.getContinent().equals(continent);
        });

        /* Convert to list of populations. */
        Stream<Integer> populations = sublist.map(c -> c.getPopulation());

        /* Sum list. */
        int population = populations.reduce(0, (a, b) -> a + b);
        return population;
    }

    int getPopulation(List<Country> countries, String continent) {
        int sum = 0;
        for (Country c : countries) {
            if (c.getContinent().equals(continent)) {
                sum += c.getPopulation();
            }
        }
        return sum;
    }

    public class Country {

        public Object getContinent() {
            return null;
        }

        public int getPopulation() {
            return 0;
        }
    }
}
