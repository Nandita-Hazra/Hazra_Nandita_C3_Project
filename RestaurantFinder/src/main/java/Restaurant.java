/* Java program of restaurant details.
* This program does the following:
* 1. Checks the open/close status of restaurant.
* 2. Searches the menu of a given restaurant for food items.
* 3. Admin can add or/and remove food items from the menu of a given restaurant.
* */

// importing required classes
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

// class of restaurant's details
public class Restaurant {

    // declaration of variables
    private final String name; // name of the restaurant
    private final String location; // location of the restaurant
    public LocalTime openingTime; // opening time of the restaurant
    public LocalTime closingTime; // closing time of the restaurant

    // creating constructor of Restaurant class
    public Restaurant(String name,
                      String location,
                      LocalTime openingTime,
                      LocalTime closingTime) {

        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;

    }

    //<<<<<<<<<<<<<<<<<<<RESTAURANT'S OPEN/CLOSE STATUS BEGINS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // method to check if restaurant is open
    public boolean isRestaurantOpen() {

        // calling method to get the current time
        LocalTime currentTime = getCurrentTime();

        /* checking if the current time
         * is between opening and closing time,
         * to know that the restaurant is open or close */
        if (currentTime.isAfter(openingTime)
                &&
                currentTime.isBefore(closingTime)) {

            return true; // restaurant is open

        }
        else {

            return false; // restaurant is close

        }

    }

    // method to get the current time
    public LocalTime getCurrentTime(){

        return  LocalTime.now();

    }

    //<<<<<<<<<<<<<<<<<<<RESTAURANT'S OPEN/CLOSE STATUS ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<<<<<<<<<<FOOD ITEMS SEARCH STARTS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    // List interface for the food item(s) in menu
    private final List<Item> menu = new ArrayList<>();

    // method to get the food menu
    public List<Item> getMenu() {

        return menu;

    }

    // method to get name of the restaurant
    public String getName() {

        return name;

    }

    /* method to get the food item
     * from the menu by passing
     * food name
     */
    private Item findItemByName(String itemName){

        // for each loop to iterate forward in List interface
        for(Item item: menu) {

            // check condition using food name
            if (item.getName().equals(itemName)) {

                return item;

            }

        }

        return null;

    }

    //<<<<<<<<<<<<<<<<<<<<<<<FOOD ITEMS SEARCH ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<ADMIN JOBS BEGINS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    /* method to add food items
     * in menu by admin
     */
    public void addToMenu(String name, int price) {

        Item newItem = new Item(name, price);

        menu.add(newItem);

    }

    /* method to remove food items
     * from menu by admin
     */
    public void removeFromMenu(String itemName) throws ItemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);

        if (itemToBeRemoved == null) {

            throw new ItemNotFoundException(itemName);

        }


        menu.remove(itemToBeRemoved);

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<ADMIN JOBS ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}
