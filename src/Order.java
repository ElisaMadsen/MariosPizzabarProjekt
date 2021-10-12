import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    static Scanner sc = new Scanner(System.in);
    private String customerName;
    private int numberOfPizzas;
    private ArrayList pizzaName;
    private String pickUpTime;

    public Order(String customerName, int numberOfPizzas, ArrayList pizzaName, String pickUpTime) {
        this.customerName = customerName;
        this.numberOfPizzas = numberOfPizzas;
        this.pizzaName = pizzaName;
        this.pickUpTime = pickUpTime;
    }

    @Override
    public String toString() {
        return "Ordre: " + " name: " + customerName + " has ordred: "+numberOfPizzas+" pizzas, with pick up at: " + pickUpTime;
    }

    public static void createNewOrdre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv dit navn:");
        String ordreName = scanner.nextLine();
        System.out.println("Antal pizzaer:");
        int antalPizzaer = scanner.nextInt();
        System.out.println("Nummer på kundens ønskede pizza:");

        Pizza margherita = new Pizza(1, "Margherita", 50);
        Pizza pepperoni = new Pizza(2, "Pepperoni", 60);
        Pizza capricciossa = new Pizza(3, "Capricciossa", 72);
        Pizza soloMio = new Pizza(4, "Solo mio", 75);
        Pizza italiana = new Pizza(5, "Italiana", 80);

        Pizza[] menukort = {margherita, pepperoni, capricciossa, soloMio, italiana};
        ArrayList<Pizza> valgtePizzaer = new ArrayList();

        for (int i = 0; i < menukort.length; i++) {
            System.out.println(menukort[i]);
        }
        for (int i = 0; i < antalPizzaer; i++) {
            Pizza pizzaChoice = menukort[scanner.nextInt() - 1];
            valgtePizzaer.add(pizzaChoice);
            System.out.println(pizzaChoice);
        }
        scanner.nextLine();
        System.out.println("Skriv hvornår du kan hente din ordre:");
        String pickUpOrdreTime = scanner.nextLine();

        Order newOrder123 = new Order(ordreName, antalPizzaer, valgtePizzaer, pickUpOrdreTime);

        System.out.println(newOrder123);
        for (Pizza a : valgtePizzaer) {
            System.out.println(a);
        }
    }


    }
