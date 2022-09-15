/* Java program for restaurant services which are as follows.
* 1. Find restaurant by given name.
* 2. Summation of price of ordered food items.
* 3. Adding or/and removing of restaurants by admin.
* */

// importing required classes
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    // creating dynamic array of restaurants using List interface
    private static final List<Restaurant> restaurants = new ArrayList<>();

    // creating dynamic array of ordered food items
    public RestaurantService() {

        orderedFoodItems = new ArrayList<>();

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH OF RESTAURANT BEGINS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // method to check if restaurant exists or not
    public Restaurant findRestaurantByName(String restaurantName){

        /* for each loop to iterate forward
        * in dynamic array of restaurants */
        for (Restaurant varRestaurant: restaurants) {

            /* condition to check if restaurant exist
            * in dynamic array of restaurants */
            if (varRestaurant.getName().equals(restaurantName)) {

                return varRestaurant; // restaurant exist in dynamic array of restaurants

            }
            else {

                System.out.println(
                        "Error: Restaurant could not be found"); // restaurant does not exist in dynamic array of restaurants

                return null;

            }

        }

        return null;

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH OF RESTAURANT ENDS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<<<<<<<<<<<USER: ORDERING FOOD ITEMS BEGINS HERE>>>>>>>>>>>>>>>>>>>>>>>>>

    /* The user could add items
     * and find out how much they will be spending. */

    // dynamic array for the food item(s) ordered
    public List<Item> orderedFoodItems;

    /* method to order food items
     * from menu by user
     */
    public void addToOrderedList(String name, int price) {

        // creating object of Item class
        Item newItem = new Item(name, price);

        // add an element in the dynamic array of ordered food items
        orderedFoodItems.add(newItem);

    }


    // method to sum price of ordered food items
    public int orderTotal() {

        // declaring and initializing of variable
        int sum = 0;

        /* for each loop to iterate forward
        * in dynamic array of ordered food items */
        for(Item foodItem: orderedFoodItems) {

            // adding up price of ordered food items
            sum = sum + foodItem.price;

        }

        // display order total
        System.out.println(
                "Your order will cost: Rs."
                + sum
        );

        return sum;

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<USER: ORDERING FOOD ITEMS ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<ADMIN: ADDING OR/AND REMOVING RESTAURANTS BEGINS HERE>>>>>>>>>>>>>>>>>>>

    /* method to add a new restaurant
    * in dynamic array of restaurants
    * by admin */
    public void addRestaurant(String name,
                                    String location,
                                    LocalTime openingTime,
                                    LocalTime closingTime) {

        // creating object of Restaurant class
        Restaurant newRestaurant
                = new Restaurant(name,
                location,
                openingTime,
                closingTime);

        // adding an element in dynamic array of restaurants
        restaurants.add(newRestaurant);

    }

    /* method to remove an existing restaurant
    * from dynamic array of restaurants
    * by admin */
    public void removeRestaurant(String restaurantName) {

        // class variable
        Restaurant restaurantToBeRemoved
                = findRestaurantByName(restaurantName);

        // removing restaurant from dynamic array of restaurants
        restaurants.remove(restaurantToBeRemoved);

    }

    //<<<<<<<<<<<<<<ADMIN: ADDING OR/AND REMOVING RESTAURANTS ENDS HERE>>>>>>>>>>>>>>>>>>>>

    /* method to pass restaurant details
    * for a given restaurant
    * from dynamic array of restaurants */
    public List<Restaurant> getRestaurants() {

        return restaurants;

    }

}

