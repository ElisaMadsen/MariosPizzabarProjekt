import java.util.Arrays;
import java.util.Scanner;

public class Pizza {
    static Scanner sc = new Scanner(System.in);
    private int number;
    private String name;
    private int price;

    public Pizza(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
    }
    public static void menukort(){
        System.out.println("1. Margherita..............50 kr.");
        System.out.println("2. Pepperoni...............60 kr.");
        System.out.println("3. capricciossa............72 kr.");
        System.out.println("4. Solo Mio................75 kr.");
        System.out.println("5. Italiana................80 kr.");
    }

    public static void choosePizza() {
        System.out.println("Antal pizzaer:");
        int antalPizzaer = sc.nextInt();

        System.out.println("Nummer på kundens ønskede pizza:");
        Pizza margherita = new Pizza(1, "Margherita", 50);
        Pizza pepperoni = new Pizza(2, "Pepperoni", 60);
        Pizza capricciossa = new Pizza(3, "Capricciossa", 72);
        Pizza soloMio = new Pizza(4, "Solo mio", 75);
        Pizza italiana = new Pizza(5, "Italiana", 80);

        Pizza[] menukort = {margherita, pepperoni, capricciossa, soloMio, italiana};

        for (int i = 0; i < menukort.length; i++) {
            System.out.println(menukort[i]);
        }

        for (int i = 0; i < antalPizzaer; i++) {
            Pizza pizzaChoice = menukort[sc.nextInt() - 1];

            System.out.println(pizzaChoice);
        }
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Pizza{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

