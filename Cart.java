import java.util.ArrayList;

public class Cart {
    public static ArrayList<String> items = new ArrayList<>();
    public static double total = 0;

    public static void addItem(String name, double price){
        items.add(name + " - $" + price);
        total += price;
    }
}