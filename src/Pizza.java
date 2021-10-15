import java.util.Arrays;
import java.util.Scanner;

// Pizza klassen er blevet kodet af Elisa
public class Pizza {
    private int nummer;
    private String navn;
    private int pris;

    public Pizza(int nummer, String navn, int pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.pris = pris;
    }
    public static void menukort(){ // Printer menukort når det bliver kaldt.
        System.out.println("1. Margherita..............50 kr.");
        System.out.println("2. Pepperoni...............60 kr.");
        System.out.println("3. capricciossa............72 kr.");
        System.out.println("4. Solo Mio................75 kr.");
        System.out.println("5. Italiana................80 kr.");
    }

    public int getNummer() {
        return nummer;
    }

    @Override
    public String toString() {
        return "Pizza" +
                "nummer = " + nummer + ", navn = " + navn + ", pris = " + pris +"kr.";
    }
}

