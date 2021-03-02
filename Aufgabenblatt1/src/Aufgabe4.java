import java.awt.*;

/*
    Aufgabe 4) Dynamische Elemente in Verbindung mit StdDraw und Schleifen
*/
public class Aufgabe4 {
    
    public static void main(String[] args) {

        // TODO: Implementieren Sie hier Ihre Lösung für die Angabe

        StdDraw.setCanvasSize(250,500);
        StdDraw.setXscale(0,250);
        StdDraw.setYscale(0,500);

        int radius = 10;
        StdDraw.setPenColor(Color.RED);
        for (int i = 0; i < 240; i++) { //down left side
            StdDraw.filledCircle(10,250-i,10);
        }
        StdDraw.pause(5);
        for (int i = 0; i < 250; i++) { //down side
            StdDraw.filledCircle(i,10,10);
        }
        StdDraw.pause(5);
        for (int i = 0; i < 500; i++) { //right side
            StdDraw.filledCircle(240,10+i,10);
        }
        StdDraw.pause(5);

        for (int i = 0; i < 250; i++) { //upper side
            StdDraw.filledCircle(250-i,490,10);
        }
        StdDraw.pause(5);
        for (int i = 0; i < 240; i++) { //upper left side
            StdDraw.filledCircle(10,500-i,10);
        }
        StdDraw.pause(5);

        for (int i = 0; i < 250; i++) { //middle side
            StdDraw.filledCircle(i,250,10);
        }

    }


}

/*Zusatzfrage:
Ich bin der Meinung, dass es besser ist, eine for-Schleife zu verwenden, weil auf diese Weise man i beim Zeichnen verwenden kann.
 */
