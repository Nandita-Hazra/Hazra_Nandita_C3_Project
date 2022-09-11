// importing required classes
import java.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

// mocking to be used for unit testing
@ExtendWith(MockitoExtension.class)

class RestaurantTest {

    // declaring class variable
    Restaurant objRestaurant;

    // refactoring for repeatitive code
    @BeforeEach
    public void setup() {

        // setting restaurant's opening time
        LocalTime openingTime = LocalTime.parse("10:30:00");

        // setting restaurant's closing time
        LocalTime closingTime = LocalTime.parse("22:00:00");

    }

    //>>>>>>>>>>>>>>>>>>>>>>>>>OPEN/CLOSED<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){

        // setting current time that is in between opening and closing time
        LocalTime currentTime = LocalTime.parse("12:30:15");

        // mocking Restaurant class
        objRestaurant = Mockito.mock(Restaurant.class);

        // mocking method to get current time
        Mockito.when(objRestaurant.getCurrentTime()).thenReturn(currentTime);

        // using mocked Restaurant class's method to check if restaurant is open
        boolean restaurantOpen = objRestaurant.isRestaurantOpen();

        // using assertion for the restaurant open test case
        assertThat(restaurantOpen, equals(true));

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){

        // setting current time that is outside opening and closing time
        LocalTime currentTime = LocalTime.parse("08:40:56");

        // mocking Restaurant class
        objRestaurant = Mockito.mock(Restaurant.class);

        // mocking method to get current time
        Mockito.when(objRestaurant.getCurrentTime()).thenReturn(currentTime);

        // using mocked Restaurant class's method to check if restaurant is open
        boolean restaurantOpen = objRestaurant.isRestaurantOpen();

        // using assertion for the restaurant close test case
        assertThat(restaurantOpen, equals(false));

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<OPEN/CLOSED>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    //>>>>>>>>>>>>>>>>>>>>>>>>>>>MENU<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(){

        // creating object of Restaurant class
        objRestaurant = new Restaurant("Amelie's cafe",
                                        "Chennai",
                                                openingTime,
                                                closingTime);

        // adding two food items to menu
        objRestaurant.addToMenu("Sweet corn soup",119);
        objRestaurant.addToMenu("Vegetable lasagne", 269);

        // determining the size of menu
        int initialMenuSize = restaurant.getMenu().size();

        // adding one more food item to menu
        objRestaurant.addToMenu("Sizzling brownie",319);

        // using assertion for increase in menu's size
        assertEquals(initialMenuSize + 1,
                    objRestaurant.getMenu().size());

    }


    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1() throws ItemNotFoundException {

        // creating object of Restaurant class
        objRestaurant = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // adding two food items to menu
        objRestaurant.addToMenu("Sweet corn soup",119);
        objRestaurant.addToMenu("Vegetable lasagne", 269);

        // determining the size of menu
        int initialMenuSize = restaurant.getMenu().size();

        // removing one food item from menu
        objRestaurant.removeFromMenu("Vegetable lasagne");

        // using assertion for decrease in menu's size
        assertEquals(initialMenuSize-1,
                objRestaurant.getMenu().size());

    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception() {

        // creating object of Restaurant class
        objRestaurant = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // adding two food items to menu
        objRestaurant.addToMenu("Sweet corn soup",119);
        objRestaurant.addToMenu("Vegetable lasagne", 269);

        assertThrows(ItemNotFoundException.class,
                ()->objRestaurant.removeFromMenu("French fries"));

    }

    //<<<<<<<<<<<<<<<<<<<<<<<MENU>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

}