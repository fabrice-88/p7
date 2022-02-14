package com.fabrice.go4lunch.service;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeGenerator {

    public static List<Restaurant> LIST_RESTAU = Arrays.asList(
        new Restaurant(1,"Le Zinc", "12 rue du Faubourg Poissonnière", "8h00-22h00", "120m"),
        new Restaurant(2,"Le Zinc", "12 rue du Faubourg Poissonnière", "8h00-22h00", "120m"),
        new Restaurant(3,"Le Zinc", "12 rue du Faubourg Poissonnière", "8h00-22h00", "120m"),
        new Restaurant(4,"Le Zinc", "12 rue du Faubourg Poissonnière", "8h00-22h00", "120m"),
        new Restaurant(5,"Le Zinc", "12 rue du Faubourg Poissonnière", "8h00-22h00", "120m")
    );

    public static List<User> LIST_USER = Arrays.asList(
            new User(1,"TOTO", "12 rue du Faubourg Poissonnière", "Le Zinc", true),
            new User(2,"TITI", "12 rue du Faubourg Poissonnière", "Le Zinc", true),
            new User(3,"TATA", "12 rue du Faubourg Poissonnière", "Le Zinc", true),
            new User(4,"KIKI", "12 rue du Faubourg Poissonnière", "Le Zinc", true),
            new User(5,"KOKO", "12 rue du Faubourg Poissonnière", "Le Zinc", true)
    );

    static List<Restaurant> generateRestaurant() {
        return new ArrayList<>(LIST_RESTAU);
    }

    static List<User> generateUser() {
        return new ArrayList<>(LIST_USER);
    }
}
