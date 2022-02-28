package com.fabrice.go4lunch.service;

import com.fabrice.go4lunch.model.Restaurant;
import com.fabrice.go4lunch.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FakeGenerator {

    public static List<Restaurant> LIST_RESTAURANTS = Arrays.asList(
        new Restaurant(1,"Le Zinc", "12 Rue du Faubourg Poissonnière", "8h00-22h00", "120m", "https://i.pravatar.cc/150?u=a042581f4e29026703"),
        new Restaurant(2,"Le Zinc", "12 Rue du Faubourg Poissonnière", "8h00-22h00", "120m", "https://i.pravatar.cc/150?u=a042581f4e29026703"),
        new Restaurant(3,"Le Zinc", "12 Rue du Faubourg Poissonnière", "8h00-22h00", "120m", "https://i.pravatar.cc/150?u=a042581f4e29026703"),
        new Restaurant(4,"Le Zinc", "12 Rue du Faubourg Poissonnière", "8h00-22h00", "120m", "https://i.pravatar.cc/150?u=a042581f4e29026703"),
        new Restaurant(5,"Le Zinc", "12 Rue du Faubourg Poissonnière", "8h00-22h00", "120m", "https://i.pravatar.cc/150?u=a042581f4e29026703")
    );

    public static List<User> LIST_USER = Arrays.asList(
            new User(1,"TOTO", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Le Zinc", true),
            new User(2,"TITI", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Le Zinc", true),
            new User(3,"TATA", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Le Zinc", true),
            new User(4,"KIKI", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Le Zinc", true),
            new User(5,"KOKO", "https://i.pravatar.cc/150?u=a042581f4e29026703b", "Le Zinc", true)
    );

    static ArrayList<Restaurant> generateRestaurant() {
        return new ArrayList<>(LIST_RESTAURANTS);
    }

    static ArrayList<User> generateUser() {
        return new ArrayList<>(LIST_USER);
    }
}
