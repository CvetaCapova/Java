import java.util.Scanner;

/*
    Aufgabe 2) Verzweigungen
*/
public class Aufgabe2 {
    
    public static void main(String[] args) {

        //A) Anzahl der Stellen einer Zahl
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.next();
        int lenght = inputText.length();
        String output;

        //1. Art
        if(lenght==1){
            output="einstellig";
        }else if (lenght==2){
            output="zweistellig";
        }else if (lenght==3){
            output="dreistellig";
        }else if (lenght==4){
            output="vierstellig";
        }else {
            output="fünf- oder mehrstellig";
        }
        System.out.println("Ergebnis 1: "+output);

        //2.Art
        output="einstellig";
        if (lenght!=1){
            output = "zweistellig";
            if (lenght!=2){
                output = "dreistellig";
                if (lenght !=3){
                    output = "vierstellig";
                    if(lenght !=4){
                        output = "fünf- oder mehrstellig";
                    }
                }
            }
        }

        System.out.println("Ergebnis 2: "+output);

        /*
        Zusatzfragen:
        1. Man kann eine if-Anweisung ohne else-Zweig verwenden, aber es ist nicht empfehlenswert, weil auf diese Weise man nicht alle Fälle betrachten kann.
        2.Falls es ein else if-Zweig ist, gibt es keine Begrenzungen. Fall es ein else-Zweig ist, kann nur ein zu einem if-Zweig geschrieben wird.
        3.Nein, break ist bei Schleifen und bei switch verwendet.
         */


        
        //B) Einteilung des UV-Index in verschiedene Kategorien.
        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe
        int uvIndex = scanner.nextInt();
        String outputUVIndex;

        switch (uvIndex){
            case 0: outputUVIndex="0";
                break;
            case 1:
            case 2:    outputUVIndex="niedrig";
                break;
            case 3:
            case 4:
            case 5:
                outputUVIndex ="mittel";
                break;
            case 6:
            case 7:
                outputUVIndex = "hoch";
                break;
            case 8:
            case 9:
            case 10:
                outputUVIndex="sehr hoch";
                break;
            default:
                outputUVIndex="extrem";
                break;
        }

        System.out.println("Die UV-Belastung ist --> "+outputUVIndex);

        /*
        Zusatzfragen:
        1. Ja, man kann das break auch weglassen, aber nur in manchen Fällen und nicht immer.
        2. Es ist nicht notwendig, einen default-Zweig zu verwenden, aber es ist empfehlenswert, um alle Fälle zu betrachten.
        3.Man kann switch statt if verwenden, aber auf diese Weise hat man zu viele else if-Zweigen.
         */

    }
}

