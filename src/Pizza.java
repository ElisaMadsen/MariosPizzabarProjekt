import java.util.Arrays;
import java.util.Scanner;

// Pizza klassen er blevet kodet af Elisa
public class Pizza {
    static Scanner scanner = new Scanner(System.in);
    private int nummer;
    private String navn;
    private int pris;

    public Pizza(int nummer, String navn, int pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
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
        int antalPizzaer = scanner.nextInt();

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
            Pizza pizzaChoice = menukort[scanner.nextInt() - 1];

            System.out.println(pizzaChoice);
        }
    }

    public int getNummer() {
        return nummer;
    }

    public String getNavn() {
        return navn;
    }

    public int getPris() {
        return pris;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public void setName(String navn) {
        this.navn = navn;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    @Override
    public String toString() {
        return "Pizza" +
                "nummer = " + nummer + ", navn = " + navn + ", pris = " + pris +"kr.";
    }
}

