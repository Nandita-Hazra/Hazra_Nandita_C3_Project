/* Java program to demonstrate unit testing of Restaurant.class.
*
* Unit testing will be done by using the concept of mocking.
*
* A. Following are the test case for restaurant's open/close status:
*       1. Restaurant is open if current time is within opening and closing time.
*       2. Restaurant is close if current time is outside opening and closing time.
*
* B. Following are the test case for restaurant's menu:
*       1. Adding food item in menu should increase the size of dynamic array.
*       2. Removing food item from menu should decrease the size of dynamic array.
*       3. Removing a non-existent food item of menu will throw an exception.
*  */

// importing required classes
import java.time.LocalTime;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

// mocking to be used for unit testing
@ExtendWith(MockitoExtension.class)

// main class
class RestaurantTest {

    // declaring class variable
    Restaurant restaurantMock;

    //>>>>>>>>>>>>>>>>>>>>>>>RESTAURANT'S OPEN/CLOSE STATUS TEST BEGINS HERE<<<<<<<<<<<<<<<<<<<<<<<<<

    @Test
    public void is_restaurant_open_should_return_true_if_time_is_between_opening_and_closing_time(){

        // setting current time that is in between opening and closing time
        LocalTime currentTime = LocalTime.parse("12:30:15");

        // mocking Restaurant class
        restaurantMock = mock(Restaurant.class);

        // mocking method to test current time
        when(restaurantMock.getCurrentTime()).thenReturn(currentTime);

        // using mocked Restaurant class's method to check if restaurant is open
        boolean restaurantOpen = restaurantMock.isRestaurantOpen();

        // using assertion for the restaurant open test case
        assert restaurantOpen: true; // assert statement uses boolean value

    }

    @Test
    public void is_restaurant_open_should_return_false_if_time_is_outside_opening_and_closing_time(){

        // setting current time that is outside opening and closing time
        LocalTime currentTime = LocalTime.parse("08:40:56");

        // mocking Restaurant class
        restaurantMock = mock(Restaurant.class);

        // mocking method to test current time
        when(restaurantMock.getCurrentTime()).thenReturn(currentTime);

        // using mocked Restaurant class's method to check if restaurant is open
        boolean restaurantOpen = restaurantMock.isRestaurantOpen();

        // using assertion for the restaurant close test case
        assert restaurantOpen: false; // assert statement uses boolean value

    }

    //>>>>>>>>>>>>>>>>>>>>>>>RESTAURANT'S OPEN/CLOSE STATUS TEST ENDS HERE<<<<<<<<<<<<<<<<<<<<<<<<<


    //>>>>>>>>>>>>>>>>>>>>>>>ADDING/REMOVING IN/FROM MENU TEST BEGINS HERE<<<<<<<<<<<<<<<<<<<<<<<<<

    @Test
    public void adding_item_to_menu_should_increase_menu_size_by_1(LocalTime closingTime, LocalTime openingTime){

        // creating object of Restaurant class
        restaurantMock = new Restaurant("Amelie's cafe",
                                        "Chennai",
                                                openingTime,
                                                closingTime);

        // adding two food items to menu
        restaurantMock.addToMenu("Sweet corn soup",119);
        restaurantMock.addToMenu("Vegetable lasagne", 269);

        // determining the size of menu
        int initialMenuSize;
        initialMenuSize = restaurantMock.getMenu().size();

        // adding one more food item to menu
        restaurantMock.addToMenu("Sizzling brownie",319);

        // using assertion for increase in menu's size
        assertEquals(initialMenuSize + 1,
                    restaurantMock.getMenu().size());

    }


    @Test
    public void removing_item_from_menu_should_decrease_menu_size_by_1(LocalTime openingTime, LocalTime closingTime) throws ItemNotFoundException {

        // creating object of Restaurant class
        restaurantMock = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // determining the size of menu
        int initialMenuSize = restaurantMock.getMenu().size();

        // removing one food item from menu
        restaurantMock.removeFromMenu("Vegetable lasagne");

        // using assertion for decrease in menu's size
        assertEquals(initialMenuSize-1,
                restaurantMock.getMenu().size());

    }

    @Test
    public void removing_item_that_does_not_exist_should_throw_exception(LocalTime openingTime, LocalTime closingTime) {

        // creating object of Restaurant class
        restaurantMock = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        assertThrows(ItemNotFoundException.class,
                ()->restaurantMock.removeFromMenu("French fries"));

    }

    //>>>>>>>>>>>>>>>>>>>>>>>ADDING/REMOVING IN/FROM MENU TEST ENDS HERE<<<<<<<<<<<<<<<<<<<<<<<<<

}