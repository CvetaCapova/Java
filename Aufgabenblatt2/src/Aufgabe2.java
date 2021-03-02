import java.util.Scanner;

/*
    Aufgabe 2) Verschachtelte Schleifen und Verzweigungen
*/
public class Aufgabe2 {
    
    public static void main(String[] args) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        Scanner scanner = new Scanner(System.in);
        int figHeight = scanner.nextInt();
        //int figHeight = 15;
        int countPlus = figHeight/2; //returns rounded number
        int countNums=0;
        for (int i = 0; i < figHeight/2+1; i++) { //prints the first half
           countNums=figHeight-(2*countPlus-1)-2; // the count of the numbers is
           if(i!=figHeight/2){
               printPlus(countPlus);
               System.out.print('/');
               printNums(countNums);
               //printNums(countNums);
               System.out.print('\\');
               printPlus(countPlus);
               countPlus--;
           }else {
               System.out.print('|');
               printNums(countNums);
               //printNums(countNums);
               System.out.print('|');
           }
            System.out.println();

        }


        countPlus++;
        countNums-=2;


        for (int i = figHeight/2; i > 0; i--) {
            printPlus(countPlus);
            System.out.print('\\');
            printNums(countNums);
           // printNums(countNums);
            System.out.print('/');
            printPlus(countPlus);
            countPlus++;
            countNums=figHeight-(2*countPlus+1);
            System.out.println();
        }

    }

    private static void printPlus(int countPlus){
        for (int i = 0; i < countPlus; i++) {
            System.out.print('+');
        }
    }

    private static void printNums(int countNums){

        for (int i = 0; i < countNums/2; i++) {
            if ((countNums/2)%2==0){ //if the first half is even, it begins with 1
                if (i%2==0){
                    System.out.print('1');
                }else {
                    System.out.print('0');
                }
            }else { //if the first half is odd, it begins with 0
                if (i%2==0){
                    System.out.print('0');
                }else {
                    System.out.print('1');
                }
            }
        }

        for (int i = 0; i < countNums/2; i++) {
            if (i%2==0){
                System.out.print('0');
            }else {
                    System.out.print('1');
            }

        }



    }

}

