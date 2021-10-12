import java.util.ArrayList;
import java.util.Scanner;


public class Pizzabar {

    public static void menukort(){
        Pizza.menukort();
    }

    public static void createNewOrdre(){
        Order.createNewOrdre();
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
                    inputChecker = true;
                }
                //inputChecker = true;
            } else if (erDuMarioEllerAlfonzo == 2) {
                System.out.println("Skriv 1 for at lave en ny ordre, 2 for at markere en ordre afhentet.");
                int alfonzosValg = scanner.nextInt();
                if (alfonzosValg == 1){
                    createNewOrdre();
                } else if (alfonzosValg == 2){
                    inputChecker = true;
                }
                //inputChecker = true;
            } else if (erDuMarioEllerAlfonzo == 3){
                inputChecker = true;
            }
            else {
                System.out.println("Skriv nu 1 eller 2 din idiot <3");
            }
        }
        //menukort();
        //createNewOrdre();

        ArrayList<Integer> orderID = new ArrayList<Integer>();
        orderID.add(1);



    }
}
