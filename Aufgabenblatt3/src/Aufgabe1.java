/*
    Aufgabe 1) Codeanalyse, Codingstyle und Methoden
*/
public class Aufgabe1 {

    public static void main(String args[]) {
        System.out.println(orderedString("ab")); //ruft die Methode auf und gibt das Ergebnis aus
        System.out.println(orderedString("ba"));
        System.out.println(orderedString("aa"));
        System.out.println(orderedString("cba"));
        System.out.println(orderedString("abababab"));
        System.out.println(orderedString("abcfghed"));
        System.out.println(orderedString("abnasnasab"));
        System.out.println(orderedString("najskaghkkjsfvjhbavbdfsan"));
        System.out.println(orderedString("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv"));

        assert (orderedString("ab").equals("ab")); //prüft ob die Methode funktioniert, d.h. ob der String in alphabetischer Reihenfolge ist
        assert (orderedString("ba").equals("ab"));
        assert (orderedString("aa").equals("aa"));
        assert (orderedString("cba").equals("abc"));
        assert (orderedString("abababab").equals("aaaabbbb"));
        assert (orderedString("abcfghed").equals("abcdefgh"));
        assert (orderedString("abnasnasab").equals("aaaabbnnss"));
        assert (orderedString("najskaghkkjsfvjhbavbdfsan").equals("aaaabbdffghhjjjkkknnsssvv"));
        assert (orderedString("jgbgdsjabkjdbvbdjabkjsavbkjbdsvkjbagfgafjdbv").equals("aaaaabbbbbbbbbdddddffggggjjjjjjjjkkkksssvvvv"));
    }

    public static String orderedString(String stringInput) { //gibt den String in alphabetischer Reihenfolge

        int length = stringInput.length();
        for (int i = 1; i < length; i += 1) {
            char charAtI = stringInput.charAt(i);
            int j = i - 1;
            while (j >= 0 && ( stringInput.charAt(j)>= charAtI)) { //prüft, ob die Buchstaben vor chartAt(i) kleiner sind
                j -= 1;
            }
            j += 1; //die Buchstaben bis Poistion j sind kleiner als charAt(i)
            stringInput = stringInput.substring(0,j) + charAtI + stringInput.substring(j,i) + stringInput.substring(i+1,length) ;
            //der erste Substring gibt die kleinsten Buchstaben, danach wird charAt(i) ausgegeben, danach die Buchstaben von Position j bis i(außer i) und am Ende die Buchstaben von i+1 bis Ende des Strings
        }
        return stringInput;
    }

    /*public static int StringLenght(String stringInput) { //  gibt die Länge des Strings aus
        return stringInput.length();
    }


    public static int increaseWithOne(int n) { //gibt den Wert addiert mit 1 aus
        return n + 1;
    }


    public static int decreaseWithOne(int n) { //gibt den Wert subtrahiert mit 1 aus
        return n - 1;
    }


    public static boolean biggerNum(int n1, int n2) { // bekommt zwei Werte und gibt den Größeren aus
        return n1 >= n2;
    }


    public static boolean biggerChar(char c1, char c2) { // bekommt zwei Symbole und gibt das Größere aus
        return c1 >= c2;
    }


    public static String substring(String stringInput, int startIndex, int endIndex) { //bekommt einen String und zwei Wetre und gibt einen Substring aus
        return stringInput.substring(startIndex, endIndex);
    }

*/
}



