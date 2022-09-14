// importing required classes
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService {
    // creating dynamic array of restaurants using List interface
    private static final List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantService() {
        orderedFoodItems = new ArrayList<>();
    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BEGINS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // method to check if restaurant exists or not
    public Restaurant findRestaurantByName(String restaurantName){

        /* for each loop to iterate forward
        * in List interface */
        for (Restaurant varRestaurant: restaurants) {

            if (varRestaurant.getName().equals(restaurantName)) {

                return varRestaurant;

            }
            else {

                System.out.println(
                        "Error: Restaurant could not be found");

                return null;

            }

        }

        return null;

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH ENDS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<<<<<<<<<<<USER: ORDERING FOOD ITEMS BEGINS HERE>>>>>>>>>>>>>>>>>>>>>>>>>

    /* The user could add items
     * and find out how much they will be spending. */

    // dynamic array for the food item(s) ordered
    public List<Item> orderedFoodItems;

    /* method to order food items
     * from menu by user
     */
    public void addToOrderedList(String name, int price) {

        Item newItem = new Item(name, price);

        orderedFoodItems.add(newItem);

    }


    // method to sum price of ordered food items
    public int orderTotal() {

        int sum = 0;

        /* for each loop to iterate forward
        * in List interface */
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
    * in List interface
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

        // adding new Restaurant object to List interface
        restaurants.add(newRestaurant);

    }

    /* method to remove an existing restaurant
    * from List interface
    * by admin */
    public void removeRestaurant(String restaurantName) {

        // class variable
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);

        // removing object from List interface
        restaurants.remove(restaurantToBeRemoved);

    }

    //<<<<<<<<<<<<<<ADMIN: ADDING OR/AND REMOVING RESTAURANTS ENDS HERE>>>>>>>>>>>>>>>>>>>>

    /* method to pass restaurant details
    * from List interface */
    public List<Restaurant> getRestaurants() {

        return restaurants;

    }

}

