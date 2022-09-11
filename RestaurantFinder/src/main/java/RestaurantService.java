// importing required classes
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    // creating dynamic array of restaurants using List interface
    private static List<Restaurant> restaurants = new ArrayList<>();

    // method to check if restaurant exists or not
    public Restaurant findRestaurantByName(String restaurantName){

        /* for each loop to iterate forward
        * in dynamic array of restaurants */
        for (Restaurant varRestaurant: restaurants) {

            if (varRestaurant.getName().equals(restaurantName)) {

                return varRestaurant;

            }
            else {

                System.out.println("Error: Restaurant doesn't exist.");

                return null;

            }

        }

        return null;

    }

    /* method to add a new restaurant
    * in dynamic array of restaurants */
    public Restaurant addRestaurant(String name,
                                    String location,
                                    LocalTime openingTime,
                                    LocalTime closingTime) {

        Restaurant newRestaurant = new Restaurant(name,
                                                    location,
                                                    openingTime,
                                                    closingTime);

        restaurants.add(newRestaurant);

        return newRestaurant;

    }

    /* method to remove an existing restaurant
    * in dynamic array of restaurants */
    public Restaurant removeRestaurant(String restaurantName)
            throws RestaurantNotFoundException {

        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);

        restaurants.remove(restaurantToBeRemoved);

        return restaurantToBeRemoved;

    }

    /* method to pass restaurant details
    * from dynamic array of restaurants */
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

}

