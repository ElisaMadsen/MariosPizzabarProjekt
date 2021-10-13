import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;


public class Pizzabar {

    static ArrayList<Order> bestillingsListe = new ArrayList<>();

    public static void menukort(){
        Pizza.menukort();
    }

    public static void mariosListe(Order hej){
        bestillingsListe.add(hej);
    }


    public static void createNewOrdre(){
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
        mariosListe(newOrder123);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean inputChecker = false;
        while (inputChecker == false) {
            System.out.println("Velkommen til Marios pizzabar!\nEr du Mario eller Alfonzo? 1 for Mario, 2 for Alfonzo, 3 for at lukke.");
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
            } else if (erDuMarioEllerAlfonzo == 2) {
                System.out.println("Skriv 1 for at lave en ny ordre, 2 for at markere en ordre afhentet.");
                int alfonzosValg = scanner.nextInt();
                if (alfonzosValg == 1){
                    createNewOrdre();
                } else if (alfonzosValg == 2){
                    System.out.println("Hvilken ordre vil du afhente?");
                    int afhentOrdre = scanner.nextInt()-1;
                    System.out.println(bestillingsListe.get(afhentOrdre)+" er blevet afhentet nu.");
                    bestillingsListe.remove(afhentOrdre);
                }
            } else if (erDuMarioEllerAlfonzo == 3){
                inputChecker = true;
            }
            else {
                System.out.println("Skriv nu 1 eller 2 din idiot <3");
            }
        }


    }
}
