/* Java program to demonstrate unit testing of RestaurantService.java.
*
* Unit testing will be done by using the concept of mocking.
*
* A. Following are the test cases for search functionality:
*       1. On search, restaurant exists and therefore returns restaurant's details.
*       2. On search, restaurant does not exist and therefore throws exception.
*
* B. Test case for checking correct order total for ordered food items.
*
* C. Following are the test cases for adding and/or removing restaurant functionality:
*       1. Removing restaurant decreases the dynamic array size.
*       2. Exception will be thrown for non-existent restaurant's removal.
*       3. Adding restaurant increases the dynamic array size.
* */

// importing required classes
import java.time.LocalTime;

import static java.lang.constant.ConstantDescs.NULL;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.mock;

// mocking to be used for unit testing
@ExtendWith(MockitoExtension.class)

class RestaurantServiceTest {

    // declaring class variables
    Restaurant restaurantMock;
    RestaurantService restaurantServiceMock;

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH BEGINS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    @Test
    public void searching_for_existing_restaurant_should_return_expected_restaurant_object() {

        String restaurantName = "Amelia's cafe";

        // mocking RestaurantService class
        restaurantServiceMock = mock(RestaurantService.class);

        // using mocked RestaurantService class's method to check if restaurant exist
        String restaurantNameAsPresent
                = String.valueOf(restaurantServiceMock.findRestaurantByName(restaurantName));

        // setting the restaurant exist flag using simplified if statement
        boolean restaurantExist = (restaurantNameAsPresent != NULL);

        // using assertion for the restaurant exists case
        assert restaurantExist: true;

    }

    @Test
    public void searching_for_non_existing_restaurant_should_throw_exception() {

        String restaurantName = "Roger's restaurant";

        // mocking RestaurantService class
        restaurantServiceMock = mock(RestaurantService.class);

            /* using assertion to throw exception for
             * restaurant does not exist in dynamic array test case  */
            assertThrows(RestaurantNotFoundException.class,
                    ()->restaurantServiceMock.findRestaurantByName(restaurantName));

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<SEARCH ENDS>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<<<<<<<<<<<USER: ORDERING FOOD ITEMS BEGINS HERE>>>>>>>>>>>>>>>>>>>>>>>>>

    @Test
    public void ordering_food_items_should_give_correct_order_total() {

        // mocking RestaurantService class
        restaurantServiceMock = mock(RestaurantService.class);

        // ordering two food items from menu
        restaurantServiceMock.addToOrderedList("Sweet corn soup", 119);
        restaurantServiceMock.addToOrderedList("Vegetable lasagne", 269);

        // mocking method to get order total
        int sumMock = restaurantServiceMock.orderTotal();

        // using assertion for correct order total test case
        assertEquals (sumMock, 388);

    }

    //<<<<<<<<<<<<<<<<<<<<<<<<USER: ORDERING FOOD ITEMS ENDS HERE>>>>>>>>>>>>>>>>>>>>>>>>>>>

    //<<<<<<<<<<<<<<ADMIN: ADDING OR/AND REMOVING RESTAURANTS BEGINS HERE>>>>>>>>>>>>>>>>>>>
    @Test
    public void remove_restaurant_should_reduce_list_of_restaurants_size_by_1(LocalTime openingTime, LocalTime closingTime) {

        // creating object of Restaurant class
        restaurantMock = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // getting the dynamic array size to know the number of restaurants present
        int initialNumberOfRestaurants = restaurantServiceMock.getRestaurants().size();

        // removing restaurant from dynamic array
        restaurantServiceMock.removeRestaurant("Amelie's cafe");

        /* using assertion for
        * dynamic array's size reduction test case */
        assertEquals(initialNumberOfRestaurants - 1,
                restaurantServiceMock.getRestaurants().size());

    }

    @Test
    public void removing_restaurant_that_does_not_exist_should_throw_exception(LocalTime openingTime, LocalTime closingTime) {

        // creating object of Restaurant class
        restaurantMock = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        /* using assertion for
        * restaurant does not exist
        * in dynamic array test case  */
        assertThrows(RestaurantNotFoundException.class,
                ()->restaurantServiceMock.removeRestaurant("Pantry d'or"));

    }

    @Test
    public void add_restaurant_should_increase_list_of_restaurants_size_by_1(LocalTime openingTime, LocalTime closingTime){

        // creating object of Restaurant class
        restaurantMock = new Restaurant("Amelie's cafe",
                "Chennai",
                openingTime,
                closingTime);

        // getting the dynamic array size to know the number of restaurants present
        int initialNumberOfRestaurants = restaurantServiceMock.getRestaurants().size();

        restaurantServiceMock.addRestaurant("Pumpkin Tales",
                "Chennai",
                LocalTime.parse("12:00:00"),
                LocalTime.parse("23:00:00"));

        assertEquals(initialNumberOfRestaurants + 1,
                restaurantServiceMock.getRestaurants().size());

    }

    //<<<<<<<<<<<<<<ADMIN: ADDING OR/AND REMOVING RESTAURANTS ENDS HERE>>>>>>>>>>>>>>>>>>>>

}