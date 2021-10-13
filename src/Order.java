import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    static Scanner sc = new Scanner(System.in);
    private String customerName;
    private int numberOfPizzas;
    private ArrayList pizzaName;
    private String pickUpTime;
    private static ArrayList<Order> orderList = new ArrayList<>();

    public Order(String customerName, int numberOfPizzas, ArrayList pizzaName, String pickUpTime) {
        this.customerName = customerName;
        this.numberOfPizzas = numberOfPizzas;
        this.pizzaName = pizzaName;
        this.pickUpTime = pickUpTime;
    }

    @Override
    public String toString() {
        return "Bestilling til " + "navn: " + customerName + " som har bestilt: "+numberOfPizzas+" pizzaer, med afhentningstidspunkt: " + pickUpTime;
    }


    public static ArrayList<Order> getOrderList() {
        return orderList;
    }
}
