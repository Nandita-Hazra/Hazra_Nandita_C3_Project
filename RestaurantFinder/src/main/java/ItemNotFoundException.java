/* Java program for exception handling
 * in case of food item not present in dynamic array of food items.
 * */
public class ItemNotFoundException extends Throwable {
    public ItemNotFoundException(String itemName) {

        super(itemName);

    }
}
