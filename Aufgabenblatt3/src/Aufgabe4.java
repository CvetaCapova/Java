/*
    Aufgabe 4) Rekursion
*/
public class Aufgabe4 {

    private static void printNumbersAscending(int start, int end, int divider) { //10,20
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode

        if (start <= end) {

            printNumbersAscending(start, end - 1, divider);
            if (end % divider == 0) {
                System.out.println(end);
            }

        }


    }

    private static void printNumbersDescending(int start, int end, int divider) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (start <= end) {
            if (end % divider != 0) {
                System.out.println(end);
            }
            printNumbersDescending(start, end - 1, divider);

        }

    }

    private static int calcDigitProduct(int number) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (number < 10) {
            return number;
        } else {
            if (number % 10 != 0) {
                return calcDigitProduct(number / 10) * (number % 10);
            } else {
                return calcDigitProduct(number / 10);
            }

        }

    }

    private static String filterNumbersInString(String text) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (text.length() <= 0) {
            return text;
        } else {

            if (text.charAt(text.length() - 1) < '0' || text.charAt(text.length() - 1) > '9') {
                return filterNumbersInString(text.substring(0, text.length() - 1)) + text.charAt(text.length() - 1);
            } else {
                return filterNumbersInString(text.substring(0, text.length() - 1));
            }

        }


    }

    private static String reverseStringDoubleLetter(String text, char letter) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Methode
        if (text.length() <= 0) {
            return text;
        } else {
            if (text.charAt(0)==letter) {
                return reverseStringDoubleLetter(text.substring(1), letter) + text.charAt(0) + letter;
            }else {
                return reverseStringDoubleLetter(text.substring(1), letter) + text.charAt(0);

            }
        }

    }

    public static void main(String[] args) {
        printNumbersAscending(10, 20, 2);
        System.out.println();
        printNumbersDescending(5, 15, 3);
        System.out.println();

        System.out.println(calcDigitProduct(1));
        System.out.println(calcDigitProduct(102));
        System.out.println(calcDigitProduct(1234));
        System.out.println(calcDigitProduct(10000));
        System.out.println(calcDigitProduct(93842));
        System.out.println(calcDigitProduct(875943789));
        assert (calcDigitProduct(1) == 1);
        assert (calcDigitProduct(102) == 2);
        assert (calcDigitProduct(1234) == 24);
        assert (calcDigitProduct(10000) == 1);
        assert (calcDigitProduct(93842) == 1728);
        assert (calcDigitProduct(875943789) == 15240960);
        System.out.println();

        System.out.println(filterNumbersInString("hallo"));
        System.out.println(filterNumbersInString("Test 1 mit 45 Punkten!"));
        System.out.println(filterNumbersInString("1A1234567890B0"));
        System.out.println(filterNumbersInString("a1b2c3d4e5"));
        System.out.println(filterNumbersInString(""));
        assert (filterNumbersInString("hallo").equals("hallo"));
        assert (filterNumbersInString("Test 1 mit 45 Punkten!").equals("Test  mit  Punkten!"));
        assert (filterNumbersInString("1A1234567890B0").equals("AB"));
        assert (filterNumbersInString("a1b2c3d4e5").equals("abcde"));
        assert (filterNumbersInString("").equals(""));
        System.out.println();
    
        System.out.println(reverseStringDoubleLetter("X", 'X'));
        System.out.println(reverseStringDoubleLetter("Hallo", 'l'));
        System.out.println(reverseStringDoubleLetter("String umdrehen!", 'z'));
        assert(reverseStringDoubleLetter("X", 'X').equals("XX"));
        assert(reverseStringDoubleLetter("Hallo", 'l').equals("ollllaH"));
        assert(reverseStringDoubleLetter("String umdrehen!", 'z').equals("!neherdmu gnirtS"));
        assert(reverseStringDoubleLetter("ABACADAFA", 'A').equals("AAFAADAACAABAA"));
        assert(reverseStringDoubleLetter("", 'A').equals(""));


    }
}

/*
    Fundiertheit- es existiert eine erreichbare Abbruchbedingung
    Fortschritt- wenn eine Methode zu der Abbruchbedingung sich nähert
    Abbruchbedingung- um eine Ende zu haben und nicht immer und immer sich aufzurufen
    Ja, soweit es noch Speicherplatz gibt

 */

