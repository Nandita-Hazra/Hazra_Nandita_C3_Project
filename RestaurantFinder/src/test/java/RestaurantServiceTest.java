// importing required classes
import java.time.LocalTime;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

// mocking to be used for unit testing
@ExtendWith(MockitoExtension.class)

class RestaurantServiceTest {

    // declaring class variable
    Restaurant objRestaurant;
    RestaurantService objRestaurantService;

    // refactoring for repeatitive code
    @BeforeEach
    public void setup() {

        // setting restaurant's opening time
        LocalTime openingTime = LocalTime.parse("10:30:00");

        // setting restaurant's closing time
        LocalTime closingTime = LocalTime.parse("22:00:00");

    }

    //>>>>>>>>>>>>>>>>>>>>>>SEARCHING<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object()
            throws RestaurantNotFoundException {

        // mocking RestaurantService class
        objRestaurantService = Mockito.mock(RestaurantService.class);

        // using mocked RestaurantService class's method to check if restaurant exist
        String restaurantName = objRestaurantService.findRestaurantByName().varRestaurant.getName();

        // setting the restaurant exist flag
        if (restaurantName == NULL) {

            boolean restaurantExist = true;

        }
        else {

            boolean restaurantExist = false;

        }

        // using assertion for the restaurant exists case
        assertThat(restaurantExist, equals(true));

    }

    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception()
            throws RestaurantNotFoundException {

        // mocking RestaurantService class
        objRestaurantService = Mockito.mock(RestaurantService.class);

        // using mocked RestaurantService class's method to check if restaurant exist
        String restaurantName = objRestaurantService.findRestaurantByName().varRestaurant.getName();

        // setting the restaurant exist flag
        if (restaurantName == NULL) {

            boolean restaurantExist = true;

        }
        else {

            boolean restaurantExist = false;

        }

        // using assertion for the restaurant exists case
        assertThat(restaurantExist, equals(false));


    }
    //<<<<<<<<<<<<<<<<<<<<SEARCHING>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>ADMIN: ADDING & REMOVING RESTAURANTS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1()
            throws RestaurantNotFoundException {

        // creating object of Restaurant class
        objRestaurant = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // adding two food items to menu
        objRestaurant.addToMenu("Sweet corn soup",119);
        objRestaurant.addToMenu("Vegetable lasagne", 269);


        int initialNumberOfRestaurants = service.getRestaurants().size();

        service.removeRestaurant("Amelie's cafe");

        assertEquals(initialNumberOfRestaurants-1,
                service.getRestaurants().size());

    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception()
            throws RestaurantNotFoundException {

        // creating object of Restaurant class
        objRestaurant = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // adding two food items to menu
        objRestaurant.addToMenu("Sweet corn soup",119);
        objRestaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(RestaurantNotFoundException.class,
                ()->service.removeRestaurant("Pantry d'or"));

    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(){

        // creating object of Restaurant class
        objRestaurant = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // adding two food items to menu
        objRestaurant.addToMenu("Sweet corn soup",119);
        objRestaurant.addToMenu("Vegetable lasagne", 269);

        int initialNumberOfRestaurants = service.getRestaurants().size();

        service.addRestaurant("Pumpkin Tales",
                "Chennai",
                LocalTime.parse("12:00:00"),
                LocalTime.parse("23:00:00"));

        assertEquals(initialNumberOfRestaurants + 1,
                service.getRestaurants().size());

    }

    //<<<<<<<<<<<<<<<<<<<<ADMIN: ADDING & REMOVING RESTAURANTS>>>>>>>>>>>>>>>>>>>>>>>>>>

}