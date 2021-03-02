/*
    Aufgabe 3) Rekursion - Blumenmuster mit Kreisbögen
*/
public class Aufgabe3 {
    
    private static void drawArcPattern(int x, int y, int radius) {
        if (radius>=8){
            StdDraw.arc(x+radius,y,radius,270,90);//rechts
            StdDraw.arc(x-radius,y,radius,90,270);//links
            StdDraw.arc(x,y+radius,radius,0,180);//oben
            StdDraw.arc(x,y-radius,radius,180,0);//unten
            drawArcPattern(x+radius,y,radius/2);
            drawArcPattern(x-radius,y,radius/2);
            drawArcPattern(x,y+radius,radius/2);
            drawArcPattern(x,y-radius,radius/2);
            StdDraw.enableDoubleBuffering();
            StdDraw.show();


        }
    }
    
    public static void main(String[] args) {
        StdDraw.setCanvasSize(512,512);
        StdDraw.setYscale(-512/2,512/2);
        StdDraw.setXscale(-512/2,512/2);
        drawArcPattern(0,0,128);




    }
}

/*
Zusatzfragen:
1) 128= 2^7 => 5 Mal
2) 32 = 2^5 Kreisbögen
3) Nur diese Rekursionen zu führen:
            drawArcPattern(x-radius,y,radius/2); //links
            drawArcPattern(x,y+radius,radius/2); //oben
 */



