// importing required classes
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    // declaration of variables
    private String name; // name of the restaurant
    private String location; // location of the restaurant
    public LocalTime openingTime; // opening time of the restaurant
    public LocalTime closingTime; // closing time of the restaurant

    // List interface for the food item(s) in menu
    private List<Item> menu = new ArrayList<Item>();

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

    // method to check if restaurant is open
    public boolean isRestaurantOpen() {

        // calling method to get the current time
        LocalTime currentTime = getCurrentTime();

        /* checking if the current time
         * is between opening and closing time */
        if (currentTime.isAfter(openingTime)
                &&
                currentTime.isBefore(closingTime)) {

            return true;

        }
        else {

            return false;

        }

    }

    // method to get the current time
    public LocalTime getCurrentTime(){

        return  LocalTime.now();

    }

    // method to get the food menu
    public getMenu() {

        return menu;

    }

    /* method to get the food item
     * from the menu by passing
     * food name
     */
    private Item findItemByName(String itemName){

        // for each loop to iterate forward in List interface
        for(Item item: menu) {

            // check condition using food name
            if (item.getName().equals(itemName))

                return item;

        }

        return null;

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<ADMIN JOBS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    /* method to add food details
     * in menu by admin
     */
    public void addToMenu(String name, int price) {

        Item newItem = new Item(name,price);

        menu.add(newItem);

    }

    /* method to remove food details
     * from menu by admin
     */
    public void removeFromMenu(String itemName) throws ItemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);

        if (itemToBeRemoved == null) {

            throw new ItemNotFoundException(itemName);

        }


        menu.remove(itemToBeRemoved);

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<ADMIN JOBS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    /* method to print
     * restaurant details and
     * menu food details
     */
    public void displayDetails() {

        System.out.println("Restaurant:" + name + "\n"
                + "Location:" + location + "\n"
                + "Opening time:" + openingTime + "\n"
                + "Closing time:" + closingTime + "\n"
                + "Menu:" + "\n" + getMenu());

    }

    // method to return name of the restaurant
    public String getName() {

        return name;

    }

}
