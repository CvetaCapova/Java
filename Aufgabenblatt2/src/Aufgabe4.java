/*
    Aufgabe 4) Grafische Aufbereitung v. "GuessingGame" und Verwendung v. Methoden
*/

import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class Aufgabe4 {


    //TODO: Implementieren Sie hier Ihre Methoden
    private static char randomChar() {
        int a = 'a'; //97
        int z = 'z'; // 122
        double r = (Math.random() * (z - a + 1)) + a;
        int random = (int) (r);
        return (char) random;
    }

    private static char guessChar() {
        Scanner scanner = new Scanner(System.in);
        boolean isRightChar = false;
        char guessChar='a';

        while (scanner.hasNext() && isRightChar!=true) {
            if (scanner.hasNextInt()) {
                isRightChar = false;
                System.out.println("Falsche Eingabe!");
                scanner.next();
            } else {
                String input = scanner.next();
                if (input.length() != 1) {
                    isRightChar=false;
                    System.out.println("Falsche Eingabe!");

                } else {
                    char guess = input.charAt(0);
                    if (guess < 'a' || guess > 'z') {
                        isRightChar=false;
                        System.out.println("Falsche Eingabe!");

                    } else {
                        isRightChar=true;
                        guessChar=guess;
                        break;
                    }
                }
            }

        }
        return guessChar;

    }

    private static void printMessege(char guess, char random, int countGuesses){
        if(guess!=random && countGuesses==0){
            System.out.println("Verloren!");
        }
        else if(guess==random){
            System.out.println("Gewonnen!");
        }else if(guess>random){
            System.out.println("Der gesuchte Buchstabe ist kleiner als der Ratversuch! ");
        }else if (guess<random){
            System.out.println("Der gesuchte Buchstabe ist größer als der Ratversuch! ");
        }


    }
    public static void main(String[] args) {

        char random = randomChar();



        for (int i = 5; i >=0; i--) { //we have 5 tries
            char guessChar = guessChar();
            drawWindow(i,random,guessChar);

            if(guessChar==random){ //random char found
                printMessege(guessChar,random,i);
                break;
            }else{ //print the wrong char and continue searching
                if(i==0){ //the game is losed, this was the last wrong try
                    printMessege(guessChar,random,i);
                }else{

                    printMessege(guessChar,random,i);
                }
            }


        }




        //TODO: Implementieren Sie hier Ihr "GuessingGame"
    }



    private static void drawWindow(int countGuesses, char random , char guess){
        int pixelWidth = 600;
        int pixelHeight = 300;
        StdDraw.setCanvasSize(pixelWidth, pixelHeight);
        StdDraw.setXscale(0, pixelWidth);
        StdDraw.setYscale(0, pixelHeight);
        int distance = Math.abs(random-guess);
        StdDraw.setPenColor(Color.gray);
        StdDraw.setPenRadius(0.005);
        StdDraw.rectangle(300,150,270,60);
        StdDraw.setPenColor(Color.black);
        StdDraw.setPenRadius(0.010);
        StdDraw.text(300,175,"Distanz zwischen den Buchstaben:");
        StdDraw.setPenColor(Color.green);
        StdDraw.filledRectangle(55,125,2,25);
        StdDraw.setPenColor(Color.red);
        StdDraw.filledRectangle(555,125,2,25);
        StdDraw.setPenColor(Color.orange);
        StdDraw.filledRectangle(55+(distance*10),125,distance*10,25);
        StdDraw.setPenColor(Color.blue);
        StdDraw.text(300,45,"Sie haben noch "+countGuesses+ " Versuch(e)!");
        String text="";
        if (distance==0){
            text="Gewonnen!";
            StdDraw.setPenColor(Color.green);
        }else if (distance!=0 && countGuesses==0){
            text="Verloren!";
            StdDraw.setPenColor(Color.red);
        }
        StdDraw.setPenRadius(0.008);
        Font font = new Font("Arial", Font.BOLD, 23);
        StdDraw.setFont(font);
        StdDraw.text(300,255,text);


    }

}
