/*
    Aufgabe 1) Variablen, Datentypen, Typumwandlungen und Strings
*/
public class Aufgabe1 {
    
    public static void main(String[] args) {
        
        // A) Variablen Deklarationen und Typecasting
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        float num1 = 314.15e-2f;
        float num2 = 3.1f;
        double num3 = 0.000314159e4;
        double num4 = 3.14159;
        int hex = 0x11;
        int oct = 011;
        long numLong = 11L;
        char three = '3';
        byte numByte= 127;  //b)
        short numShort = 128;   //b)
        String text = num1 +", "+ num2+", " + num3+", " + num4+", " + hex +", "+ oct +", "+ numLong+", " + three+", " + numByte+", "+numShort;
        System.out.println(text);
        double product = num1*num2*num3*num4*hex*oct*numLong*three*numByte*numShort;
        System.out.println(product);
        long productLong = hex*oct*((int)three)*numByte*numShort*numLong*((int)num1)*((int)num2)*((int)num3)*((int)num4);
        System.out.println(productLong);
        int sum = (int)(num1 + num2 + num3 + num4+ hex + oct + numLong + three + numByte+numShort);
        System.out.println(sum);
        int sumByte = (byte)num1 + (byte)num2 + (byte)num3 + (byte)num4+ (byte)hex +(byte)oct +(byte)numLong +(byte)three +numByte+(byte)numShort;
        System.out.println(sumByte);
        String s1 = "Zeichenkette";
        int i1=4;
        char c1 = 'b';
        System.out.println(s1+i1+c1);
        System.out.println(i1+c1+s1);

        /*
        Zusatzfragen:
        1. Die Ausgabe ist nicht gleich zu den Literalen, weil erst ihren Wert berechnet wird und danach sie mit Beistrichen verknüpft werden.
        2. Die Variablen, die die Unterschiede verursachen, sind:
            float num1 = 314.15e-2f;
            float num2 = 3.1f;
            double num3 = 0.000314159e4;
            double num4 = 3.14159;
         Weil bei f) sie erst addiert und danach umgewandelt werden, wobei bei g) genau umgekehrt ist.
         3. Wenn man ein Wert von kleinerem Typ in größeren Typ umwandelt, wird das automatisch. Anderenfalls muss es explizit gemacht werden.
         4. Bei s1+i1+c1 werden die Variablen in einen String konkateniert und bei i1+c1+s1 wird die Summe von i1+c1 ausgerechnet und erst danach mit dem String konkateniert.
         */



        // B) String API kennenlernen und anwenden
        // Link zum Nachlesen:
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
        
        String sentence = "Es stehen viele Methoden für die Stringmanipulation zur Verfügung!";
        
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        //Teilaufgabe B
        System.out.println("Index 16: "+ sentence.charAt(16));
        System.out.println("Lenght text:" + sentence.length());
        System.out.println("Is empty: "+sentence.isEmpty());
        System.out.println("Whether with Es starts: "+sentence.startsWith("Es"));
        String index0 = sentence.substring(0,25);
        String index52 = sentence.substring(52);
        System.out.println("Index 0-25: "+index0);
        System.out.println("Index 52 to the end: " + index52);
        String concatStrings = index0.concat(index52);
        System.out.println("Concat strings:" + concatStrings);
        String replaced = sentence.replaceAll("i","I");
        System.out.println("Replaced i in string: "  + replaced);
        String bearbeitung = sentence.replace("Stringmanipulation","Bearbeitung");
        System.out.println("Replaced word: " + bearbeitung);
        String smallLetters = sentence.toLowerCase();
        System.out.println("Lower case: "+ smallLetters);
        String largeLetters = sentence.substring(33,51).toUpperCase();
        System.out.println("String Index 33-51, Upper Case "+ largeLetters);




        /*
        Zusatzfrage:
        Wir können zuerst einen neuen String initialisieren, z.B mit dem Namen newText.
        Mit der Hilfe von einer for- Schleife. Für das Beispiel nehmen wir, dass unser StartIndex 5 ist und unser EndIndex 10 ist.

        String newText;
        int startIndex = 5;
        int endIndex = 10;
        for(i=startIndex; i<=EndIndex; i++){
            newText+= sentence[i];
        }

        */
    }
}




