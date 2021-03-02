import java.lang.ref.SoftReference;

/*
    Aufgabe 3) Verschachtelung von Schleifen und Methoden - Fröhliche Zahlen
*/
public class Aufgabe3 {

    private static boolean isHappyNumber(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        assert number > 0 : number + "is negative";
        int sum = 0;

        while (number > 0) {
            sum += Math.pow((number % 10), 2);
            number /= 10;
        }
        int sumOld = sum; //keeps the old value of sum
        int sumNew; //keeps the value of the new sum

        while (sumOld > 5 || sumOld==3) { //
            sumNew = 0;
            while (sumOld > 0) {
                sumNew += Math.pow((sumOld % 10), 2);
                sumOld /= 10;
            }
            sumOld = sumNew;
        }


        //System.out.println(sumOld);

        if (sumOld == 1) {
            return true;
        } else {
            return false; //Zeile kann geändert oder entfernt werden.
        }


    }


    private static int countHappyNumbers(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        assert (start > 0 && end > 0 && (start <= end)) : "start or end is negative or start is bigger than end";
        int countNums = 0;
        for (int i = start; i <= end; i++) {
            if (isHappyNumber(i) == true) {
                countNums++;
            }

        }
        return countNums; //Zeile kann geändert oder entfernt werden.
    }

    private static void printHappyNumbers(int start, int end) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        assert (start > 0 && end > 0 && (start <= end)) : "start or end is negative or start is bigger than end";
        for (int i = start; i <= end; i++) {
            if (isHappyNumber(i) == true) {
                System.out.print(i + " ");
            }

        }
        System.out.println();
    }

    public static void main(String[] args) {
        ///DIE NACHFOLGENDEN ZEILEN SIND ZUM TESTEN DER METHODE isHappyNumber(...).
       System.out.println("23 --> " + isHappyNumber(23));
        assert (isHappyNumber(23));
        System.out.println("97 --> " + isHappyNumber(97));
        assert (isHappyNumber(97));
        System.out.println("7 --> " + isHappyNumber(7));
        assert (isHappyNumber(7));
        assert (isHappyNumber(1));
        System.out.println("58 --> " + isHappyNumber(58));
        assert (!isHappyNumber(58));
        System.out.println("40 --> " + isHappyNumber(40));
        assert (!isHappyNumber(40));
        System.out.println("5 --> " + isHappyNumber(5));
        assert (!isHappyNumber(5));
        assert (!isHappyNumber(4));
        System.out.println();





        //**********************************************************************
        //TODO: Testen Sie hier alle Methoden mit verschiedenen Inputs!
        System.out.println(countHappyNumbers(19, 23));
        printHappyNumbers(19, 23);
        System.out.println(countHappyNumbers(1, 54));
        printHappyNumbers(1, 54);
        System.out.println(countHappyNumbers(7, 9));


    }
}

/*
Zusatzfrage:
   1) Es gibt keine Begrenzung.
   2) Nein, weil es nur einen Rückgabewert hat.
 */
