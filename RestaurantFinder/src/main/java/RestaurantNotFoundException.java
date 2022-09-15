/* Java program for exception handling
* in case of restaurant not present in dynamic array of restaurants.
* */
public class RestaurantNotFoundException extends Throwable {

    public RestaurantNotFoundException(String restaurantName) {

        super(restaurantName);

    }

}

