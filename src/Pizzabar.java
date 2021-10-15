import java.util.ArrayList;
import java.util.Scanner;


public class Pizzabar {

    static ArrayList<Order> bestillingsListe = new ArrayList<>(); // Opretter en ArrayList som kan kaldes i hele classen og på tværs i metoderne.

    static int[] ordreStatistik = new int[5]; // Opretter et Array til at gemme hvilke pizzaer der bliver solgt hvor mange gange (Statistik).

    public static void menukort(){ // Viser menukortet!
        Pizza.menukort();
    }

    public static void mariosListe(Order addOrder){ // Metode til at tilføje ordre vi netop har lavet til bestillingsListe-Arrayet.
        bestillingsListe.add(addOrder);
    }

    public static void lavNyOrder(){ // Elisa har kodet halvdelen af dette, alt der relaterer til Pizzaer. Mikkel kodede det med Order, og vi har sammen siddet og sat det sammen.
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

        Pizza[] menukort = {margherita, pepperoni, capricciossa, soloMio, italiana}; // Oprettelse af menukort som Alfonzo kan se, når han opretter nye ordre.
        ArrayList<Pizza> valgtePizzaer = new ArrayList();

        for (int i = 0; i < menukort.length; i++) {
            System.out.println(menukort[i]);
        }
        for (int i = 0; i < antalPizzaer; i++) {
            Pizza pizzaChoice = menukort[scanner.nextInt() - 1]; // -1 bliver her brugt til at ramme det rigtige indeks i vores Array.
            ordreStatistik[pizzaChoice.getNummer()-1]++; // -1 bliver stadig brugt til at ramme det rigtige indeks i vores Array.
            valgtePizzaer.add(pizzaChoice); // Tilføjer den pizza vi vælger med et tal til vores pizza Array.
            System.out.println(pizzaChoice);
        }
        scanner.nextLine();
        System.out.println("Skriv hvornår du kan hente din ordre:");
        String afhentningsTidspunkt = scanner.nextLine();
        Order newOrder = new Order(orderNavn, antalPizzaer, valgtePizzaer, afhentningsTidspunkt);
        System.out.println(orderNavn+" har bestilt;");
        for (Pizza a : valgtePizzaer) { // For Each loop der viser bestillingen.
            System.out.println(a);
        }
        mariosListe(newOrder); // Tilføjer ordren til "bestillingsListe"-arrayet.
    }

    public static void main(String[] args) { // Vi har kodet lidt hver for sig her, men har primært siddet sammen og fået det til at virke.
        Scanner scanner = new Scanner(System.in);

        boolean inputChecker = false; // Opsætter en checker til vores whileloop, så vi bare kører afsted indtil vi vil "lukke butikken".
        while (inputChecker == false) { // Elisa har kodet dette stykke
            System.out.println("Velkommen til Marios pizzabar!\nEr du Mario eller Alfonzo? 1 for Mario, 2 for Alfonzo, 3 for at lukke og se dagens statistik.");
            int erDuMarioEllerAlfonzo = scanner.nextInt();
            if (erDuMarioEllerAlfonzo == 1) {
                System.out.println("Skriv 1 for at se menukort, 2 for at se ordre:"); // Opsætter 2 muligheder for Mario; Se menukort og se ordre.
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
                int alfonzosValg = scanner.nextInt(); // Opsætter 2 muligheder for Alfonzo; opret ny ordre og afhent ordre (slet fra ArrayList).
                if (alfonzosValg == 1){
                    lavNyOrder();
                } else if (alfonzosValg == 2){ // Mikkel har kodet her
                    System.out.println("Hvilken ordre vil du afhente?");
                    int afhentOrdre = scanner.nextInt()-1;
                    System.out.println(bestillingsListe.get(afhentOrdre)+" er blevet afhentet nu.");
                    bestillingsListe.remove(afhentOrdre);
                }
            } else if (erDuMarioEllerAlfonzo == 3){ // Mikkel har kodet her
                for (int i = 0; i < ordreStatistik.length; i++) { // "Lukning af butik" + "dagens statistik".
                    System.out.println("Pizza nummer: "+(i+1)+" har solgt: "+ordreStatistik[i]+" idag."); //i + 1 for at ramme det rigtige indeks.
                }

                inputChecker = true; // Sætter loop'et true og lukker det.
            }
            else {
                System.out.println("Tast 1 eller 2!"); // En enkelt omgang hvad nu hvis Alfonzo/Mario ikke kan finde ud af at skrive det, vi beder dem om.
            }
        }
    }
}
