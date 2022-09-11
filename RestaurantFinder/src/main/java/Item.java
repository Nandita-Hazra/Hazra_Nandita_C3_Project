// class of food items in menu
public class Item {

    // declaration of variables
    private String name; // name of food items
    private int price; // price of food items

    // constructor
    public Item(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // method to get food item name
    public String getName() {

        return name;

    }

    //pre-defined annotation
    @Override
    // method to get food item name and price
    public String toString() {

        return  name
                + ":"
                + price
                + "\n"
                ;

    }
}


