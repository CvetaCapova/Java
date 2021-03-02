/*
    Aufgabe 1) Code Analyse - Eindimensionale Arrays
*/
public class Aufgabe1 {
    
    private static void genArray(int[] filledArray){
        int value = 2;
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = value;
            value += 2;
        }
    }
    
    private static void printFilteredArrayContent(int[] workArray){
        int[] copiedArray = workArray;
        for (int i = 0; i < copiedArray.length; i++) {
            if(copiedArray[i] % 3 == 0){
                copiedArray[i] = 0;
            }
        }
        printArray(copiedArray);
    }
    
    private static void genNewArrayContent(int[] workArray){
        int[] helpArray = new int[20];
        int value = 4;
        for (int i = 0; i < helpArray.length; i++) {
            helpArray[i] = value;
            value += 4;
        }
        workArray = helpArray;
        printArray(workArray);
    }
    
    private static void printArray(int[] workArray){
        for (int i = workArray.length-1; i >= 0; i--) {
            System.out.print(workArray[i]+ " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] filledArray = new int[20];
        genArray(filledArray);
        printArray(filledArray);
        
        printFilteredArrayContent(filledArray);
        printArray(filledArray);
        
        filledArray[0] = 1000;
        printArray(filledArray);
        
        genNewArrayContent(filledArray);
        printArray(filledArray);
    }
    
    //**************************************************************************
    //**** Notizen und Fragebeantwortungen bitte hier unterhalb durchführen! ***
    //**************************************************************************
    //Frage 1:
    //Der Fehler war, dass die for-Schleife von der Länge des Arrays beginnt. Aber das letzte Index bei dem Array lenght-1 ist. Darüber hinaus soll die Schleife bis größer gleich 0 sein.
    //Frage 2:
    //Die Methode genArray() hat keinen Rückgabewert, weil das Array in der Methode dieselbe Referenz wie das Array im main hat und die Änderungen global sind.
    //Frage 3:
    //Die Ausgaben sind gleich, weil wenn wir in der Methode printFilteredArrayContent() eine Kopie schaffen, hat die Kopie dieselbe Referenz wie das Array in main. Folglich bei Änderung eines Werts in copiedArray, wird auch filledArray geändert.
    //Frage 4:
    //In der Methode genNewArrayContent() bekommt das dort verwendete Array eine neue Referenz und nämlich die Referenz von helpArray. Folglich wird das filledArray in main unverändert.
    /*
    Zusatzfragen:
    1)int- Datentyp von Index
    2)Es ist nicht notwendig, weil alle Array-Elemente automatisch initialisiert werden.
    3)Die Länge eines Arrays kann nicht verändert sein, sondern man muss ein neues Array initialisieren.
    4)Um ein Array zu kopieren, gibt es zwei Möglichkeiten. Entweder eine for-Schleife und ein neues Array verwenden, oder die Methode System.arraycopy verwenden.
    5)Ja, die Indexzahlung eines Arrays beginnt immer bei 0.
    6)"==" vergleicht, ob zwei Arrays die gleichen Referenzen haben, aber vergleicht ihren Inhalt nicht.
     */

}

