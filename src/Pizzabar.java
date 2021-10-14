import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Pizzabar {

    static ArrayList<Order> bestillingsListe = new ArrayList<>();

    static int[] ordreStatistik = new int[5];

    public static void menukort(){
        Pizza.menukort();
    }

    public static void mariosListe(Order addOrder){
        bestillingsListe.add(addOrder);
    }

    public static void lavNyOrder(){ // Elisa har kodet halvdelen af dette, alt der relatere til Pizzaer. Mikkel kodede det med Order, og vi har sammen siddet og sat det sammen.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Skriv dit navn:");
        String orderNavn = scanner.nextLine();
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
            ordreStatistik[pizzaChoice.getNummer()-1]++;
            valgtePizzaer.add(pizzaChoice);
            System.out.println(pizzaChoice);
        }
        scanner.nextLine();
        System.out.println("Skriv hvornår du kan hente din ordre:");
        String afhentningsTidspunkt = scanner.nextLine();
        Order newOrder = new Order(orderNavn, antalPizzaer, valgtePizzaer, afhentningsTidspunkt);
        System.out.println("Du har bestilt;");
        for (Pizza a : valgtePizzaer) {
            System.out.println(a);
        }
        mariosListe(newOrder);
    }

    public static void main(String[] args) { // Vi har kodet lidt hver  for sig her, men har primært siddet sammen og fået det til at virke.
        Scanner scanner = new Scanner(System.in);

        boolean inputChecker = false;
        while (inputChecker == false) { // Elisa har kodet dette stykke
            System.out.println("Velkommen til Marios pizzabar!\nEr du Mario eller Alfonzo? 1 for Mario, 2 for Alfonzo, 3 for at lukke og se dagens statistik.");
            int erDuMarioEllerAlfonzo = scanner.nextInt();
            if (erDuMarioEllerAlfonzo == 1) {
                System.out.println("Skriv 1 for at se menukort, 2 for at se ordre:");
                int mariosValg = scanner.nextInt();
                if (mariosValg == 1){
                    menukort();
                } else if (mariosValg == 2){
                    for (Order o: bestillingsListe) {
                        System.out.println(o);
                    }

                }
            } else if (erDuMarioEllerAlfonzo == 2) { // Elisa har kodet her
                System.out.println("Skriv 1 for at lave en ny ordre, 2 for at markere en ordre afhentet.");
                int alfonzosValg = scanner.nextInt();
                if (alfonzosValg == 1){
                    lavNyOrder();
                } else if (alfonzosValg == 2){ // Mikkel har kodet her
                    System.out.println("Hvilken ordre vil du afhente?");
                    int afhentOrdre = scanner.nextInt()-1;
                    System.out.println(bestillingsListe.get(afhentOrdre)+" er blevet afhentet nu.");
                    bestillingsListe.remove(afhentOrdre);
                }
            } else if (erDuMarioEllerAlfonzo == 3){ // Mikkel har kodet her
                for (int i = 0; i < ordreStatistik.length; i++) {
                    System.out.println("Pizza nummer: "+(i+1)+" har solgt: "+ordreStatistik[i]+" idag.");
                }

                inputChecker = true;
            }
            else {
                System.out.println("Tast 1 eller 2!");
            }
        }
    }
}
