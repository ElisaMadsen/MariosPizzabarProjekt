import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

// Order klassen er blevet kodet af Mikkel
public class Order {
    static Scanner sc = new Scanner(System.in);
    private String kundeNavn;
    private int antalPizzaer;
    private ArrayList pizzaNavne;
    private String afhentningsTidspunkt;

    public Order(String kundeNavn, int antalPizzaer, ArrayList pizzaNavne, String afhentningsTidspunkt) {
        this.kundeNavn = kundeNavn;
        this.antalPizzaer = antalPizzaer;
        this.pizzaNavne = pizzaNavne;
        this.afhentningsTidspunkt = afhentningsTidspunkt;
    }

    @Override
    public String toString() {
        return "Bestilling til " + "navn: " + kundeNavn + " som har bestilt: "+antalPizzaer+" pizzaer, med afhentningstidspunkt: " + afhentningsTidspunkt;
    }

}
