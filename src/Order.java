import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    static Scanner sc = new Scanner(System.in);
    private String customerName;
    private int numberOfPizzas;
    private String pizzaName;
    private double pickUpTime;

    public Order(String customerName, int numberOfPizzas, String pizzaName, double pickUpTime) {
        this.customerName = customerName;
        this.numberOfPizzas = numberOfPizzas;
        this.pizzaName = pizzaName;
        this.pickUpTime = pickUpTime;
    }



}
