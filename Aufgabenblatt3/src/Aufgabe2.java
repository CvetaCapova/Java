/*
    Aufgabe 2) Überladen von Methoden
*/
public class Aufgabe2 {

    public static void addTags(String text, char tag) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int middle = text.length() / 2;
        if (text.length() % 2 != 0) {
            middle += 1;
        }
        String newText = tag + text.substring(0, middle) + tag + text.substring(middle) + tag;
        System.out.println(newText);
    }

    public static void addTags(int number, char tag) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int countDigits = 0;
        int num = number;
        while (num > 0) {
            num /= 10;
            countDigits++;
        }

        int middle = countDigits / 2;
        String output;
        int firstMiddle = (int) (number / Math.pow(10, middle));

        int secondMiddle = (int) (number - firstMiddle * (Math.pow(10, middle)));
        if (number < 10) {
            output = "" + tag +firstMiddle+ tag + tag;
        } else {
            output = "" + tag + firstMiddle + tag + secondMiddle + tag;
        }
        System.out.println(output);
    }

    public static void addTags(String text, String tags) {
        //TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        for (int i = 0; i < tags.length(); i++) {
            addTags(text,tags.charAt(i));
        }

    }

    public static void main(String[] args) {
        String text0 = "A";
        String text1 = "AB";
        String text2 = "Hello World!";//12
        String text3 = "Java-Programmierung";//19
        String text4 = "Das ist ein Test";//16

        addTags(text0, '?');
        addTags(text1, ',');
        addTags(text2, ':');
        addTags(text3, '+');
        addTags(text4, '-');

        addTags(1, '$');
        addTags(35, '*');
        addTags(2048, '#');
        addTags(657, ':');
        addTags(26348, '+');

        addTags(text2, "+#$");
        addTags(text3, ":*&!");
    }
}
/*
In der Methode die Variable tag mit X initialisieren
 */